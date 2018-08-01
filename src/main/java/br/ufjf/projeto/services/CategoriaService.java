package br.ufjf.projeto.services;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.repositories.CategoriaRepository;
import br.ufjf.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ",  Tipo: " + Categoria.class.getName()
        ));
    }

    public Categoria insert(Categoria categoria){

        categoria.setId(null);//metodo de inserção, ou seja, caso exista um id, sera um metodo de atualização
        return categoriaRepository.save(categoria);
    }
}
