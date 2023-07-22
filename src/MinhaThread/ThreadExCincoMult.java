package MinhaThread;

public class ThreadExCincoMult extends Thread{
    private static long duracao = 0;
    private static int[] maiorNumero = {-1, 0};
    private int limite_inferior;
    private int limite_superior;

    public ThreadExCincoMult(int limite_inferior, int limite_superior) {
        this.limite_inferior = limite_inferior;
        this.limite_superior = limite_superior;
    }

    private int ContaDivisores(int numero){
        int cont = 0;
        for (int i = 1; i <= numero; i++){
            if(numero % i == 0) cont++;
        }
        return cont;
    }

    private void AtribuirNumComMaisDivisores(int numero, int qtdDivisores){
        synchronized (ThreadExCincoMult.class) {
            if (qtdDivisores > maiorNumero[1]) {
                maiorNumero[0] = numero;
                maiorNumero[1] = qtdDivisores;
            }
        }
    }

    private void somaTempoExecucao(long valor){
        synchronized (ThreadExCincoMult.class) {
            duracao += valor;
        }
    }
    @Override
    public void run() {
        long inicioExecucao = System.currentTimeMillis();
        for (int numero = limite_inferior; numero <= limite_superior; numero++) {
            int qtdDivisores = ContaDivisores(numero);
            AtribuirNumComMaisDivisores(numero, qtdDivisores);
        }
        long fimExecucao = System.currentTimeMillis();
        somaTempoExecucao(fimExecucao - inicioExecucao);
    }

    public static int[] getNumComMaisDivisores() {
        return maiorNumero;
    }
    public static long getDuracao() {
        return duracao;
    }
}

//dividir o intervalo em 10 vetores e mandar cada thread calcular pra cada um deles

