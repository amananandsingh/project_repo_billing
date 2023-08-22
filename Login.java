package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;//to make button executable
import java.sql.ResultSet;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{//to make button executable
	JButton login,cancel,signup;
	JTextField username,password;
	Choice loginin;
	Login(){
		super("Login Page");//first thing in constructor should be super if used "super"
		getContentPane().setBackground(Color.PINK);  //full access of frame 
		setLayout(null);
		
		JLabel lblusername=new JLabel("Username");//JLabel helps us to write anything on frame
		lblusername.setBounds(300, 20, 100, 20);
		add(lblusername);
		
		username=new JTextField();
		username.setBounds(400,20,150,30);
		add(username);
		
		JLabel lblpass=new JLabel("password");//JLabel helps us to write anything on frame
		lblpass.setBounds(300, 60, 100, 20);
		add(lblpass);
		
		password=new JTextField();
		password.setBounds(400,60,150,30);
		add(password);
		
		JLabel logininas=new JLabel("Login In As");//JLabel helps us to write anything on frame
		logininas.setBounds(300, 100, 100, 20);
		add(logininas);
		
		loginin=new Choice();
		loginin.add("Admin");
		loginin.add("Customer");
		loginin.setBounds(400,100,150,20);
		add(loginin);		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		login= new JButton("Login",new ImageIcon(i2)); //used for buttons
		login.setBounds(330,160,100,20);
		login.addActionListener(this);
		add(login);
		
		ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
		Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		cancel= new JButton("cancel",new ImageIcon(i4)); //used for buttons
		cancel.setBounds(450,160,100,20);
		cancel.addActionListener(this);// to know that any specific button has been clicked and the work is done in function  -->actionPerformed(ActionEvent ae)
		add(cancel);
		
		ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		signup= new JButton("Signup",new ImageIcon(i6)); 
		signup.setBounds(380,200,100,20);
		signup.addActionListener(this);
		add(signup);
		
		ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
		Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i9=new ImageIcon(i8);
		JLabel image= new JLabel(i9);
		image.setBounds(0,0,250,250);
		add(image);
		
		setSize(640,300);
	 	setLocation(400,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) { // to make button action performing
		if(ae.getSource()==login) {
			String susername=username.getText();//now susername has value of username
			String spassword=password.getText();
			String user=loginin.getSelectedItem();
			
			try {
				Conn c=new Conn();
				String query="select * from loginx where username='"+susername+"'and password='"+spassword+"' and user='"+user+"'";
			//ddl command
				ResultSet rs=c.s.executeQuery(query);
				  if(rs.next()) {//if username and pass match then project frame is opened
					  String meter=rs.getString("meter_no");
					  setVisible(false);
					  new Project(user,meter);
					  
				  }else {//if username and pass match
					  JOptionPane.showMessageDialog(null, "Invalid Login");
					  username.setText("");
					  password.setText("");
				  }
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		else if(ae.getSource()==cancel) {
			setVisible(false);

	}
		else if(ae.getSource()==signup) {
			setVisible(false);//existing frame closes
			
			new Signup();//signup frame is initiaited
		}
		
		}
	
	public static void main(String[] args) {
		new Login();
	}
}