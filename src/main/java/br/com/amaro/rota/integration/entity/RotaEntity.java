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
@Table(name = "Rota")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RotaEntity {
    @Id
    @NotNull
    private String rotaId;

    @NotNull
    private String codRota;

    @NotNull
    private String clienteId;

    @NotNull
    private Character flColetor;

    @NotNull
    private Character flAtiva;
}
