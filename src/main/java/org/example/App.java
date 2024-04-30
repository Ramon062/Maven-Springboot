package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class App {
    public static void main(String[] args) {


            SpringApplication.run(App.class, args);
            Scanner scanner = new Scanner(System.in);


            System.out.println("Insira a nota 1:");
            float nota1 = scanner.nextFloat();

            System.out.println("Insira a nota 2:");
            float nota2 = scanner.nextFloat();

            float media = calcularMedia(nota1, nota2);

            System.out.println("A média das notas é: " + media);

            scanner.close();
        System.exit(0);
        }

        private static float calcularMedia ( float nota1, float nota2){
            return (nota1 + nota2) / 2;
        }
    }