package casadocodigo.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private long idCliente;

    @NotNull
    @NotBlank
    @Column(name = "EMAIL_CLIENTE")
    private String emailCliente;

    @NotBlank @NotNull
    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;

    @NotBlank @NotNull
    @Column(name = "SOBRENOME_CLIENTE")
    private String sobrenomeCliente;

    @NotBlank @NotNull
    @Column(name = "DOCUMENTO_CLIENTE")
    private String documentoCliente;

    @NotBlank @NotNull
    @Column(name = "ENDERECO_CLIENTE")
    private String enderecoCliente;

    @Column(name = "COMPLEMENTO_CLIENTE")
    private String complementoEnderecoCliente;

    @NotNull @NotBlank
    @Column(name = "CIDADE_CLIENTE")
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS")
    private @NotNull @Valid Pais pais;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private  @Valid Estado estado;
    //caso aquele pais tenha estado

    @NotNull @NotBlank
    @Column(name = "TELEFONE_CLIENTE")
    private String telefone;

    @NotNull @NotBlank
    @Column(name = "CEP_CLIENTE")
    private String cep;

    public Cliente(long idCliente,
                   String emailCliente,
                   String nomeCliente,
                   String sobrenomeCliente,
                   String documentoCliente,
                   String enderecoCliente,
                   String complementoEnderecoCliente,
                   String cidade,
                   Pais pais,
                   Estado estado,
                   String telefone,
                   String cep) {
        this.idCliente = idCliente;
        this.emailCliente = emailCliente;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.documentoCliente = documentoCliente;
        this.enderecoCliente = enderecoCliente;
        this.complementoEnderecoCliente = complementoEnderecoCliente;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente() {
    }

    public Cliente(String emailCliente,
                   String nomeCliente,
                   String sobrenomeCliente,
                   String documentoCliente,
                   String enderecoCliente,
                   String complementoEnderecoCliente,
                   String cidade,
                   Pais pais,
                   Estado estado,
                   String telefone,
                   String cep) {
        this.emailCliente = emailCliente;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.documentoCliente = documentoCliente;
        this.enderecoCliente = enderecoCliente;
        this.complementoEnderecoCliente = complementoEnderecoCliente;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", emailCliente='" + emailCliente + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", sobrenomeCliente='" + sobrenomeCliente + '\'' +
                ", documentoCliente='" + documentoCliente + '\'' +
                ", enderecoCliente='" + enderecoCliente + '\'' +
                ", complementoEnderecoCliente='" + complementoEnderecoCliente + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

}
