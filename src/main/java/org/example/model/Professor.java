package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*lombok*/
@Data //lomok ajuda com os métodos: get,set,tostring, @equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*lombok*/
/*jpa/hibernate*/
@Entity
@Table(name = "PROFESSOR")
/*jpa/hibernate*/

public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titulacaoMaxima;

    public void cadastrar() {
        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.cadastrar(this);
    }
    // Getters and setters for the attribute titulacaoMaxima
    public String getTitulacaoMaxima() {
        
        return titulacaoMaxima;
    }

    public void setTitulacaoMaxima(String titulacaoMaxima) {
        this.titulacaoMaxima = titulacaoMaxima;
    }

    public String getNome() {
        return null;
    }
    
}