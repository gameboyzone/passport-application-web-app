import java.applet.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Form extends Applet implements ActionListener,WindowListener 
{
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
TextField t2,t3,t4,t6,t7,t8,t9,t12,t13,t14;
TextArea ta,ta1,ta2;
Choice c1,c2,c3;
Button b1;
Frame f1,f2;
Connection c;
Statement s;

public void init()
{
l1=new Label("Passport Office :");
l2=new Label("District :");
l3=new Label("Surname :");
l4=new Label("First Name :");
l5=new Label("Sex :");
l6=new Label("Marital Status :");
l7=new Label("Date of Birth :");
l8=new Label("Place of Birth :");
l9=new Label("Height (in cms.) :");
l10=new Label("Profession :");
l11=new Label("Permanent Address :");
l12=new Label("Residence No. :");
l13=new Label("Mobile No. :");
l14=new Label("E-mail Address :");
t2=new TextField(15);
t2.setText("Mumbai");
t2.setEditable(false);
t2.setFocusable(false);
t3=new TextField(15);
t4=new TextField(15);
t6=new TextField(15);
t7=new TextField(15);
t8=new TextField(15);
t9=new TextField(15);
t12=new TextField(15);
t13=new TextField(15);
t14=new TextField(15);
ta=new TextArea();
ta1=new TextArea();
ta1.setText("Please ensure all the fields are Complete");
ta2=new TextArea();
ta2.setText("Your application has been acknowledged.\n\nYou will receive a call from the concerned Post-Office within the next 10 days.\n\nThank you for using Online Passport Registration.");
c1=new Choice();
c1.add("Virar-Dahisar");
c1.add("Borivli-Andheri");
c1.add("Vile Parle-Bandra");
c1.add("Bandra-Churchgate");
c2=new Choice();
c2.add("Male");
c2.add("Female");
c3=new Choice();
c3.add("Single");
c3.add("Married");
c3.add("Divorcee");
c3.add("Widow / Widower");
b1=new Button("[  Submit  ]");
f1=new Frame("!!!!  Alert  !!!!");
f2=new Frame("<---- Application processed successfully ---->");

setLayout(new FlowLayout(FlowLayout.LEFT));

add(l1);
add(c1);
add(l2);
add(t2);
add(l3);
add(t3);
add(l4);
add(t4);
add(l5);
add(c2);
add(l6);
add(c3);
add(l7);
add(t6);
add(l8);
add(t7);
add(l9);
add(t8);
add(l10);
add(t9);
add(l11);
add(ta);
add(l12);
add(t12);
add(l13);
add(t13);
add(l14);
add(t14);
add(b1);
f1.add(ta1);
f2.add(ta2);

b1.addActionListener(this);
f1.addWindowListener(this);
f2.addWindowListener(this);
}

public void paint(Graphics g)
{
//showStatus("Guru says Lolz...");

l1.setLocation(10,10);
c1.setLocation(120,10);
l2.setLocation(290,10);
t2.setLocation(380,10);
l3.setLocation(10,55);
t3.setLocation(120,55);
l4.setLocation(290,55);
t4.setLocation(380,55);
l5.setLocation(10,100);
c2.setLocation(120,100);
l6.setLocation(290,100);
c3.setLocation(385,100);
l7.setLocation(10,145);
t6.setLocation(120,145);
l8.setLocation(290,145);
t7.setLocation(385,145);
l9.setLocation(10,190);
t8.setLocation(120,190);
l10.setLocation(290,190);
t9.setLocation(380,190);
l11.setLocation(10,235);
ta.setLocation(160,235);
//t11.setLocation(160,280);
l12.setLocation(10,325);
t12.setLocation(120,325);
l13.setLocation(290,325);
t13.setLocation(385,325);
l14.setLocation(10,370);
t14.setLocation(120,370);
b1.setLocation(230,425);

ta.setSize(250,65);
ta1.setEditable(false);
ta1.setFocusable(false);
ta2.setEditable(false);
ta2.setFocusable(false);
b1.setSize(80,25);

f1.setSize(400,100);
f2.setSize(450,160);
f1.setVisible(false);
f2.setVisible(false);
f1.setResizable(false);
f2.setResizable(false);
}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
		if((t2.getText().equals(""))||(t3.getText().equals(""))||(t4.getText().equals(""))||(t6.getText().equals(""))||(t7.getText().equals(""))||(t8.getText().equals(""))||(t9.getText().equals(""))||(ta.getText().equals(""))||(t12.getText().equals(""))||(t13.getText().equals(""))||(t14.getText().equals("")))
		{
		f1.setVisible(true);
		}
		
		else
		{
		
		String s1=c1.getSelectedItem();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		String s5=c2.getSelectedItem();
		String s6=c3.getSelectedItem();
		String s7=t6.getText();
		String s8=t7.getText();
		String s9=t8.getText();
		String s10=t9.getText();
		String s11=ta.getText();
		String s12=t12.getText();
		String s13=t13.getText();
		String s14=t14.getText();
		
		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		c=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"Records.mdb"+";DriverID=22;READONLY=false");
		s=c.createStatement();
	
		//s.execute("Create table Records(Passport_office text(30),District text(15),Surname text(30),First_name text(30),Sex text(10),Marital_status text(20),DOB text(20),POB text(20),Height text(5),Profession text(30),Permanent_Address text(255),Residence text(15),mobile text(15),email text(30))");
		s.execute("insert into Records values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"');");
		
		s.close();
		c.close();
		}
	
		catch(Exception e1)
		{
		e1.printStackTrace();
		}
		
		f2.setVisible(true);
		
		t2.setText("Mumbai");
		t3.setText("");
		t4.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
		ta.setText("");
		t12.setText("");
		t13.setText("");
		t14.setText("");
			
		}
	}
} 

public void windowOpened(WindowEvent e2)
{
}

public void windowClosed(WindowEvent e2)
{
}

public void windowClosing(WindowEvent e2)
{
	if(e2.getSource()==f1)
	{
	f1.setVisible(false);
	f1.dispose();
	}

	if(e2.getSource()==f2)
	{
	f2.setVisible(false);
	f2.dispose();
	}
}

public void windowIconified(WindowEvent e2)
{
	if(e2.getSource()==f1)
	{
	f1.setVisible(false);
	f1.dispose();
	}

	if(e2.getSource()==f2)
	{
	f2.setVisible(false);
	f2.dispose();
	}
}

public void windowDeiconified(WindowEvent e2)
{
}

public void windowActivated(WindowEvent e2)
{
}

public void windowDeactivated(WindowEvent e2)
{
	if(e2.getSource()==f1)
	{
	f1.setVisible(false);
	f1.dispose();
	}

	if(e2.getSource()==f2)
	{
	f2.setVisible(false);
	f2.dispose();
	}
}

}