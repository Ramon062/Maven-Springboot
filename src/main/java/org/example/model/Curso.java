package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/*lombok*/
@Data // lomok ajuda com os métodos: get,set,tostring, @equals
@NoArgsConstructor
/**
 * @param codigo
 * @param descricao
 */
/* lombok */
/* jpa/hibernate */
@Entity
@Table(name = "CURSO")
/* jpa/hibernate */
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // codigo: int
    private int codigo;

    // descricao: String
    private String descricao;

    // Constructor
    /**
     * @param codigo
     * @param descricao
     */
    public Curso(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    // cadastrar(): void Curso
    public void cadastrar() {
        CursoDAO cursoDAO = new CursoDAO();
        cursoDAO.cadastrar(this);
    }

}