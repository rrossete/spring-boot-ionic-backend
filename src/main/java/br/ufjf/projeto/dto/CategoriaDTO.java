package br.ufjf.projeto.dto;

import br.ufjf.projeto.domain.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
     /*TODO - É usado para axiliar na apresentação dos elementos que se deseja mostrar, nesse caso
        TODO Irá mostrar apenas o nome e o Id da categoria, deixando de lado os produtos
    */

    private static final long serialVersionUID= 1L;

    private Integer id;
    private  String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
