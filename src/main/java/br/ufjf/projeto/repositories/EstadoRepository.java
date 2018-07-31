package br.ufjf.projeto.repositories;


import br.ufjf.projeto.domain.Estado;
import br.ufjf.projeto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {


}
