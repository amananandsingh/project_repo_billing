package electricity.billing.system;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import javax.swing.JFrame;

public class Paytm extends JFrame implements ActionListener{
	
	String meter;
	JButton back;
	Paytm(String meter){
		this.meter=meter;
		
		JEditorPane j=new JEditorPane();
		j.setEditable(false);
		
		try {j.setPage("https://paytm.com/online-payments");
			
		}catch(Exception e) {
			j.setContentType("text/html");//pg u want to show if url is not found
			j.setText("<html>Could Not Load The Following Page<html>");
		}
			//place a scroll
		JScrollPane pane=new JScrollPane(j);
		add(pane);
		
		back=new JButton("Back");
		back.setBounds(640, 20, 80, 30);
		back.addActionListener(this);
		j.add(back);
		//frame
		setSize(800,600);
		setLocation(400,150);
		setVisible(true);
	 
	}

	public static void main(String[] args) {
		new Paytm("");
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new PayBill(meter);
		
	}

}
