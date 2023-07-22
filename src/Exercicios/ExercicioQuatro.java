package Exercicios;

import MinhaThread.ThreadExQuatro;
import java.util.ArrayList;

public class ExercicioQuatro {
    private InteiroEstatico valor = new InteiroEstatico();
    private int N = 16;
    public ExercicioQuatro() {
        ArrayList<ThreadExQuatro> pool = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            pool.add(new ThreadExQuatro(valor));
            pool.get(i).start();
        }
        try {
            for (int i = 0; i < N; i++) {
                pool.get(i).join();
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(InteiroEstatico.getValorEstatico());
    }
}

