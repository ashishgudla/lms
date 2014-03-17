import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="lmsgui" width=700 height=700>
</applet>
*/
public class lmsgui extends JApplet implements ActionListener 
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
	
	public void init() 
	{
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
		a5=new JButton("add Student");
		a6=new JButton("remove Student");
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
			s2.setText("checking availability....");
		}
		else if(ae.getSource()== chckS)
		{
			s2.setText("checking status....");
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
		
		
	}
	
}