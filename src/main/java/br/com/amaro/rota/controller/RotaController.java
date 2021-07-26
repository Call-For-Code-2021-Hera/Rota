package br.com.amaro.rota.controller;

import br.com.amaro.rota.controller.dto.UsuarioDTO;
import br.com.amaro.rota.controller.util.UsuarioMapper;
import br.com.amaro.rota.integration.RotaRepository;
import br.com.amaro.rota.integration.UsuarioRepository;
import br.com.amaro.rota.integration.entity.RotaEntity;
import br.com.amaro.rota.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/rota")
public class RotaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private RouteService routeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/{clienteId}")
    public ResponseEntity<?> consultaRota(@PathVariable(value = "clienteId") String clienteId){
        if(usuarioRepository.existsByClienteId(clienteId)) {

            // Trata Coletor
            if (usuarioRepository.findByClienteId(clienteId).getTipo().equals("Catador")) {
                if(rotaRepository.existsByClienteId(clienteId)) {
                    if (rotaRepository.existsByClienteIdAnFlAtiva(clienteId, 'A')) {
                        return ResponseEntity.ok().body(routeService.consultaRotaColetor(clienteId));
                    } else {
                        return ResponseEntity.status(404).body("Usuário não possui rota cadastrada!");
                    }
                } else {
                    return ResponseEntity.status(404).body("Usuário não possui rota cadastrada!");
                }

                // Trata Consumidor
            } else {

                if (rotaRepository.existsByClienteId(clienteId)) {
                    if (rotaRepository.existsByClienteIdAnFlAtiva(clienteId, 'A')) {
                        return ResponseEntity.ok().body(UsuarioMapper.entityToDto(usuarioRepository.findByClienteId(clienteId)));
                    } else {
                        return ResponseEntity.ok().body("Sua solicitação ainda não foi atendida");
                    }
                } else {
                    return ResponseEntity.status(404).body("Não há rotas cadastrada para este cliente");
                }

            }
        } else{
            return ResponseEntity.status(404).body("Usuário não encontrado!");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{clienteId}")
    public ResponseEntity<?> cadastrarRota(@PathVariable(value = "clienteId")String clienteId){
        if(usuarioRepository.existsByClienteId(clienteId)) {
            if (usuarioRepository.findByClienteId(clienteId).getTipo().equals("Catador")) {

                //Trata Catador
                if(rotaRepository.existsByClienteId(clienteId)){
                    return ResponseEntity.status(400).body("Usuário já possui uma rota cadastrada!");
                } else{
                    return ResponseEntity.status(201).body(routeService.geraRotaCatador(clienteId));
                }


            }else{
                //Trata Consumidor
                if(rotaRepository.existsByClienteId(clienteId)){
                    return ResponseEntity.status(400).body("Já existe uma rota criada");
                } else {
                    UsuarioDTO usuarioDTO = UsuarioMapper.entityToDto(usuarioRepository.findByClienteId(clienteId));
                    rotaRepository.save(RotaEntity.builder()
                            .rotaId(UUID.randomUUID().toString())
                            .clienteId(clienteId)
                            .codRota(UUID.randomUUID().toString())
                            .flColetor('N')
                            .flAtiva('A')
                            .build());
                    return ResponseEntity.status(201).body(usuarioDTO);
                }
            }

        } else{
            return ResponseEntity.status(404).body("Usuário não encontrado!");
        }
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/{clienteId}")
    public ResponseEntity<?> atualizarRota(@PathVariable(value = "clienteId")String clienteId){
        if(usuarioRepository.existsByClienteId(clienteId)) {
            if (usuarioRepository.findByClienteId(clienteId).getTipo().equals("Catador")) {

                //Trata Catador
                if(rotaRepository.existsByClienteId(clienteId)){
                    return ResponseEntity.status(201).body(routeService.geraRotaCatador(clienteId));
                } else{
                    return ResponseEntity.status(404).body("Rota não encontrada!");
                }


            }else{
                //Trata Consumidor
                if(rotaRepository.existsByClienteId(clienteId)){
                    UsuarioDTO usuarioDTO = UsuarioMapper.entityToDto(usuarioRepository.findByClienteId(clienteId));
                    rotaRepository.save(RotaEntity.builder()
                            .rotaId(rotaRepository.findByClienteId(clienteId).getRotaId())
                            .clienteId(clienteId)
                            .codRota(UUID.randomUUID().toString())
                            .flColetor('N')
                            .flAtiva('A')
                            .build());
                    return ResponseEntity.status(201).body(usuarioDTO);
                } else {
                    return ResponseEntity.status(404).body("Rota não encontrada!");
                }
            }

        } else{
            return ResponseEntity.status(404).body("Usuário não encontrado!");
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<?> deletaRota(@PathVariable(value = "clienteId")String clienteId){
        if(usuarioRepository.existsByClienteId(clienteId)) {
            if (usuarioRepository.findByClienteId(clienteId).getTipo().equals("Catador")) {

                //Trata Catador
                if(rotaRepository.existsByClienteId(clienteId)){
                    // TODO Reabilitar rotas dos consumidores
                    rotaRepository.delete(rotaRepository.findByClienteId(clienteId));
                    return ResponseEntity.ok().body("Rota excluida com sucesso");
                } else{
                    return ResponseEntity.status(404).body("Rota não encontrada!");
                }


            }else{
                //Trata Consumidor
                if(rotaRepository.existsByClienteId(clienteId)){
                    rotaRepository.delete(rotaRepository.findByClienteId(clienteId));
                    return ResponseEntity.ok().body("Rota excluida com sucesso");
                } else {
                    return ResponseEntity.status(404).body("Rota não encontrada!");
                }
            }

        } else{
            return ResponseEntity.status(404).body("Usuário não encontrado!");
        }
    }
}
