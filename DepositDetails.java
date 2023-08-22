package electricity.billing.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
//details about deposit and individual search
public class DepositDetails extends JFrame implements ActionListener{
	
	Choice meternumber,cmonth;
	JTable table;
	JButton search,print;
	
	DepositDetails(){
		super("DepositDetails");
		
		setSize(700,700);
		setLocation(400,100);
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
	JLabel lblmeternumber=new JLabel("Search By Meter Number");
	lblmeternumber.setBounds(20,20,150,20);
	add(lblmeternumber);
	
	meternumber=new Choice();
	meternumber.setBounds(180,20,150,20);
	add(meternumber);
	
	try {
		Conn c = new Conn();
		ResultSet rs=c.s.executeQuery("select * from customer");
		while(rs.next()) {
			meternumber.add(rs.getString("meter_no"));
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	
	JLabel lblmonth=new JLabel("Search By Month");
	lblmonth.setBounds(380,20,150,20);
	add(lblmonth);
	
	cmonth=new Choice();
	cmonth.setBounds(530,20,150,20);
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
	add(cmonth);
	
	table=new JTable();
	try {
		Conn c = new Conn();
		ResultSet rs=c.s.executeQuery("select * from bill");
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}catch (Exception e){
		e.printStackTrace();
	}
	//to insert scroll bar in table we create another class
	JScrollPane sp=new JScrollPane(table);
	sp.setBounds(0,100,700,600);
	add(sp);
	//buttons for print and search
	search=new JButton("Search");
	search.setBounds(20, 70, 80, 20);
	search.addActionListener(this);
	add(search);

	print=new JButton("Print");
	print.setBounds(120, 70, 80, 20);
	print.addActionListener(this);
	add(print);		
	
	
	setVisible(true);
	}//action related to search and print is specified here
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==search) {
		String query="select * from bill where meter_no='"+meternumber.getSelectedItem()+"' and month='"+cmonth.getSelectedItem()+"'";	
		
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		else {
			try {
				table.print();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DepositDetails();

	}

}
