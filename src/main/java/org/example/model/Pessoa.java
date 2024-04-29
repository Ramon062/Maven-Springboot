package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
/*lombok*/
@Data //lomok ajuda com os métodos: get,set,tostring, @equals

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
 /*lombok*/
/*jpa/hibernate*/
@Entity
@Table(name = "PESSOA")
/*jpa/hibernate*/
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String endereco;
    private String telefone;

    // Constructor

    public Pessoa(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // cadastrar(): void Curso
    public void cadastrar() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.cadastrar(this);
    }
}