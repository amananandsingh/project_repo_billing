package electricity.billing.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
//details about deposit and individual search
public class CustomerDetails extends JFrame implements ActionListener{
	
	Choice meternumber,cmonth;
	JTable table;
	JButton search,print;
	
	CustomerDetails(){
		super("CustomerDetails");
		
		setSize(1200,650);
		setLocation(200,150);
		
	
	table=new JTable();
	try {
		Conn c = new Conn();
		ResultSet rs=c.s.executeQuery("select * from customer");
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}catch (Exception e){
		e.printStackTrace();
	}
	//to insert scroll bar in table we create another class
	JScrollPane sp=new JScrollPane(table);
	add(sp);
	//button for print;
	

	print=new JButton("Print");
	print.addActionListener(this);
	add(print, "South");		
	
	
	setVisible(true);
	}//action related to search and print is specified here
	public void actionPerformed(ActionEvent ae) {
					try {
						table.print();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
	
	
	
	public static void main(String[] args) {
		new CustomerDetails();

	}

}
