package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Cliente;
import casadocodigo.casadocodigo.entities.Estado;
import casadocodigo.casadocodigo.entities.Pais;
import casadocodigo.casadocodigo.util.validators.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDTO {


    @NotNull
    @NotBlank
    private String emailCliente;

    @NotBlank @NotNull
    private String nomeCliente;

    @NotBlank @NotNull
    private String sobrenomeCliente;

    @NotBlank @NotNull
    private String documentoCliente;

    @NotBlank @NotNull
    private String enderecoCliente;


    private String complementoEnderecoCliente;

    @NotNull @NotBlank
    private String cidade;


    @ExistsId(domainClass = Pais.class, fieldName="idPais")
    private Long idPais;


    @ExistsId(domainClass = Estado.class, fieldName="idEstado")
    private Long idEstado;
    //caso aquele pais tenha estado

    @NotNull @NotBlank
    private String telefone;

    @NotNull @NotBlank
    private String cep;

    public ClienteDTO(String emailCliente,
                      String nomeCliente,
                      String sobrenomeCliente,
                      String documentoCliente,
                      String enderecoCliente,
                      String complementoEnderecoCliente,
                      String cidade,
                      Long idPais,
                      Long idEstado,
                      String telefone,
                      String cep) {
        this.emailCliente = emailCliente;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.documentoCliente = documentoCliente;
        this.enderecoCliente = enderecoCliente;
        this.complementoEnderecoCliente = complementoEnderecoCliente;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }


    public Cliente toModel(EntityManager manager) {

        Pais pais = manager.find(Pais.class, idPais);
        Estado estado = manager.find(Estado.class, idEstado);
        return new Cliente(emailCliente,
                nomeCliente,
                sobrenomeCliente,
                documentoCliente,
                enderecoCliente,
                complementoEnderecoCliente,
                cidade,
                pais,
                estado,
                telefone,
                cep);
    }
}
