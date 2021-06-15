package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Estado;
import casadocodigo.casadocodigo.entities.Pais;
import casadocodigo.casadocodigo.util.validators.ExistsId;
import casadocodigo.casadocodigo.util.validators.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoDTO {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nomeEstado")
    private String nomeEstado;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName="idPais")
    private Long idPais;

    public EstadoDTO(@NotBlank String nomeEstado, @NotNull Long idPais) {
        this.nomeEstado = nomeEstado;
        this.idPais = idPais;
    }


    @Override
    public String toString() {
        return "EstadoDTO{" +
                "nomeEstado='" + nomeEstado + '\'' +
                ", idPais=" + idPais +
                '}';
    }

    public Estado toModel(EntityManager manager){

        Pais pais = manager.find(Pais.class, idPais);
        return new Estado(nomeEstado, pais);

    }
}
