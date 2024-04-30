package org.example.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/*lombok*/
@Data //lomok ajuda com os métodos: get,set,tostring, @equals
@NoArgsConstructor
/*lombok*/
/*jpa/hibernate*/
@Entity
@Table(name = "AVALIACAO")
/*jpa/hibernate*/
public class Avaliacao {
    private LocalDate data;
    private float nota1;
    private float nota2;
    private float notaProvaFinal;
    private int frequencia;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Avaliacao(LocalDate data, float nota1, float nota2, float notaProvaFinal, int frequencia) {
        this.data = data;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaProvaFinal = notaProvaFinal;
        this.frequencia = frequencia;
    }

    public float calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public boolean estaAprovado() {
        return (calcularMedia() >= 6.0f) && (frequencia >= 40);
    }
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNotaProvaFinal() {
        return notaProvaFinal;
    }

    public void setNotaProvaFinal(float notaProvaFinal) {
        this.notaProvaFinal = notaProvaFinal;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }


}
