package Exercicios;
import MinhaThread.ThreadExDois;

import java.util.ArrayList;

public class ExercicioDois {
    int N = 10;
    public ExercicioDois() {
        ArrayList<ThreadExDois> threads = new ArrayList<>();

        for (int numeroThread = 0; numeroThread < N; numeroThread++) {
            threads.add(new ThreadExDois(numeroThread));
            threads.get(numeroThread).start();
        }

        try{
            for (int i = 0; i < N; i++) {
                threads.get(i).join();
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(String.format("A thread %d terminou primeiro.", ThreadExDois.getPrimeiraThread()));
        System.out.println("Fim da main");
    }
}


