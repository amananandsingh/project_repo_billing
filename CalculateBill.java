	package electricity.billing.system;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionListener;
	import java.awt.event.*;
	import java.util.*;
	import java.sql.*;
	public class CalculateBill extends JFrame implements ActionListener{      //action listener is implemented due to implement the button
		JTextField tfname,tfaddress,tfstate,tfunits,tfemail,tfphone;
		JButton next,cancel;
		JLabel lblname,labeladdresss;
		
		Choice meternumber,cmonth;//choice in meter field
		CalculateBill(){
			setSize(700,500);
			setLocation(400,150);
			JPanel p=new JPanel();
			p.setLayout(null);
			p.setBackground(new Color(173,216,230));
			add(p);
			
			JLabel heading=new JLabel("Calculate Electricity Bill");
			heading.setBounds(100,10,400,25);
			heading.setFont(new Font("Tahoma",Font.PLAIN,24));
			p.add(heading);
			
			JLabel lblmeternumber=new JLabel("Meter Number");
			lblmeternumber.setBounds(100,80,100,20);
			p.add(lblmeternumber);
			
			meternumber=new Choice();
			
			try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery("select * from customer");
				while(rs.next()) {
					meternumber.add(rs.getString("meter_no"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			meternumber.setBounds(240,80,200,20);
			p.add(meternumber);
			
			//2nd
			JLabel lblmeterno=new JLabel("Name");
			lblmeterno.setBounds(100,120,100,20);
			p.add(lblmeterno);
			
			lblname=new JLabel(""); //to get a random number set for meter
			lblname.setBounds(240,120,100,20);
			p.add(lblname);
			
			
			JLabel lbladdress=new JLabel("Address");
			lbladdress.setBounds(100,160,100,20);
			p.add(lbladdress);
			
			JLabel labeladdress = new JLabel();//text field to put value
			labeladdress.setBounds(240,160,200,20);
			p.add(labeladdress);
			
			try {
				Conn c= new Conn();
				ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meternumber.getSelectedItem()+"'");
				while (rs.next()) {
					lblname.setText(rs.getString("name")) ;
					labeladdress.setText(rs.getString("address")) ;

				}
			}catch (Exception e){
				e.printStackTrace();
			}//item event on choice and action event on button
			
			meternumber.addItemListener(new ItemListener() { //we add an event here to change the details of name and address as we change the meterno field in the choice;;
				public void itemStateChanged(ItemEvent ie) {
					try {
						Conn c= new Conn();
						ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meternumber.getSelectedItem()+"'");
						while(rs.next()) {
							lblname.setText(rs.getString("name")) ;
							labeladdress.setText(rs.getString("address")) ;

						}
					}catch (Exception e){
						e.printStackTrace();
					} 
				} 
			}); 
							
			JLabel lblcity=new JLabel("Units Consumed");
			lblcity.setBounds(100,200,100,20);
			p.add(lblcity);
			
			tfunits=new JTextField();//text field to put value
			tfunits.setBounds(240,200,200,20);
			p.add(tfunits);	
			
			JLabel lblstate=new JLabel("Month");
			lblstate.setBounds(100,240,100,20);
			p.add(lblstate);
			
			cmonth=new Choice();
			cmonth.setBounds(240,240,200,20);
			cmonth.add("JAN");
			cmonth.add("FEB");
			cmonth.add("MAR");
			cmonth.add("APR");
			cmonth.add("MAY");
			cmonth.add("JUN");
			cmonth.add("JUL");
			cmonth.add("AUG");
			cmonth.add("SEP");
			cmonth.add("OCT");
			cmonth.add("NOV");
			cmonth.add("DEC");
			p.add(cmonth);		
						
			next=new JButton("Submit");         //new button named next
			next.setBounds(120,350,100,25);
			next.setForeground(Color.WHITE);
			next.setBackground(Color.BLACK);
			next.addActionListener(this);
			p.add(next);
			
			cancel=new JButton("Cancel");         //new button named next
			cancel.setBounds(250,350,100,25);
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.WHITE);
			cancel.addActionListener(this);
			p.add(cancel);
			
			setLayout(new BorderLayout());
			add(p,"Center");
			
			ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
			Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
			ImageIcon i3= new ImageIcon(i2);
			JLabel image=new JLabel(i3);
			add(image,"West");
			
			getContentPane().setBackground(Color.WHITE);
			
			setVisible(true);//to see the frame
		}
		
		public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==next) {
			//String name=tfname.getText();//insert in loginx
			String meter=meternumber.getSelectedItem();//insert in loginx  // random meter no is fetched of  digits
		//	String address=tfaddress.getText();
			String month=cmonth.getSelectedItem();
			String units=tfunits.getText();
			
			int totalbill=0;
			int unit_consumed=Integer.parseInt(units);
			
			String query="select * from tax";
			
	    	System.out.println("value inserted successfully");
			try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
			//	c.s.executeUpdate(query2);
				
				while(rs.next()) {
					totalbill+=unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
					totalbill+=Integer.parseInt(rs.getString("meter_rent"));
					totalbill+=Integer.parseInt(rs.getString("servuce_charge"));
					totalbill+=Integer.parseInt(rs.getString("service_tax"));
					totalbill+=Integer.parseInt(rs.getString("swacch_bharat_cess"));
					totalbill+=Integer.parseInt(rs.getString("fixed_tax"));

				}		
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			String query2="insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','Not Paid')";
	    	System.out.println("value inserted successfully");
	    	try {Conn c=new Conn();
	    		 c.s.executeUpdate(query2);
	    		
	    		 JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully" );
	    		 setVisible(false);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		
	    	}
		
		}else {
			setVisible(false);
			
		}
		}
		

		public static void main(String[] args) {
			new CalculateBill();
			
			
			
		}
		
		
	}

	
	


