package MinhaThread;

import Exercicios.InteiroEstatico;

public class ThreadExQuatro extends Thread{
    private InteiroEstatico valor;
    public ThreadExQuatro(InteiroEstatico valor){
        this.valor = valor;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            valor.IncrementaValor();
        }
    }
}
