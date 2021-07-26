package br.com.amaro.rota.integration.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @NotNull
    private String clienteId;

    @NotNull
    private String nome;

    @NotNull
    private String endereco;

    @NotNull
    private String telefone;

    @NotNull
    private String nuCpfCnpj;

    @NotNull
    private String tipo;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;
}
