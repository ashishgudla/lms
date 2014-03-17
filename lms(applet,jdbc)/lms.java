import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
/*
<applet code="lms" archive="ojdbc14.jar" width=700 height=700>
</applet>
*/
public class lms extends JApplet implements ActionListener 
{
	JButton addS, remS, addB, remB,lendB,takeB,chckA,chckS;
	JPanel a;
	CardLayout cardLO;
	JButton admin, student,go,main,logout,ok;
	JPasswordField t;
	JTextField s1,a11,a12;
	JTextArea s2;
	JLabel a3,a4,lms,lms2;
	JButton a5,a6,a7,a8,a9,a10;
	Connection con=null;
	
	public void init() 
	{
		
		//String url="jdbc:oracle:thin:@(description=(address_list=(address=(protocol=tcp)(port=1521)(host=localhost)))(connect_data=(INSTANCE_NAME=XE)))";
		/*String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="system";
		String password="ashish";
		Connection con=null;*/
		try{
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);*/
			Container cp=this.getContentPane();
			cp.setLayout(new FlowLayout());
	
		
			admin = new JButton("admin");
			student = new JButton("student");
			t=new JPasswordField(50);
			go=new JButton("go");
			lms=new JLabel("------------------------------------------------------------Library Management System------------------------------------------------------------");
			lms2=new JLabel("                                                                                                                                                                                                                                                       ");
			cp.add(lms);
			cp.add(lms2);
			cp.add(admin);
			cp.add(t);
			cp.add(go);
			cp.add(student);
		
		
			cardLO = new CardLayout();
			a = new JPanel();
			a.setLayout(cardLO);
		

 			logout=new JButton("logout");
			main=new JButton("main");
			addS=new JButton("addS");
			remS=new JButton("remS");
			addB=new JButton("addB");
			remB=new JButton("remB");
			lendB=new JButton("lendB");
			takeB=new JButton("takeB");
			chckS=new JButton("chckS");
			chckA=new JButton("chckA");
			a5=new JButton("add student");
			a6=new JButton("remove student");
			a7=new JButton("add book");
			a8=new JButton("remove book");
			a9=new JButton("give book");
			a10=new JButton("take book");
			a3=new JLabel("book:");
			a4=new JLabel("student:");
			a11=new JTextField(25);
			a12=new JTextField(25);
			s2=new JTextArea(50,50);
			s1=new JTextField(25);
	
			JPanel a1 = new JPanel();
			a1.setLayout(null);
			a1.setPreferredSize(new Dimension(700,400));
		
			a1.add(addS);
			addS.setBounds(20,20,100,25);
			addS.setVisible(false);
			a1.add(remS);
			remS.setBounds(120,20,100,25);
			remS.setVisible(false);
			a1.add(addB);
			addB.setBounds(240,20,100,25);
			addB.setVisible(false);
			a1.add(remB);
			remB.setBounds(340,20,100,25);
			remB.setVisible(false);
			a1.add(lendB);
			lendB.setBounds(460,20,100,25);
			lendB.setVisible(false);
			a1.add(takeB);
			takeB.setBounds(560,20,100,25);
			takeB.setVisible(false);
			a1.add(logout);			
			logout.setBounds(590,365,100,25);
			logout.setVisible(false);

			a1.add(a3);
			a3.setBounds(45,100,60,25);
			a1.add(a4);
			a4.setBounds(45,145,60,25);
			a1.add(a11);
			a11.setBounds(100,100,400,25);
			a1.add(a12);
			a12.setBounds(100,145,400,25);
			a1.add(a5);
			a5.setBounds(525,145,100,25);
			a1.add(a7);
			a7.setBounds(525,100,100,25);
			a1.add(a6);
			a6.setBounds(525,145,100,25);
			a1.add(a8);
			a8.setBounds(525,100,100,25);
			a1.add(a9);
			a9.setBounds(125,190,100,25);
			a1.add(a10);
			a10.setBounds(250,190,100,25);
			a3.setVisible(false);
			a4.setVisible(false);
			a5.setVisible(false);
			a6.setVisible(false);
			a7.setVisible(false);
			a8.setVisible(false);
			a9.setVisible(false);
			a10.setVisible(false);
			a11.setVisible(false);
			a12.setVisible(false);
			

			JPanel a2 = new JPanel();
			a2.setLayout(null);
			a2.setPreferredSize(new Dimension(700,400));
		
			a2.add(chckA);
			chckA.setBounds(225,70,100,25);
			a2.add(chckS);
			chckS.setBounds(375,70,100,25);
			a2.add(main);
			main.setBounds(590,365,100,25);
			a2.add(s1);
			s1.setBounds(150,20,400,25);
			a2.add(s2);
			int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
			int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
			JScrollPane jsp = new JScrollPane(s2, v, h);
			a2.add(jsp);
			jsp.setBounds(100,130,500,200);
		
			
			a.add(a1, "admin");
			a.add(a2, "student");
			cp.add(a);
		
			
			admin.addActionListener(this);
			student.addActionListener(this);
			main.addActionListener(this);
			go.addActionListener(this);
			logout.addActionListener(this);
			chckA.addActionListener(this);
			chckS.addActionListener(this);
			addS.addActionListener(this);
			remS.addActionListener(this);
			addB.addActionListener(this);
			remB.addActionListener(this);
			lendB.addActionListener(this);
			takeB.addActionListener(this);
			a5.addActionListener(this);
			a6.addActionListener(this);
			a7.addActionListener(this);
			a8.addActionListener(this);
			a9.addActionListener(this);
			a10.addActionListener(this);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==main) 
		{
			cardLO.show(a, "admin");
			t.setVisible(true);
			go.setVisible(true);
			admin.setVisible(true);
			a3.setVisible(false);
			a4.setVisible(false);
			a5.setVisible(false);
			a6.setVisible(false);
			a7.setVisible(false);
			a8.setVisible(false);
			a9.setVisible(false);
			a10.setVisible(false);
			a11.setVisible(false);
			a12.setVisible(false);
			
		}
		else if(ae.getSource()==student)
		{
			cardLO.show(a, "student");
			t.setVisible(false);
			go.setVisible(false);
			admin.setVisible(false);
		}
		else if(ae.getSource()==go)
		{
			if((t.getText()).equals("ashish"))
			{
				addS.setVisible(true);
				remS.setVisible(true);
				addB.setVisible(true);
				remB.setVisible(true);
				lendB.setVisible(true);
				takeB.setVisible(true);
				logout.setVisible(true);
				student.setVisible(false);
				t.setVisible(false);
				go.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"wrong password","invalid login",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==logout)
		{
			student.setVisible(true);
			addS.setVisible(false);
			remS.setVisible(false);
			addB.setVisible(false);
			remB.setVisible(false);
			lendB.setVisible(false);
			takeB.setVisible(false);
			logout.setVisible(false);
			t.setVisible(true);
			t.setText("");
			go.setVisible(true);

			a3.setVisible(false);
			a4.setVisible(false);
			a5.setVisible(false);
			a6.setVisible(false);
			a7.setVisible(false);
			a8.setVisible(false);
			a9.setVisible(false);
			a10.setVisible(false);
			a11.setVisible(false);
			a12.setVisible(false);
	
		}
		else if(ae.getSource()== chckA)
		{
			s2.setText("BOOK-ID          TITLE                  AUTHOR \n-----------------------------------------------------------\n");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=s1.getText();
				//System.out.println(q);
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("select * from catalogue where bookid=(select bookid from availability where avail=\"yes\")");
				while(srs.next())
				{
					String q1=srs.getString("bookid");
					String q2=srs.getString("title");
					String q3=srs.getString("author");
					if(q.equals(q1)||q.equals(q2)||q.equals(q3))
					s2.setText(q1+"      "+q2+"           "+q3+"\n");
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"invalid argument provided","check availability",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()== chckS)
		{
			s2.setText("BOOK-ID        BOOK-NO \n-----------------------------------\n");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=s1.getText();
				//System.out.println(q);
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("select * from "+ q);
				while(srs.next())
				{
					String q1=srs.getString("bookid");
					String q2=srs.getString("bookno");
					s2.setText(q1+"        "+q2+"\n");
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"student not found","check status",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==addS)
		{
			a3.setVisible(false);
			a4.setVisible(true);
			a5.setVisible(true);
			a6.setVisible(false);
			a7.setVisible(false);
			a8.setVisible(false);
			a9.setVisible(false);
			a10.setVisible(false);
			a11.setVisible(false);
			a12.setVisible(true);
		}

		else if(ae.getSource()==remS)
		{
			a3.setVisible(false);
			a4.setVisible(true);
			a5.setVisible(false);
			a6.setVisible(true);
			a7.setVisible(false);
			a8.setVisible(false);
			a9.setVisible(false);
			a10.setVisible(false);
			a11.setVisible(false);
			a12.setVisible(true);
		}

		else if(ae.getSource()==addB)
		{
			a3.setVisible(true);
			a4.setVisible(false);
			a5.setVisible(false);
			a6.setVisible(false);
			a7.setVisible(true);
			a8.setVisible(false);
			a9.setVisible(false);
			a10.setVisible(false);
			a11.setVisible(true);
			a12.setVisible(false);
		}

		else if(ae.getSource()==remB)
		{
			a3.setVisible(true);
			a4.setVisible(false);
			a5.setVisible(false);
			a6.setVisible(false);
			a7.setVisible(false);
			a8.setVisible(true);
			a9.setVisible(false);
			a10.setVisible(false);
			a11.setVisible(true);
			a12.setVisible(false);
		}

		else if(ae.getSource()==lendB)
		{
			a3.setVisible(true);
			a4.setVisible(true);
			a5.setVisible(false);
			a6.setVisible(false);
			a7.setVisible(false);
			a8.setVisible(false);
			a9.setVisible(true);
			a10.setVisible(false);
			a11.setVisible(true);
			a12.setVisible(true);
		}

		else if(ae.getSource()==takeB)
		{
			a3.setVisible(true);
			a4.setVisible(true);
			a5.setVisible(false);
			a6.setVisible(false);
			a7.setVisible(false);
			a8.setVisible(false);
			a9.setVisible(false);
			a10.setVisible(true);
			a11.setVisible(true);
			a12.setVisible(true);
		}
		else if(ae.getSource()==a5)
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=a12.getText();
				//System.out.println(q);
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("create table "+ q +" (bookid varchar2(10),bookno number(3))");
				JOptionPane.showMessageDialog(null,"student added","add student",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"student not added... already exists","add student",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==a6)
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=a12.getText();
				//System.out.println(q);
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("drop table "+ q );
				JOptionPane.showMessageDialog(null,"student removed","rem student",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"student not found","rem student",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==a7)
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=a11.getText();
				//System.out.println(q);
				StringTokenizer st=new StringTokenizer(q,"-");
				String q1=st.nextToken();
				String q2=st.nextToken();
				String q3=st.nextToken();
				String q4=st.nextToken();
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("insert into catalogue values ("+q1+","+q3+","+q4+")");
				srs=stmt.executeQuery("insert into availability values ("+q1+","+q2+",yes)");
				JOptionPane.showMessageDialog(null,"book added","add book",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"book not added... already exists","add book ",JOptionPane.ERROR_MESSAGE);
			}
	

		}
		else if(ae.getSource()==a8)
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=a11.getText();
				//System.out.println(q);
				StringTokenizer st=new StringTokenizer(q,"-");
				String q1=st.nextToken();
				String q2=st.nextToken();
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("delete from catalogue where bookid="+q1);
				srs=stmt.executeQuery("delete from availabiliy where bookid="+q1+" and bookno="+q2);
				JOptionPane.showMessageDialog(null,"book removed","remove book",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"book not removed... not found","remove book ",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==a9)
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=a11.getText();
				String r=a12.getText();
				//System.out.println(q);
				StringTokenizer st=new StringTokenizer(q,"-");
				String q1=st.nextToken();
				String q2=st.nextToken();
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("select avail from availability where bookid="+q1+" and bookno="+q2);
				String p=srs.getString("avail");
				if(p.equals("yes"))
				{
					srs=stmt.executeQuery("insert into "+r+" values ("+q1+","+q2+")" );
					srs=stmt.executeQuery("update availability set avail=\"no\" where bookid=" +q1+" and bookno=" +q2);
					JOptionPane.showMessageDialog(null,"book issued","give book",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{	throw new Exception();}
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"book not issued","give book ",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(ae.getSource()==a10)
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String password="ashish";
			Connection con=null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,username,password);
			}catch(Exception e){System.out.println("could not connect to db");}
			
			try 
			{
				String q=a11.getText();
				String r=a12.getText();
				//System.out.println(q);
				StringTokenizer st=new StringTokenizer(q,"-");
				String q1=st.nextToken();
				String q2=st.nextToken();
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet srs=stmt.executeQuery("delete from "+r+" where bookid=" +q1+" and bookno=" +q2);
				srs=stmt.executeQuery("update availability set avail=\"yes\" where bookid=" +q1+" and bookno=" +q2);
				JOptionPane.showMessageDialog(null,"book taken","take book",JOptionPane.INFORMATION_MESSAGE);
					
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"could not take..chck database","take book ",JOptionPane.ERROR_MESSAGE);
			}		
		}
		
	}
	
}