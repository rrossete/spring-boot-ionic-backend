package br.ufjf.projeto.repositories;


import br.ufjf.projeto.domain.Cliente;
import br.ufjf.projeto.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
