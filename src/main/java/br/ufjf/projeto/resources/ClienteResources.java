package br.ufjf.projeto.resources;

import br.ufjf.projeto.domain.Cliente;
import br.ufjf.projeto.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteResources {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> busca(@PathVariable Integer id){

        Cliente cliente = clienteService.busca(id);

        return ResponseEntity.ok(cliente);
    }
}
