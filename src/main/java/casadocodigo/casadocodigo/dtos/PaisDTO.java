package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Pais;
import casadocodigo.casadocodigo.util.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisDTO {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
    private String nomePais;



    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getNomePais() {
        return nomePais;
    }
}
