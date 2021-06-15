package casadocodigo.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_ESTADO")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstado;

    @NotBlank
    @Column(name = "NOME_CATEGORIA")
    private String nomeEstado;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS")
    private @NotNull @Valid Pais pais;

    public Estado(long idEstado, String nomeEstado, Pais pais) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }

    public Estado() {
        super();
    }

    public Estado(String nomeEstado, Long idPais) {
    }

    public Estado(String nomeEstado, Pais pais) {
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }


    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", nomeEstado='" + nomeEstado + '\'' +
                ", pais=" + pais +
                '}';
    }
}
