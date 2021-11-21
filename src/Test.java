import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;


public class Test {
    public static void main(String [] args){
        try{
            Image im = ImageIO.read(new File("/ChessIcon.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
            
    }
}
