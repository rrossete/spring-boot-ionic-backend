package br.ufjf.projeto.repositories;


import br.ufjf.projeto.domain.Cliente;
import br.ufjf.projeto.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {


}
