package br.ufjf.projeto.services;

import br.ufjf.projeto.domain.Estado;
import br.ufjf.projeto.repositories.EstadoRepository;
import br.ufjf.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

   public Estado busca(Integer id){

       Optional<Estado> estado = estadoRepository.findById(id);

       return estado.orElseThrow(()-> new ObjectNotFoundException(
               "Objeto não encontrado! Id:" + id + ",  Tipo: " + Estado.class.getName()
       ));
   }
}
