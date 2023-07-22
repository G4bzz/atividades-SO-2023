package Exercicios;
import MinhaThread.ThreadExTres;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioTres {
    String diretorio;
    Boolean isMultThreaded;

    public ExercicioTres(Boolean isMultThreaded, String diretorio) throws IOException {
        // Caminho absoluto da pasta ImagensExTres do projeto
        // "C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\SistemasOperacionais\\Atividade SO\\src\\ImagensExTres"
        this.diretorio = diretorio;
        this.isMultThreaded = isMultThreaded;

        if(isMultThreaded){
            MultThread();
        }
        else MonoThread();
    }
    public ExercicioTres(Boolean isMultThreaded) throws IOException {
        String diretorio = "";
        System.out.println("Informe o diretório da pasta que contém as imagens:");
        System.out.println("Exemplo: C:\\Users\\gabriel\\Desktop\\Atividade SO\\src\\ImagensExTres");

        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNextLine() && (diretorio = scan.nextLine().toLowerCase()).length() != 0) {
                if(!diretorio.isEmpty()) break;
            }
        }

        this.diretorio = diretorio;
        this.isMultThreaded = isMultThreaded;

        if(isMultThreaded){
            MultThread();
        }
        else MonoThread();
    }

    private void MonoThread() throws IOException {
        File pasta = new File(this.diretorio);

        if (pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    System.out.println(arquivo.getAbsolutePath());
                    try{
                        BufferedImage bufferedImage = ImageIO.read(arquivo);

                        for (int x = 0; x < bufferedImage.getWidth(); x++) {
                            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                                Color pixelColor = new Color(bufferedImage.getRGB(x, y));
                                int blackAndWhiteNumber = (int)(pixelColor.getRed() * 0.3 + pixelColor.getBlue() * 0.59 + pixelColor.getBlue() * 0.11);
                                Color grayscalePixel = new Color(blackAndWhiteNumber, blackAndWhiteNumber, blackAndWhiteNumber);
                                bufferedImage.setRGB(x, y, grayscalePixel.getRGB());
                            }
                        }

                        ImageIO.write(bufferedImage, "jpg", new File(arquivo.getAbsolutePath().replace(".jpg", "_PB.jpg")));

                    } catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        } else {
            System.out.println("O caminho especificado não é um diretório válido.");
        }
    }

    private void MultThread(){
        File pasta = new File(this.diretorio);
        ArrayList<ThreadExTres> pool = new ArrayList<>();
        if (pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                int cont = 0;
                for (File arquivo : arquivos) {
                    System.out.println(arquivo.getAbsolutePath());
                    pool.add(new ThreadExTres(arquivo));
                    pool.get(cont).start();
                    cont++;
                }
                try {
                    for (ThreadExTres t3 : pool) {
                        t3.join();
                    }
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        } else {
            System.out.println("O caminho especificado não é um diretório válido.");
        }
    }
}
