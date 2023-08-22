package electricity.billing.system;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Project extends JFrame implements ActionListener{
String atype,meter;
Project(String atype,String meter){
	this.atype=atype;
	this.meter=meter;
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
	Image i2=i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image= new JLabel(i3);
	add(image);
	
	//class jmenubar
	//bar //menu item on project
	//inside "master"
	//menubar initialisation
	JMenuBar mb=new JMenuBar();
	setJMenuBar(mb);
	JMenu master =new JMenu("MASTER");//MASTER
	master.setForeground(Color.BLUE);
	
	
	//one item(NEW CUSTOMER)
	JMenuItem newcustomer=new JMenuItem("New Customer");
	newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
	setBackground(Color.WHITE);
	ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
	Image image1=icon1.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
	newcustomer.setIcon(new ImageIcon(image1));//image with newcustomer
	newcustomer.setMnemonic('D');
	newcustomer.addActionListener(this);
	newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
	master.add(newcustomer);
	
	//second item (CUSTOMER DETAILS)
	JMenuItem customerdetails=new JMenuItem("Customer Details");
	customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
	setBackground(Color.WHITE);
	ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
	Image image2=icon2.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
	customerdetails.setIcon(new ImageIcon(image2));//image with cust details
	customerdetails.setMnemonic('M');
	customerdetails.addActionListener(this);
	customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
	master.add(customerdetails);
	
	 //third Item(DEPOSIT DETAILS)
	JMenuItem depositdetails=new JMenuItem("Deposit Details");
	depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
	setBackground(Color.WHITE);
	ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
	Image image3=icon3.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
	depositdetails.setIcon(new ImageIcon(image3));//image with deposit details
	depositdetails.setMnemonic('N');
	depositdetails.addActionListener(this);
	depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
	master.add(depositdetails);
	
	//fourth Item(CALCULATE BILL)
	JMenuItem calculatebill=new JMenuItem("Calculate Bill");
	calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
	setBackground(Color.WHITE);
	ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
	Image image4=icon4.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
	calculatebill.setIcon(new ImageIcon(image4));//image with calculate bill
	calculatebill.setMnemonic('B');
	calculatebill.addActionListener(this);
	calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
	master.add(calculatebill);
	
	//second menu item
	JMenu info =new JMenu("INFO");
	info.setForeground(Color.magenta);
	
	
	//first Item(update info in info menu )
		JMenuItem updateinformation=new JMenuItem("Update Information");
		updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
		setBackground(Color.WHITE);
		ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
		Image image5=icon5.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
		updateinformation.setIcon(new ImageIcon(image5));//image with update info
		updateinformation.setMnemonic('P');
		updateinformation.addActionListener(this);
		updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		info.add(updateinformation);
	
	//second item(view information)
		JMenuItem viewinformation=new JMenuItem("View Information");
		viewinformation.setFont(new Font("monospaced",Font.PLAIN,12));
		setBackground(Color.WHITE);
		ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
		Image image6=icon6.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
		viewinformation.setIcon(new ImageIcon(image6));//image with view info
		viewinformation.setMnemonic('L');
		viewinformation.addActionListener(this);
		viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		info.add(viewinformation);
	
	//third menu item
		JMenu user =new JMenu("User");
		user.setForeground(Color.RED);
		
	
		//first item(pay bill)
				JMenuItem paybill=new JMenuItem("Pay Bill");
				paybill.setFont(new Font("monospaced",Font.PLAIN,12));
				setBackground(Color.WHITE);
				ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
				Image image7=icon7.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
				paybill.setIcon(new ImageIcon(image7));//image with pay bill
				paybill.setMnemonic('R');
				paybill.addActionListener(this);
				paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
				user.add(paybill);	
	
	    //second item(Bill Details)
				JMenuItem billdetails=new JMenuItem("Bill Details");
				billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
				setBackground(Color.WHITE);
				ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
				Image image8=icon8.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
				billdetails.setIcon(new ImageIcon(image8));//image with Bill Details
				billdetails.setMnemonic('B');
				billdetails.addActionListener(this);
				billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
				user.add(billdetails);			
				
				
				//fourth menu item
				JMenu report =new JMenu("Report");
				report.setForeground(Color.BLACK);
				
			
				//first item(Generate bill)
						JMenuItem generatebill=new JMenuItem("Generate Bill");
						generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
						setBackground(Color.WHITE);
						ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
						Image image9=icon9.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
						generatebill.setIcon(new ImageIcon(image9));//image with generate bill
						generatebill.setMnemonic('G');
						generatebill.addActionListener(this);
						generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
						report.add(generatebill);	
				
				//fifth menu item(UTILITY)		
						JMenu utility =new JMenu("Utility");
						utility.setForeground(Color.BLACK);
					
					
						//first item(  Notepad   )
								JMenuItem notepad=new JMenuItem("Notepad");
								notepad.setFont(new Font("monospaced",Font.PLAIN,12));
								setBackground(Color.WHITE);
								ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
								Image image10=icon10.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
								notepad.setIcon(new ImageIcon(image10));//image with notepad
								notepad.setMnemonic('N');
								notepad.addActionListener(this);
								notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
								utility.add(notepad);					
						
						//second item(  calculator  )
								JMenuItem calculator=new JMenuItem("Calculator");
								calculator.setFont(new Font("monospaced",Font.PLAIN,12));
								setBackground(Color.WHITE);
								ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
								Image image11=icon11.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
								calculator.setIcon(new ImageIcon(image11));//image with notepad
								calculator.setMnemonic('c');
								calculator.addActionListener(this);
								calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
								utility.add(calculator);
						
								
						//sixth menu item(mEXIT)
								JMenu mexit =new JMenu("Exit");
								mexit.setForeground(Color.RED);
								
								//first item(exit  )
										JMenuItem exit=new JMenuItem("Exit");
										exit.setFont(new Font("monospaced",Font.PLAIN,12));
										setBackground(Color.WHITE);
										ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
										Image image12=icon12.getImage().getScaledInstance(20,20 , Image.SCALE_DEFAULT);
										exit.setIcon(new ImageIcon(image12));//image with exit
										exit.setMnemonic('W');
										exit.addActionListener(this);
										exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
										mexit.add(exit);
										
						if(atype.equals("Admin")) {
							mb.add(master);//add in menubar mb			
						}else {mb.add(info);//add in menubar mb
							mb.add(user);//add in menubar mb			`
							mb.add(report);//add in menubar mb
						}	
							mb.add(utility);//add in menubar mb
							mb.add(mexit);//add in menubar mb
							
	//layout and visibility
	setLayout(new FlowLayout());
	setVisible(true);
	
}
	public void actionPerformed(ActionEvent ae) {
		String msg=ae.getActionCommand();
		if (msg.equals("New Customer")) {
			new NewCustomer();      //calling new customer object
			
		}else if(msg.equals("Customer Details")) {
			new CustomerDetails();
		}else if(msg.equals("Calculate Bill")) {
			new CalculateBill();				//object		//calling new calculate bill obj
		}
		else if(msg.equals("Deposit Details")) {
			new DepositDetails();
		}else if(msg.equals("View Information")) {
			new ViewInformation(meter);
		}else if(msg.equals("Update Information")) {
			new UpdateInformation(meter);
		}else if(msg.equals("Bill Details")) {
			new BillDetails(meter);
		}else if(msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
		}catch(Exception e) {
			e.printStackTrace();
		}	
		}else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
		}catch(Exception e) {
			e.printStackTrace();
		}
		}else if(msg.equals("Exit")) {
			setVisible(false);
			new Login();
		}else if(msg.equals("Pay Bill")) {
			new PayBill(meter);
		}else if(msg.equals("Generate Bill")) {
			new GenerateBill(meter);
		}
	}

	public static void main(String[] args) {
		new Project("","");
		
		
		

	}

}
