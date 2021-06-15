package casadocodigo.casadocodigo.gateway.controller;

import casadocodigo.casadocodigo.dtos.EstadoDTO;
import casadocodigo.casadocodigo.entities.Estado;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public String cadastraEstado(@RequestBody @Valid EstadoDTO request){

        Estado novoEstado = request.toModel(manager);
        manager.persist(novoEstado);
        return novoEstado.toString();
    }
}
