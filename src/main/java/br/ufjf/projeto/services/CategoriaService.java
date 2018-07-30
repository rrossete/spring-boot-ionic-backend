package br.ufjf.projeto.services;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id){

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        return categoria.orElse(null);
    }
}
