package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.*;
public class NewCustomer extends JFrame implements ActionListener{      //action listener is implemented due to implement the button
	JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone;
	JButton next,cancel;
	JLabel lblmeter;
	NewCustomer(){
		setSize(700,500);
		setLocation(400,200);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		JLabel heading=new JLabel("New Customer");
		heading.setBounds(180,10,200,25);
		heading.setFont(new Font("Tahoma",Font.PLAIN,24));
		p.add(heading);
		
		JLabel lblname=new JLabel("Customer Name");
		lblname.setBounds(100,80,100,20);
		p.add(lblname);
		
		tfname=new JTextField();//text field to put value
		tfname.setBounds(240,80,200,20);
		p.add(tfname);
		
		
		//2nd
		JLabel lblmeterno=new JLabel("Meter Number");
		lblmeterno.setBounds(100,120,100,20);
		p.add(lblmeterno);
		
		lblmeter=new JLabel(""); //to get a random number set for meter
		lblmeter.setBounds(240,120,100,20);
		p.add(lblmeter);
		
		Random ran=new Random();//generate random number
		long number=ran.nextLong()%1000000;
		lblmeter.setText(""+ Math.abs(number));//set text hold a string value
		
		JLabel lbladdress=new JLabel("Address");
		lbladdress.setBounds(100,160,100,20);
		p.add(lbladdress);
		
		tfaddress=new JTextField();//text field to put value
		tfaddress.setBounds(240,160,200,20);
		p.add(tfaddress);
						
		JLabel lblcity=new JLabel("City");
		lblcity.setBounds(100,200,100,20);
		p.add(lblcity);
		
		tfcity=new JTextField();//text field to put value
		tfcity.setBounds(240,200,200,20);
		p.add(tfcity);	
		
		JLabel lblstate=new JLabel("State");
		lblstate.setBounds(100,240,100,20);
		p.add(lblstate);
		
		tfstate=new JTextField();//text field to put value
		tfstate.setBounds(240,240,200,20);
		p.add(tfstate);		
		
		JLabel lblemail=new JLabel("Email");
		lblemail.setBounds(100,280,100,20);
		p.add(lblemail);
		
		tfemail=new JTextField();//text field to put value
		tfemail.setBounds(240,280,200,20);
		p.add(tfemail);			

		JLabel lblphone=new JLabel("Phone.No.");
		lblphone.setBounds(100,320,100,20);
		p.add(lblphone);
		
		tfphone=new JTextField();//text field to put value
		tfphone.setBounds(240,320,200,20);
		p.add(tfphone);		
		
		next=new JButton("Next");         //new button named next
		next.setBounds(120,390,100,25);
		next.setForeground(Color.WHITE);
		next.setBackground(Color.BLACK);
		next.addActionListener(this);
		p.add(next);
		
		cancel=new JButton("Cancel");         //new button named next
		cancel.setBounds(250,390,100,25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);
		
		setLayout(new BorderLayout());
		add(p,"Center");
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image,"West");
		
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);//to see the frame
	}
	
	public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==next) {
		String name=tfname.getText();//insert in loginx
		String meter=lblmeter.getText();//insert in loginx  // random meter no is fetched of  digits
		String address=tfaddress.getText();
		String city=tfcity.getText();
		String state=tfstate.getText();
		String email=tfemail.getText();
		String phone=tfphone.getText();
			
		String query1="insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";						
		String query2="insert into loginx values('"+meter+"','','"+name+"','','')";  //to verify meter no with loginx and customer table
	System.out.println("value inserted successfully");
		try {
			Conn c=new Conn();
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
						setVisible(false);
						//new frame info // to ask details of meter info
						//meter no
				new MeterInfo(meter);	
						
						
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}else {
		setVisible(false);
		
	}
	}
	

	public static void main(String[] args) {
		new NewCustomer();
		
		
		
	}
	
	
}
