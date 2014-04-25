import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class webcam {
    public static void main(String[] args) {
	BufferedImage image=null;
	String IP="10.14.104.30"; 
	String PORT="81"
	try {
	    URL url=new URL("http://"+IP+":"+PORT+"/snapshot.cgi?user=admin&pwd=2626");
	    image = ImageIO.read(url);

	    ImageIO.write(image,"jpg",new File("Response.jpg"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	System.out.println("Photo Download!");
    }
}

