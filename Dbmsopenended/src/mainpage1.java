import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class mainpage1 
{

}

class mainframe extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l0,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	JButton b1,b2;
	String proctorname;
	String proctorpswd;
    public mainframe(String pname,String ppassword)
    {
       proctorname = pname;
       proctorpswd = ppassword;
       setVisible(true);  
       setSize(900, 900);  
       setLayout(null);  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       l0 = new JLabel("SET DETAILS");
       l0.setLocation(200, 30);
       l0.setSize(300,20);
       l1 = new JLabel("enter the studentname");
       l1.setLocation(200, 75);
       l1.setSize(300,20);
       t1 = new JTextField(20);
       t1.setSize(180,35);
       t1.setLocation(200, 100);
       l2 = new JLabel("enter the usn");
       l2.setSize(400, 40);
       l2.setLocation(200, 125);
       t2 = new JTextField(20);
       t2.setSize(180,35);
       t2.setLocation(200, 150);
       l3 = new JLabel("enter the email");
       l3.setSize(400, 40);
       l3.setLocation(200, 175);
       t3 = new JTextField(20);
       t3.setSize(180,35);
       t3.setLocation(200, 200);
       l4 = new JLabel("enter the percentage");
       l4.setSize(400, 40);
       l4.setLocation(200, 225);
       t4 = new JTextField(20);
       t4.setSize(180,35);
       t4.setLocation(200, 250);
       b1=new JButton("SUBMIT");
       b1.setSize(100, 40);
       b1.setLocation(200, 300);
       b1.addActionListener(this);
       l5 = new JLabel("GET INFORMATION");
       l5.setLocation(200, 400);
       l5.setSize(300,20);
       l6 = new JLabel("enter the studentname");
       l6.setLocation(200, 450);
       l6.setSize(300,20);
       t6 = new JTextField(20);
       t6.setSize(180,35);
       t6.setLocation(200, 475);
       l7 = new JLabel("enter the usn");
       l7.setLocation(200, 525);
       l7.setSize(300,20);
       t7 = new JTextField(20);
       t7.setSize(180,35);
       t7.setLocation(200, 550);
       b2=new JButton("GETDETAILS");
       b2.setSize(130, 40);
       b2.setLocation(200, 600);
       b2.addActionListener(this);
       
       l8 = new JLabel("proctor name");
       l8.setLocation(600, 75);
       l8.setSize(300,20);
       t8 = new JTextField(20);
       t8.setSize(180,35);
       t8.setLocation(600, 100);
       l9 = new JLabel("age");
       l9.setLocation(600, 150);
       l9.setSize(300,20);
       t9 = new JTextField(20);
       t9.setSize(180,35);
       t9.setLocation(600, 170);
       l10 = new JLabel("farther name");
       l10.setLocation(600, 210);
       l10.setSize(300,20);
       t10 = new JTextField(20);
       t10.setSize(180,35);
       t10.setLocation(600, 240);
       l11 = new JLabel("mother name");
       l11.setLocation(600, 290);
       l11.setSize(300,20);
       t11 = new JTextField(20);
       t11.setSize(180,35);
       t11.setLocation(600, 310);
       l12 = new JLabel("interested sports");
       l12.setLocation(600, 350);
       l12.setSize(300,20);
       t12 = new JTextField(20);
       t12.setSize(180,35);
       t12.setLocation(600, 380);
       
       
       
       
       add(l1);
       add(l0);
       add(l2);
       add(t1);
       add(t2);
       add(t3);
       add(t4);
       add(l3);
       add(l4);
       add(l5);
       add(l6);
       add(l7);
       add(t6);
       add(t7);
       add(b1);
       add(b2);
       add(l8);
       add(l9);
       add(l10);
       add(l11);
       add(l12);
       add(t8);
       add(t9);
       add(t10);
       add(t11);
       add(t12);
    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String ActionPerformed = ae.getActionCommand();
		if(ActionPerformed.equals("SUBMIT"))
		{
			String name = t1.getText();
			String usn = t2.getText();
			String email = t3.getText();
			String per = t4.getText();
			int p=Integer.parseInt(per);
			String groupp= t8.getText();
			String age= t9.getText();
			int ag=Integer.parseInt(age);
			String fatherName = t10.getText();
			String MotherName = t11.getText();
			String sports = t12.getText();
            try
            {
            	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/openended","root","19mar1999");
            	//Insert
            	String query1="insert into student1(name,usn,email,percenatge,gr,age,fathername,mothername,sports)"+"values(?,?,?,?,?,?,?,?,?)";
            	PreparedStatement ps=connection.prepareStatement(query1);
                ps.setString(1, name);  
                ps.setString(2, usn);
                ps.setString(3, email);
                ps.setInt(4, p);
                ps.setString(5, groupp);
                ps.setInt(6, ag);
                ps.setString(7, fatherName);
                ps.setString(8, MotherName);
                ps.setString(9, sports);
                ps.execute();
            }
            catch(Exception e)
            {
            	System.out.println("connection fails"+e);
            }
            dispose();
            new mainframe(sports, sports);
	   }
		if(ActionPerformed.equals("GETDETAILS"))
		{
			String name = t6.getText();
			String usn =  t7.getText();
			try
			{
				 Statement stmt = null;
				 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/openended","root","19mar1999");
				 stmt = conn.createStatement();
				 ResultSet rs = null;
				 stmt.execute("select * from student1 where gr='"+proctorname+"'");
				 rs = stmt.getResultSet();
				 String sname,susn,semail,sfn,smn,sgp,ssp,sspo;
				 int sper,sage1;
				 int count=0;
				 while(rs.next())
				 {
					 sname = rs.getString("name");
					 susn= rs.getString("usn");
					 semail= rs.getString("email");
					 sfn= rs.getString("fathername");
					 smn= rs.getString("mothername");
					 sgp= rs.getString("gr");
					 sspo= rs.getString("sports");
					 sage1= rs.getInt("age");
					 sper=rs.getInt("percenatge");
					   if(sname.equals(name) && susn.equals(usn))
                       {
						   count=1;
						   dispose();
						   new setpage(sname,susn,semail,sper,sfn,sage1,smn,sgp,sspo,proctorname,proctorpswd);
                       }
                     
				 }
				 if(count==0)
				 {
					 JOptionPane.showMessageDialog(this, "INVALID username or password","error",JOptionPane.ERROR_MESSAGE);
				 }
			}
			catch(Exception e)
			{
				
			}
		}
  }
}

class setpage extends JFrame implements ActionListener
{
	JLabel ls1,ls2,ls3,ls4,ls5,ls6,ls7,ls8,ls9,ls11,ls21,ls31,ls41,ls51,ls61,ls71,ls81,ls91;
	JButton back;
	String pna,ppwsd;
     setpage(String s1,String s2,String s3,int a,String s4,int s5,String s6,String s7,String s8,String pn,String ppwd)
     {
    	 pna=pn;
    	 ppwsd=ppwd;
    	 String sp=Integer.toString(a);
    	 String sa=Integer.toString(s5);
    	 setVisible(true);  
 	     setSize(900, 900);  
 	     setLayout(null);  
 	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 ls1 = new JLabel(s1);
         ls1.setLocation(400, 75);
         ls1.setSize(300,20);
         ls2 = new JLabel(s2);
         ls2.setLocation(400, 100);
         ls2.setSize(300,20);
         ls3 = new JLabel(s3);
         ls3.setLocation(400, 125);
         ls3.setSize(300,20);
         ls4 = new JLabel(sp);
         ls4.setLocation(400, 150);
         ls4.setSize(300,20);
         ls5 = new JLabel(sa);
         ls5.setLocation(400, 175);
         ls5.setSize(300,20);
         ls9 = new JLabel(s4);
         ls9.setLocation(400, 200);
         ls9.setSize(300,20);
         ls6 = new JLabel(s6);
         ls6.setLocation(400, 225);
         ls6.setSize(300,20);
         ls7 = new JLabel(s7);
         ls7.setLocation(400, 250);
         ls7.setSize(300,20);
         ls8 = new JLabel(s8);
         ls8.setLocation(400, 275);
         ls8.setSize(300,20);
         
         
         ls11 = new JLabel("NAME");
         ls11.setLocation(200, 75);
         ls11.setSize(300,20);
         ls21 = new JLabel("USN");
         ls21.setLocation(200, 100);
         ls21.setSize(300,20);
         ls31 = new JLabel("EMAIL");
         ls31.setLocation(200, 125);
         ls31.setSize(300,20);
         ls41 = new JLabel("PERCENTAGE");
         ls41.setLocation(200, 150);
         ls41.setSize(300,20);
         ls51 = new JLabel("AGE");
         ls51.setLocation(200, 175);
         ls51.setSize(300,20);
         ls91 = new JLabel("FATHER NAME");
         ls91.setLocation(200, 200);
         ls91.setSize(300,20);
         ls61 = new JLabel("MOTHER NAME");
         ls61.setLocation(200, 225);
         ls61.setSize(300,20);
         ls71 = new JLabel("PROCTOR NAME");
         ls71.setLocation(200, 250);
         ls71.setSize(300,20);
         ls81 = new JLabel("SPORTS");
         ls81.setLocation(200, 275);
         ls81.setSize(300,20);
         
         back = new JButton("BACK");
         back.setSize(100, 40);
         back.setLocation(250, 350);
         back.addActionListener(this);
         
         add(ls1);
         add(ls2);
         add(ls3);
         add(ls4);
         add(ls5);
         add(ls6);
         add(ls7);
         add(ls8);
         add(ls9);
         add(ls11);
         add(ls21);
         add(ls31);
         add(ls41);
         add(ls51);
         add(ls61);
         add(ls71);
         add(ls81);
         add(ls91);
         add(back);
     }
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String ActionPerformed = ae.getActionCommand();
		if(ActionPerformed.equals("BACK"))
		{
			dispose();
			new mainframe(pna,ppwsd);
		}
	}
}