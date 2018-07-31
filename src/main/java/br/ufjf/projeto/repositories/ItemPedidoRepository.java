package br.ufjf.projeto.repositories;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {


}
