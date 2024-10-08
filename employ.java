package xyzcomp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class employ {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employ window = new employ();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public employ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(116, 10, 317, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMP ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(68, 76, 96, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EMP NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(68, 133, 96, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SALARY");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(68, 183, 96, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("JOIN DATE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(68, 234, 96, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(271, 77, 170, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(271, 128, 170, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(271, 189, 170, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(271, 239, 170, 34);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Roopa@3111");
					stmt=con.createStatement();
					String empid= textField.getText();
					String name= textField_1.getText();
					String salary= textField_2.getText();
					String jdate= textField_3.getText();
					String INSERT="INSERT INTO EMPLOYEE VALUES('"
							+empid+"','"+name+"','"+salary+"','"+jdate+"');";
					stmt.executeUpdate(INSERT);
					System.out.println("Record inserted successfully");
					btnNewButton.setEnabled(true);
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(48, 303, 134, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DISPLAY");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Roopa@3111");
					stmt=con.createStatement();
					int id;
					id=Integer.parseInt(textField.getText());
					String sql="select name,salary,jdate from employee where id='"+id+"'"; 
					ResultSet rs1=stmt.executeQuery(sql);
					rs1.next();
					textField_1.setText(rs1.getString(1));
					textField_2.setText(rs1.getString(2));
					textField_3.setText(rs1.getString(3));
					
					
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			}
		});
		btnNewButton_1.setBounds(215, 303, 147, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Roopa@3111");
					stmt=con.createStatement();
					int id;
					id=Integer.parseInt(textField.getText());
					String delete="delete from employee where id='"+id+"'";
					stmt.executeUpdate(delete);
					System.out.println("Record deleted successfully");
					btnNewButton.setEnabled(true);
					
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			}
		});
		btnNewButton_2.setBounds(403, 303, 128, 40);
		frame.getContentPane().add(btnNewButton_2);
	}
}
