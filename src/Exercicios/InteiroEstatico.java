package Exercicios;

public class InteiroEstatico {
    static int valorEstatico;

    public InteiroEstatico() {
        this.valorEstatico = 0;
    }

    public static int getValorEstatico() {
        return valorEstatico;
    }

    public void IncrementaValor(){
        valorEstatico += 1;
    }
}
