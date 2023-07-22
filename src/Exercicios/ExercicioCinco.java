package Exercicios;

import MinhaThread.ThreadExCincoMono;
import MinhaThread.ThreadExCincoMult;
import java.util.ArrayList;

public class ExercicioCinco {

    public ExercicioCinco(boolean isMultThread) {
        if(isMultThread){
            MultThread();
        }
        else{
            MonoThread();
        }
    }
    
    private void MonoThread(){
        new ThreadExCincoMono().start();
    }

    private void MultThread(){
        ArrayList<ThreadExCincoMult> pool = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            pool.add(new ThreadExCincoMult((i*1250) + 1,((i+1)*1250) + 1 ));
            pool.get(i).start();
        }

        try{
            for (int i = 0; i < 8; i++) {
                pool.get(i).join();
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Tempo de execução em uma thread: " + ThreadExCincoMult.getDuracao() + " milissegundos");
        System.out.println(String.format(String.format("Dentro do intervalo [0,20000], o numero com mais divisores é: %d, ele possui %d divisores.", ThreadExCincoMult.getNumComMaisDivisores()[0], ThreadExCincoMult.getNumComMaisDivisores()[1])));
    }
}
