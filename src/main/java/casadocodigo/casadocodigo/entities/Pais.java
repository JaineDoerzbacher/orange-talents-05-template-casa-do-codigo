package casadocodigo.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PAIS")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAIS")
    private long idPais;

    @NotNull
    @NotBlank
    @Column(name = "NOME_PAIS")
    private String nomePais;


    public Pais(long idPais, String nomePais) {
        this.idPais = idPais;
        this.nomePais = nomePais;
    }

    public Pais() {
    }

    public Pais(String nomePais) {

        this.nomePais = nomePais;
    }
}
