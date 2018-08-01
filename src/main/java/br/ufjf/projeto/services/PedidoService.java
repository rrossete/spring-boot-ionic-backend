package br.ufjf.projeto.services;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.domain.Pedido;
import br.ufjf.projeto.repositories.CategoriaRepository;
import br.ufjf.projeto.repositories.PedidoRepository;
import br.ufjf.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido buscar(Integer id){

        Optional<Pedido> pedido = pedidoRepository.findById(id);

        return pedido.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ",  Tipo: " + Pedido.class.getName()
        ));
    }


}
