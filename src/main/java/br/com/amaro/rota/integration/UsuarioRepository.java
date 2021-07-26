package br.com.amaro.rota.integration;

import br.com.amaro.rota.integration.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UsuarioRepository extends JpaRepository<UsuarioEntity,String> {
    boolean existsByClienteId(String clienteId);
    boolean existsByNuCpfCnpj(String nuCpfCnpj);
    UsuarioEntity findByClienteId(String clienteId);
}
