package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.entities.Categoria;
import casadocodigo.casadocodigo.entities.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class LivroDTO {

    @NotBlank //Titulo é obrigatório
    private String titulo;

    @NotBlank //Resumo é obrigatório
    @Size(max = 500)
    private String resumo;

    @NotBlank //Sumário é de tamanho livre.
    private String sumario;

    @NotBlank //Preço é obrigatório e o mínimo é de 20
    @Size(min = 20)
    private int preco;

    @NotBlank //Número de páginas é obrigatória e o mínimo é de 100
    @Size(min = 100)
    private int numero_paginas;

    @NotBlank  //Isbn é obrigatório, formato livre - Isbn é único
    private String isbn;


    @Future
    @JsonFormat(pattern = "dd/mm/yyyy", shape = JsonFormat.Shape.STRING)
    @NotBlank // Data que vai entrar no ar precisa ser no futuro
    private LocalDate data_publicacao;

    @NotNull //A categoria não pode ser nula
    @ExistsId(DomainClass = Categoria.class, fieldName="idCategoria")
    private long idCategoria;


    @NotNull //O autor não pode ser nulo
    @ExistsId(DomainClass = Categoria.class, fieldName="emailAutor")
    private long idAutor;

    public LivroDTO(String titulo,
                    String resumo,
                    String sumario,
                    int preco,
                    int numero_paginas,
                    String isbn,
                    LocalDate data_publicacao,
                    long idCategoria,
                    long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numero_paginas = numero_paginas;
        this.isbn = isbn;
        this.data_publicacao = data_publicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public LivroDTO() {
    }

    public void setData_publicacao(LocalDate data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public Livro toModel (EntityManager manager) {

        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);
        return new Livro(titulo, resumo,sumario, preco, numero_paginas, isbn, data_publicacao, categoria, autor);
    }


}