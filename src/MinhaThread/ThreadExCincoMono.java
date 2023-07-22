package MinhaThread;

public class ThreadExCincoMono extends Thread{
    @Override
    public void run() {
        long inicioExecucao = System.currentTimeMillis();
        int[] numeroComMaisDivisores = {0, -1};
        for (int numero = 1; numero <= 20000; numero++) {
            int contador = 0;
            for (int i = 1; i <= numero; i++){
                if(numero % i == 0) contador++;
            }
            if(contador > numeroComMaisDivisores[1]){
                numeroComMaisDivisores[0] = numero;
                numeroComMaisDivisores[1] = contador;
            }
        }
        long fimExecucao = System.currentTimeMillis();
        System.out.println("Tempo de execução em uma thread: " + (fimExecucao - inicioExecucao) + " milissegundos.");
        System.out.println(String.format("Dentro do intervalo [0,20000], o numero com mais divisores é: %d, ele possui %d divisores.", numeroComMaisDivisores[0], numeroComMaisDivisores[1]));
    }
}
