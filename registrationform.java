//RAGISTRATION FORM
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class registrationform extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	String d2="",d3="",d4="",d5="",d6="",d7="";
	JComboBox c1,c2,c3,c4;
	JRadioButton r1,r2,r3;
	JButton b1,b2,b4;
	ButtonGroup b3;
	Font f;
	
	String a[]={"A+","B+","AB+","O+","A-","B-","AB-","O-"};		//BLOODGROUP
	String a2[]={"PUNE","MUMBAI","AURANGABAD","NAGPUR","JAIPUR","UDAIPUR","KOTA","SURAT","AHMEDABAD","RAJKOT","DWARKA","KOCHI","KANNUR","KOLLAM","MUNNAR"};  //CITY
	String a1[]={"MAHARASHTRA","RAJASTHAN","GUJARAT","KERALA"};		//STATES
	String a3[]={"KIDNEY","HEART","PANCREAS","EYES","LIVER","PLASMA","BONE-MARROW"};	//ORGAN TO DONATE

	int rn;
	Container cp=getContentPane();
	Connection c=null;

	/*public static void main(String [] args)
	{
		registrationform or1= new registrationform();
	}*/
	public registrationform()
	{
		String cs,uid,pwd;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");		
			cs="jdbc:mysql://localhost:3306/organlabmanagement";
			uid="root";
			pwd="root";
			c=DriverManager.getConnection(cs,uid,pwd);		//Connection Successfully

			//Query for count rid
			String q="select count(*) as rid from registration";
			Statement st=c.createStatement();
			ResultSet r=st.executeQuery(q);
			r.next();
			rn=r.getInt("rid");
			System.out.println(rn);

		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			
		}
		setLayout(null);
	
		f=new Font("Arial",Font.BOLD,15);
		l13=new JLabel(new ImageIcon("regbag.jpg"));

	
		l1=new JLabel("Registration ID :   ");
		l1.setFont(f);

		l2=new JLabel("Enter Patient Name :");
		l2.setFont(f);

		l3=new JLabel("Enter Patient Age  :");
		l3.setFont(f);

		l4=new JLabel("Blood Group        :");
		l4.setFont(f);

		l5=new JLabel("Any  Diesease      :");
		l5.setFont(f);

		l6=new JLabel("Address            :");
		l6.setFont(f);

		l8=new JLabel("City               :");
		l8.setFont(f);

		l7=new JLabel("State              :");
		l7.setFont(f);

		l9=new JLabel("Organs To Donate   :");
		l9.setFont(f);

		l10=new JLabel("Registration Date :");
		l10.setFont(f);

		l11=new JLabel("Gender            :");
		l11.setFont(f);

		l12=new JLabel("Phone NO          :");
		l12.setFont(f);
		
		
		t1=new JTextField(""+(rn+1));//counted rid
		t1.setEnabled(false);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		

		c1=new JComboBox(a);
		c1.setFont(f);
		c1.setForeground(Color.black);

		c2=new JComboBox(a1);
		c2.setFont(f);
		c2.setForeground(Color.black);

		c3=new JComboBox(a2);
		c3.setFont(f);
		c3.setForeground(Color.black);

		c4=new JComboBox(a3);
		c4.setFont(f);
		c4.setForeground(Color.black);


		r1=new JRadioButton("Male");
		r1.setFont(f);
		r1.setForeground(Color.black);

		r2=new JRadioButton("Female");
		r2.setFont(f);
		r2.setForeground(Color.black);

		r3=new JRadioButton("Other");
		r3.setFont(f);
		r3.setForeground(Color.black);

		
		b1=new JButton("Submit");
		b1.setFont(f);
		b1.setForeground(Color.black);

		b2=new JButton("Clear");
		b2.setFont(f);
		b2.setForeground(Color.black);

		b4=new JButton("Back");
		b4.setFont(f);
		b4.setForeground(Color.black);

		b3= new ButtonGroup();	//for radiobutton

		setTitle("REGISTRATION FORM");
	
		l1.setBounds(30,30,130,25);		//Registration ID	
		l2.setBounds(30,70,200,25);		//Patient Name
		l3.setBounds(30,110,200,25);	//Patient Age
		l11.setBounds(30,150,130,25);	//gender
		l4.setBounds(30,190,130,25);	//Blood Group
		l5.setBounds(30,230,130,25);	//Diesease
		l6.setBounds(30,270,130,25);	//Address
		l7.setBounds(30,310,130,25);	//State
		l8.setBounds(30,350,130,25);	//city
		l9.setBounds(30,390,200,25);	//Organs To Donate
		l10.setBounds(30,430,200,25);	//Registration Date
		l12.setBounds(30,470,130,25);	//Phone Number
		l13.setBounds(0,0,500,750);		//Background Image
	

		t1.setBounds(250,30,130,25);	//Registration ID
		t2.setBounds(250,70,130,25);	//Patient Name
		t3.setBounds(250,110,130,25);	//Patient Age
		t4.setBounds(250,230,130,25);	//Diesease
		t5.setBounds(250,270,130,25);	//Address
		t6.setBounds(250,430,130,25);	//Registration Date
		t7.setBounds(250,470,130,25);	//Phone Number
		

		c1.setBounds(250,190,130,25);	//Blood Group
		c2.setBounds(250,310,130,25);	//State
		c3.setBounds(250,350,130,25);	//city
		c4.setBounds(250,390,130,25);	//Organs To Donate

		r1.setBounds(195,150,70,25);	//Male
		r2.setBounds(290,150,70,25);	//Female
		r3.setBounds(400,150,70,25);	//other

		b1.setBounds(200,530,100,50);	//Submit
		b2.setBounds(320,530,100,50);	//Clear
		b4.setBounds(80,530,100,50);	//Back
		
		add(l1);		//Registration ID
		add(t1);

		add(l2);		//Patient Name
		add(t2);

		add(l3);		//Patient Age
		add(t3);

		add(l11);		//Gender
		b3.add(r1);
		b3.add(r2);
		b3.add(r3);
		
		add(r1);		//radiobutton
		add(r2);
		add(r3);
		
		add(l4);		//Blood Group
		add(c1);

		add(l5);		//Diesease
		add(t4);

		add(l6);		//Address
		add(t5);
		
		add(l7);		//State
		add(c2);
		
		add(l8);		//city
		add(c3);

		add(l9);		//Organs To Donate
		add(c4);

		add(l10);		//Ragistration date
		add(t6);

		add(l12);		//Phone no
		add(t7);
		
		add(b1);		//Submit
		add(b2);		//Clear
		add(b4);		//Back
		
		add(l13);		//bgimage

		setSize(500,750);	//size of form
		setVisible(true);
		setResizable(false);		//To Set Size Fix
		setLocationRelativeTo(null);	//center to screen

		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b4.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)		//SUBMIT
		{
			//messagebox for Empty textfield
			if(t2.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Please Enter Your Name: ");
			else if(t3.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Please Enter age: ");
			else if(r1.isSelected()==false &&r2.isSelected()==false&&r3.isSelected()==false)
				JOptionPane.showMessageDialog(this,"Please Select Gender: ");
			else if(t4.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Please Enter Disease: ");
			else if(t5.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Please Enter Address: ");
			else if(t6.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Please Enter Registration Date: ");
			else if(t7.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Please Enter Number: ");
			else
			{
				d7=t7.getText();	//phoneno checking
				System.out.println("Ph no="+d7);
				if(d7.length()<10 ||d7.length()>10)
				{
					JOptionPane.showMessageDialog(this,"Please Enter valid Number: ");

				}
				else
				{			
					rn=Integer.parseInt(t1.getText());		//rid
					System.out.println("rid"+rn);

					d2=t2.getText();						//name
					System.out.println("pname="+d2);

					d3=t3.getText();
					System.out.println("page="+d3);			//age

					String m1="";							//gender
					if(r1.isSelected())
						m1="Male";
					else if(r2.isSelected())
						m1="FeMale";
					else if(r3.isSelected())
						m1="Other";
					System.out.println(m1);

					String m2="",m3="",m4="",m5="";			//bloodgroup
					m2=(c1.getItemAt(c1.getSelectedIndex())).toString();
					System.out.println(" "+m2);

					d4=t4.getText();						//disease
					System.out.println("disease="+d4);

					d5=t5.getText();						//address
					System.out.println("Address="+d5);

					m3=(c2.getItemAt(c2.getSelectedIndex())).toString();	//state
					System.out.println(" Your state is:"+m3);

					m4=(c3.getItemAt(c3.getSelectedIndex())).toString();	//city
					System.out.println(" Your City is:"+m4);

					m5=(c4.getItemAt(c4.getSelectedIndex())).toString();	//organ donate
					System.out.println(" Organ To Donate is:"+m5);

					d6=t6.getText();						//date
					System.out.println("rdate="+d6);

					try			//Quary for insert database
					{
						String p="insert into registration values("+t1.getText()+",'"+d2+"',"+d3+",'"+m1+"','"+m2+"','"+d4+"','"+d5+"','"+m3+"','"+m4+"','"+m5+"',STR_TO_DATE('"+d6+"','%d/%m/%Y')"+",'"+d7+"','n')";
						Statement st=c.createStatement();
						st.executeUpdate(p);		//Record saved successfully
						JOptionPane.showMessageDialog(this,"Registration succesfully");
						st.close();
						c.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					finally
					{
					}
				}
			}
		}
		else if(e.getSource()==b2)		//CLEAR BUTTON
		{
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
		}
		else if(e.getSource()==b4)		//BACK BUTTON
		{
			selectionform or1=new selectionform();//selectionform
			this.hide();
		}
		
		
	}

}
