package Exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExercicioUm {
    public ExercicioUm() {
        Principal();
    }

    public void PrintaVetor(ArrayList<Integer> vetor){
        System.out.println(vetor.toString());
    }

    public void Principal(){
        System.out.println("Digite os inteiros do vetor seguindo o seguinte exemplo: 2 3 4 5 1 2 4");
        System.out.println("(caso queira parar a execução do programa, aperte apenas a tecla Enter)");

        String vetorTexto = "";
        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNextLine()
                    && (vetorTexto = scan.nextLine().toLowerCase()).length() != 0) {
                ArrayList<Integer> vetor = new ArrayList<>();
                for(String numero: vetorTexto.split(" ")){
                    vetor.add(Integer.parseInt(numero));
                }

                Collections.sort(vetor);

                PrintaVetor(vetor);
            }
        }

    }
}
