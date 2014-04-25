//package webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import java.lang.Thread;
import java.awt.Container;
import java.awt.event.*;



public class webcam {

    public static void main(String[] args) {
	BufferedImage image=null;
	String IP="10.14.104.30"; 
	String PORT="81";
	JFrame frames= new JFrame("WebCamera");
	//JButton UP=new JButton("UP");
	//JPanel panel=
	//DOWN=new JButton("DOWN");
	//LEFT=new JButton("LEFT");
	//RIGHT=new JButton("RIGHT");
	frames.setLocation(300,300);
	frames.setSize(640,480);
	frames.setResizable(false);
	ImageIcon imageIcon = null;
	while (true) {
	    try {
		URL url=new URL("http://"+IP+":"+PORT+"/snapshot.cgi?user=admin&pwd=2626");
		image = ImageIO.read(url);
		//ImageIO.write(image,"jpg",new File("Response.jpg"));
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    JLabel label = new JLabel(new ImageIcon(image));
	    frames.add(label);
	    //frames.add(UP);
	    frames.setVisible(true);
	    frames.setDefaultCloseOperation(frames.EXIT_ON_CLOSE);
	    try {
		Thread.sleep(50);
	    } catch (Exception et) {
	    }
	    frames.remove(label);
	    //frames.setVisible(false);
	}

	
	//System.out.println("Photo Download!");
    }
}

