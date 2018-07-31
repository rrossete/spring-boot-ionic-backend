package br.ufjf.projeto.resources;

import br.ufjf.projeto.domain.Estado;
import br.ufjf.projeto.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResources {

    @Autowired
    EstadoService estadoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Estado estado = estadoService.busca(id);
        return ResponseEntity.ok(estado);
    }
}
