package br.com.amaro.rota.integration;

import br.com.amaro.rota.integration.entity.RotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RotaRepository extends JpaRepository<RotaEntity, String> {
    boolean existsByClienteIdAnFlAtiva(String clienteId, Character flAtivo);
    boolean existsByClienteId(String clienteId);
    RotaEntity findByClienteId(String clienteId);
    List<RotaEntity> findAllByCodRota(String codRota);
    List<RotaEntity> findAllByFlColetor(Character codColetor);
}
