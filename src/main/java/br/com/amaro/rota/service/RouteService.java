package br.com.amaro.rota.service;

import br.com.amaro.rota.controller.dto.UsuarioDTO;
import br.com.amaro.rota.controller.util.UsuarioMapper;
import br.com.amaro.rota.integration.RotaRepository;
import br.com.amaro.rota.integration.UsuarioRepository;
import br.com.amaro.rota.integration.entity.RotaEntity;
import br.com.amaro.rota.integration.entity.UsuarioEntity;
import br.com.amaro.rota.service.model.LocalizacaoModel;
import org.hibernate.query.spi.DoubleStreamDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RouteService {

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<?> geraRotaCatador(String clienteId){

        UsuarioEntity catadorEntity = usuarioRepository.findByClienteId(clienteId);
        BigDecimal latitudeCatador = new BigDecimal(catadorEntity.getLatitude());
        BigDecimal longitudeCatador = new BigDecimal(catadorEntity.getLatitude());

        List<RotaEntity> rotaEntities = rotaRepository.findAllByFlColetor('N');

        HashMap<UsuarioEntity, Integer> usuarioEntities = new HashMap<>();
        rotaEntities.parallelStream()
                .forEach(rota -> {
                    UsuarioEntity usuarioEntity = usuarioRepository.findByClienteId(rota.getClienteId());
                    BigDecimal latitudeConsumidor = new BigDecimal(usuarioEntity.getLatitude());
                    BigDecimal longitudeConsumidor = new BigDecimal(usuarioEntity.getLatitude());
                    usuarioEntities.put(usuarioEntity,((int) (calculaDistancia(latitudeCatador.doubleValue(),longitudeCatador.doubleValue(), latitudeConsumidor.doubleValue(),longitudeConsumidor.doubleValue()))));
                });
        Set<UsuarioDTO> retorno = sortByValue(usuarioEntities).keySet().stream().map(consumidor -> {
            return UsuarioMapper.entityToDto(catadorEntity);
        }).collect(Collectors.toSet());

        return ResponseEntity.ok().body(retorno);
    }

    public ResponseEntity<?> consultaRotaColetor(String clienteId){
        List<UsuarioEntity> lista = rotaRepository.findAllByCodRota(rotaRepository.findByClienteId(clienteId).getCodRota()).parallelStream()
                .map(rota -> {
                    return usuarioRepository.findByClienteId(rota.getClienteId());
                })
                .collect(Collectors.toList());
        ArrayList<UsuarioDTO> retorno = new ArrayList<>();
        lista.parallelStream()
                .forEach(entity -> {
                    retorno.add(UsuarioMapper.entityToDto(entity));
                });
        return ResponseEntity.ok().body(retorno);
    }

    public double calculaDistancia(double firstLatitude, double firstLongitude, double secondLatitude, double secondLongitude){
        // Conversão de graus pra radianos das latitudes
        double firstLatToRad = Math.toRadians(firstLatitude);
        double secondLatToRad = Math.toRadians(secondLatitude);

        // Diferença das longitudes
        double deltaLongitudeInRad = Math.toRadians(secondLongitude
                - firstLongitude);

        // Cálcula da distância entre os pontos
        return Math.acos(Math.cos(firstLatToRad) * Math.cos(secondLatToRad)
                * Math.cos(deltaLongitudeInRad) + Math.sin(firstLatToRad)
                * Math.sin(secondLatToRad))
                * 6.378;
    }

    public static LinkedHashMap<UsuarioEntity, Integer> sortByValue(final HashMap<UsuarioEntity, Integer> wordCounts) {

        return wordCounts.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
