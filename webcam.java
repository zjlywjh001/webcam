//package webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.lang.Thread;
import java.awt.*;
import java.awt.event.*;

import wjh.HTTP.*;



public class webcam implements ActionListener {
    JFrame frames = new JFrame("WebCamera");
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    BufferedImage image=null;
    JButton UP = new JButton("UP");
    JButton DOWN = new JButton("DOWN");
    JButton LEFT = new JButton("LEFT");
    JButton RIGHT = new JButton("RIGHT");
    JLabel label = null;
    String IP="10.14.104.30"; 
    String PORT="81";


    webcam() {
	
	frames.setLocation(300,300);
	frames.setSize(640,480);
	frames.setResizable(false);
	frames.setDefaultCloseOperation(frames.EXIT_ON_CLOSE);
	jp1.add(UP);
	jp1.add(DOWN);
	jp1.add(LEFT);
	jp1.add(RIGHT);
	jp2.setBounds(0,0,640,480);
	frames.add(jp2);
	frames.add(jp1,BorderLayout.SOUTH);
	frames.setVisible(true);
	UP.addActionListener(this);
	DOWN.addActionListener(this);
	LEFT.addActionListener(this);
	RIGHT.addActionListener(this);
	while (true) {
	    try {
		URL url=new URL("http://"+IP+":"+PORT+"/snapshot.cgi?user=admin&pwd=2626");
		image = ImageIO.read(url);
		//ImageIO.write(image,"jpg",new File("Response.jpg"));
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    label = new JLabel(new ImageIcon(image));
	    jp2.add(label);
	    jp2.validate();
	    try {
		Thread.sleep(50);
	    } catch (Exception et) {
	    }
	    jp2.remove(label);
	    //jp2.repaint();
	    //frames.setVisible(false);
	}

    }

    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("UP")) {
	    String reqstr = "http://"+IP+":"+PORT+"/decoder_control.cgi";
	    String reqparm = "&loginuse=admin&loginpas=2626&command=0&onestep=1";
	    HTTPRequest.sendGet(reqstr,reqparm);
	    System.out.println("UP");
	}
	if (e.getActionCommand().equals("DOWN")) {
	    String reqstr = "http://"+IP+":"+PORT+"/decoder_control.cgi";
	    String reqparm = "&loginuse=admin&loginpas=2626&command=2&onestep=1";
	    HTTPRequest.sendGet(reqstr,reqparm);
	    System.out.println("DOWN");
	}
	if (e.getActionCommand().equals("LEFT")) {
	    String reqstr = "http://"+IP+":"+PORT+"/decoder_control.cgi";
	    String reqparm = "&loginuse=admin&loginpas=2626&command=4&onestep=1";
	    HTTPRequest.sendGet(reqstr,reqparm);
	    System.out.println("LEFT");
	}
	if (e.getActionCommand().equals("RIGHT")) {
	    String reqstr = "http://"+IP+":"+PORT+"/decoder_control.cgi";
	    String reqparm = "&loginuse=admin&loginpas=2626&command=6&onestep=1";
	    HTTPRequest.sendGet(reqstr,reqparm);
	    System.out.println("RIGHT");
	}

    }

    public static void main(String[] args) {
	new webcam();		
    }
}

