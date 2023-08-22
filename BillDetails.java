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
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
public class BillDetails extends JFrame  {
	BillDetails(String meter){
		setSize(700,650);
		setLocation(400,150);
		
		getContentPane().setBackground(Color.WHITE);
		
		JTable table=new JTable();
		
		try {Conn c=new Conn();
			String query="select * from bill where meter_no='"+meter+"'";
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs) );//to put bill details inside a table
		}catch(Exception e){
			e.printStackTrace();
		}
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(0,0,700,650);
		add(sp);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new BillDetails("");
	}

}
