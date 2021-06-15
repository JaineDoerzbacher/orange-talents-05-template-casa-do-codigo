package casadocodigo.casadocodigo.gateway.controller;
import casadocodigo.casadocodigo.dtos.ClienteDTO;
import casadocodigo.casadocodigo.entities.Cliente;
import casadocodigo.casadocodigo.gateway.repositories.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class ClienteController {

    private final ClienteRepository clienteReposity;
    @PersistenceContext
    EntityManager manager;

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository, ClienteRepository clienteReposity) {
        this.clienteReposity = clienteReposity;
        this.clienteRepository = this.clienteReposity;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastraCliente(@RequestBody @Valid ClienteDTO request) {

        Cliente cliente = request.toModel(manager);
        clienteRepository.save(cliente);
    }
}
