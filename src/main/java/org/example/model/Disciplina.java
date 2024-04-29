package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*lombok*/
@Data // lomok ajuda com os métodos: get,set,tostring, @equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
/* lombok */
/* jpa/hibernate */
@Entity
@Table(name = "DISCIPLINA")
/* jpa/hibernate */
public class Disciplina {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int codigo;
    private String descricao;
    private int cargaHoraria;
    private String ementa;
    private String bibliografia;

    public void cadastrar(int codigo, String descricao, int cargaHoraria, String ementa, String bibliografia) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.ementa = ementa;
        this.bibliografia = bibliografia;
    }
}