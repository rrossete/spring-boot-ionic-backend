package br.ufjf.projeto.resources;

import br.ufjf.projeto.domain.Pedido;
import br.ufjf.projeto.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/pedidos")
public class PedidoResources {

    @Autowired
    PedidoService pedidoService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){

        Pedido pedido = pedidoService.buscar(id);

        return ResponseEntity.ok(pedido);

    }


}
