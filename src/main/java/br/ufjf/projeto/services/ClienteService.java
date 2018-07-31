package br.ufjf.projeto.services;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.domain.Cliente;
import br.ufjf.projeto.repositories.ClienteRepository;
import br.ufjf.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

   public Cliente busca (Integer id){

       Optional<Cliente> cliente = clienteRepository.findById(id);

       return cliente.orElseThrow(()-> new ObjectNotFoundException(
               "Objeto não encontrado! Id:" + id + ",  Tipo: " + Cliente.class.getName()
       ));
   }
}
