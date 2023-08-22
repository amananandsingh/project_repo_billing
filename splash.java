package electricity.billing.system;
import javax.swing.*;

import java.awt.*;
public class splash extends JFrame implements Runnable{
	Thread t;
	splash(){
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg" ));
		Image i2=i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image =new JLabel(i3);
		add(image);
		
		setVisible(true);//to see frame in starting before expanding
	    
		int x=1;
		for(int i=2;i<=600;i+=4,x+=1) {  //for increasing the frame size at continuous rate
			setSize(i+x,i);
			setLocation(700-((i+x)/2),400-(i/2));  //opens up perfect
			try {
				Thread.sleep(5);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		t =new Thread(this);
		t.start();
		
				
	
	setVisible(true);//to check frame's visibility
	}
	public void run() {
		try {
			Thread.sleep(4000);//5000ms=5s
			setVisible(false);  //to close window after 7 second;
		//login frame
			new Login();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new splash();
		
	}

}
