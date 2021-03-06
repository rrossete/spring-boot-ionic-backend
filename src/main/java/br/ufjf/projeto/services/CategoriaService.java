package br.ufjf.projeto.services;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.repositories.CategoriaRepository;
import br.ufjf.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ",  Tipo: " + Categoria.class.getName()
        ));
    }

    public Categoria insert(Categoria categoria){

        categoria.setId(null);//metodo de inserção, ou seja, caso exista um id, sera um metodo de atualização
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria){

        find(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id){

        find(id);
        try {
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){

            throw new br.ufjf.projeto.services.exceptions.DataIntegrityViolationException
                    ("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll(){

        return categoriaRepository.findAll();
    }
}
