package MinhaThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThreadExDois extends Thread{
    private int id;
    private static int contador = 0;
    private static int primeiraThread = -1;
    public ThreadExDois(int id) {
        this.id = id;
    }

    public static int getPrimeiraThread() {
        return primeiraThread;
    }

    @Override
    public void run(){
        System.out.println(String.format("Olá sou a thread %d", id));

        Math.sqrt(999333 + (int)(Math.random() * 9999999));

        System.out.println(String.format("A thread %d foi finalizada em: %s", id, DateTimeFormatter.ofPattern("HH:mm:ss:ms").format(LocalDateTime.now())));

        synchronized (ThreadExTres.class){
            contador ++;
            if(primeiraThread == -1){
                primeiraThread = id;
            }
        }
    }
}
