package br.ufjf.projeto.resources;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {
        Categoria cat1 = new Categoria(1, "Informática");
        Categoria cat2 = new Categoria(2, "Escritório");

        List<Categoria> lista = new ArrayList<>();

        lista.add(cat1);
        lista.add(cat2);
        return lista;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {

        Categoria categoria = categoriaService.find(id);
        return ResponseEntity.ok().body(categoria);

    }

    @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<Void> insert(@RequestBody Categoria categoria){

        categoria = categoriaService.insert(categoria);

       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}").buildAndExpand(categoria.getId()).toUri(); //cria uma uri com o id e a pagina corrente q esta mapeada /categorias/{id}

       return ResponseEntity.created(uri).build();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){

        categoria.setId(id);
        categoria = categoriaService.update(categoria);

        return ResponseEntity.noContent().build();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Void> delete(@PathVariable Integer id){

        categoriaService.delete(id);

        return ResponseEntity.noContent().build();
   }
}
