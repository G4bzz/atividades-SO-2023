package MinhaThread;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ThreadExTres extends Thread{
    File arquivoImagem;

    public ThreadExTres(File arquivoImagem) {
        this.arquivoImagem = arquivoImagem;
    }

    public void run(){
        try{
            BufferedImage bufferedImage = ImageIO.read(this.arquivoImagem);
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    Color pixelColor = new Color(bufferedImage.getRGB(x, y));
                    int blackAndWhiteNumber = (int)(pixelColor.getRed() * 0.3 + pixelColor.getBlue() * 0.59 + pixelColor.getBlue() * 0.11);
                    Color grayscalePixel = new Color(blackAndWhiteNumber, blackAndWhiteNumber, blackAndWhiteNumber);
                    bufferedImage.setRGB(x, y, grayscalePixel.getRGB());
                }
            }

            ImageIO.write(bufferedImage, "jpg", new File(arquivoImagem.getAbsolutePath().replace(".jpg", "_PB.jpg")));
            System.out.println("A imagem %s foi gravada com sucesso");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
