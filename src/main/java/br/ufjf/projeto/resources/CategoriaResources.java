package br.ufjf.projeto.resources;

import br.ufjf.projeto.domain.Categoria;
import br.ufjf.projeto.dto.CategoriaDTO;
import br.ufjf.projeto.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @Autowired
    CategoriaService categoriaService;

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

   @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll(){

        List<Categoria> listCategorias = categoriaService.findAll();

        List<CategoriaDTO> categoriaDTOS = listCategorias.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList()); // transforma um tipo de lista, para outro tipo

        return ResponseEntity.ok().body(categoriaDTOS);
   }
}
