import Exercicios.ExercicioCinco;
import Exercicios.ExercicioDois;
import Exercicios.ExercicioQuatro;
import Exercicios.ExercicioTres;

public class Main {
    //Discente: Gabriel de Oliveira Santos
    //Matricula: 202000012720
    //Turma: 01
    public static void main(String[] args) throws Exception {
        //Para verificar as soluções, basta descomenta a linha referente ao exercicio desejado

        //ExercicioUm ex1 = new ExercicioUm();

        //ExercicioDois ex2 = new ExercicioDois();

        //O primeiro parametro determina se a execução é multithread ou não
        //ExercicioTres ex3Mono = new ExercicioTres(false,"C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\SistemasOperacionais\\Atividade SO\\src\\ImagensExTres");
        ExercicioTres ex3Multi = new ExercicioTres(true,"C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\SistemasOperacionais\\Atividade SO\\src\\ImagensExTres");

        //ExercicioQuatro ex4 = new ExercicioQuatro();

        //O parametro determina se a execução é multithread ou não
        //ExercicioCinco ex5Mono = new ExercicioCinco(false);
        //ExercicioCinco ex5Multi = new ExercicioCinco(true);
    }
}