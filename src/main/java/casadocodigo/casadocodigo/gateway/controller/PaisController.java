package casadocodigo.casadocodigo.gateway.controller;

import casadocodigo.casadocodigo.dtos.PaisDTO;
import casadocodigo.casadocodigo.entities.Pais;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/paises")
    @Transactional
    public String cadastraPais(@RequestBody @Valid PaisDTO request) {

        Pais novoPais = new Pais(request.getNomePais());
        manager.persist(novoPais);
        return novoPais.toString();

    }

}
