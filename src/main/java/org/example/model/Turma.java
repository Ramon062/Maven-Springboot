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
/**
 * @param codigo
 * @param descricao
 */
/**
 * @param nome
 * @param endereco
 * @param telefone
 */
@AllArgsConstructor
/* lombok */
/* jpa/hibernate */
@Entity
@Table(name = "TURMA")
/* jpa/hibernate */

public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int ano;
    private String turma;
    private int semestre;
    private int diaSemana;
    private String horarios;

    public Turma(int ano, int semestre, int diaSemana, String horarios, String turma) {
        this.turma = turma;
        this.ano = ano;
        this.diaSemana = diaSemana;
        this.semestre = semestre;
        this.horarios = horarios;
    }

    public void abrirTurma() {
        // Aqui você pode adicionar a lógica para abrir a turma
        System.out.println("Turma " + turma + " do ano " + ano + " aberta para matrículas.");
    }

    public void alocarProfessor(Professor professor) {
        // Aqui você pode implementar a lógica para alocar o professor à turma
        System.out.println("Professor " + professor.getNome() + " alocado para a turma " + turma);
    }

    public void matricularAluno(Aluno aluno) {
        // Aqui você pode implementar a lógica para matricular o aluno na turma
        System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + turma);
    }

    public void emitirDiario() {
        // Aqui você pode implementar a lógica para emitir o diário da turma
        System.out.println("Diário da turma " + turma + " do ano " + ano + " emitido.");
    }

}