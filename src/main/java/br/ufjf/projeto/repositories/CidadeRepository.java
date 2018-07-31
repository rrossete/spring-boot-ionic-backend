package br.ufjf.projeto.repositories;


import br.ufjf.projeto.domain.Cidade;
import br.ufjf.projeto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
