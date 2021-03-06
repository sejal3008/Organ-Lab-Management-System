//Login Form For OrganLabManagement
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class login extends JFrame implements ActionListener  
{
	JLabel l1,l2,l3,l4;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	String u,v;
	Font f,f1;
	

	public static void main(String[] args) 
	{

		login o1=new login();

	}		
	public login()
	{
		Connection c1;
		String cs,uid,pwd;
		
		f=new Font("Elephant",Font.BOLD,20);
		f1=new Font("Arial",Font.BOLD,16);
		l4=new JLabel(new ImageIcon("logbag1.jpg"));
	
		l3=new JLabel("LOGIN PAGE");
		l3.setFont(f);

		l1=new JLabel("User-Name: ");
		l1.setFont(f1);
		l1.setForeground(Color.blue);

		l2=new JLabel("Password: ");
		l2.setFont(f1);
		l2.setForeground(Color.blue);

		t1=new JTextField(20);
		t2=new JPasswordField(8);

		b1=new JButton("Login");
		b1.setFont(f1);
		b1.setForeground(Color.black);
		
		b2=new JButton("Clear");
		b2.setFont(f1);
		b2.setForeground(Color.black);
	
		setLayout(null);
		setTitle("Organ Management Lab- The Life Saver");
		

		l4.setBounds(0,0,400,400);		//Backgroud image
		l3.setBounds(100,50,200,25);	//LoginTitle
		l1.setBounds(50,100,200,25);	//UserName
		l2.setBounds(50,150,100,25);	//PWD

		t1.setBounds(200,100,100,25);	//UserName Input
		t2.setBounds(200,150,100,25);	//PWDInput

		b2.setBounds(200,200,100,40);	//ClearButton
		b1.setBounds(50,200,100,40);	//LoginButton
		
		
		add(l3);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		add(l4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setVisible(true);
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);

		b1.addActionListener(this);
		b2.addActionListener(this);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");		//databaseconnection
			cs="jdbc:mysql://localhost:3306/organlabmanagement";
			uid="root";
			pwd="root";
			c1=DriverManager.getConnection(cs,uid,pwd);		//successfullyconnected

			//Query To Connect Database username and PWD
			String q="select username,pwd from login";
			Statement st=c1.createStatement();
			ResultSet r=st.executeQuery(q);
		
			if(r.next())
			{
				u=r.getString("username");
				v=r.getString("pwd");
			}
			st.close();
			c1.close();
		
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		String m,n;
		m=t1.getText();
		n=t2.getText();
		if(e.getSource()==b1)//LOGIN BUTTON CODE
		{
			//Compare Username and PWD
			if(m.compareTo(u)==0 && n.compareTo(v)==0)
			{
				JOptionPane.showMessageDialog(this,"Login Successfully");
				selectionform s= new selectionform();//next form obj (selection form)
				this.hide();
			}
			else
				JOptionPane.showMessageDialog(this,"Enter Valid Username or Password");

		}
		else if(e.getSource()==b2)//CLEAR BUTTON CODE
		{
			t1.setText("");
			t2.setText("");
		}

	}
}