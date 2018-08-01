package br.ufjf.projeto.resources;

import br.ufjf.projeto.domain.Pedido;
import br.ufjf.projeto.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/pedidos")
public class PedidoResources {

    @Autowired
    PedidoService pedidoService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Pedido> find(@PathVariable Integer id){

        Pedido pedido = pedidoService.find(id);

        return ResponseEntity.ok(pedido);

    }


}
