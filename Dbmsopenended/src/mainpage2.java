import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class mainpage2 {
	public static void main(String rags[])
	{
	  new proctor();
	}
}

class proctor extends JFrame implements ActionListener
{
    JLabel lp1,lp2,lp3;
    JTextField tp1;
    JPasswordField tp2;
    JButton bp1;
	proctor()
	{
		   setVisible(true);  
	       setSize(900, 900);  
	       setLayout(null);  
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       lp3 = new JLabel("PROCTOR LOGIN");
	       lp3.setLocation(200, 40);
	       lp3.setSize(500,70);
	       lp3.setFont(lp3.getFont().deriveFont(50.0f));
	       lp1 = new JLabel("PROCTOR NAME");
	       lp1.setLocation(200, 125);
	       lp1.setSize(300,20);
	       tp1 = new JTextField(20);
	       tp1.setSize(180,35);
	       tp1.setLocation(200, 150);
	       lp2 = new JLabel("PASSWORD");
	       lp2.setLocation(200, 200);
	       lp2.setSize(300,20);
	       tp2 = new JPasswordField();
	       tp2.setSize(180,35);
	       tp2.setLocation(200, 225);
	       bp1= new JButton("ENTER");
	       bp1.setSize(180,35);
	       bp1.setLocation(200, 300);
	       bp1.addActionListener(this);
	       add(lp1);
	       add(lp2);
	       add(tp1);
	       add(tp2);
	       add(bp1);
	       add(lp3);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String ActionPerformed = ae.getActionCommand();
		if(ActionPerformed.equals("ENTER"))
		{
			String pname = tp1.getText();
			String ppassword = tp2.getText();
			try
			{
				 Statement stmt = null;
				 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/openended","root","19mar1999");
				 stmt = conn.createStatement();
				 ResultSet rs = null;
				 stmt.execute("select * from proctor");
				 rs = stmt.getResultSet();
				 String pn,ppwd;
				 int verify=0;
				 while(rs.next())
				 {
					 pn   = rs.getString("proctornamee");
					 ppwd = rs.getString("password");
					 System.out.println("pname"+pn);
					 System.out.println(ppwd);
					 if(pname.equals(pn) && ppassword.equals(ppwd))
					 {
						 System.out.println("finally");
						 verify=1;
						 dispose();
						 mainframe p = new mainframe(pname,ppassword);
					 }
					 else
					 {
						 System.out.println("something is going wrong");
					 }
				 }
				 if(verify==0)
				 {
					 JOptionPane.showMessageDialog(this, "INVALID you are not admin","error",JOptionPane.ERROR_MESSAGE);
				 }
			}
			catch(Exception e)
			{
				System.out.println("something is going wrong exception");
			}
			
		}
		
	}
	
}

