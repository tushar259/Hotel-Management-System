import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Payment extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label,label2,label3;
	private JRadioButton radioButton1,radioButton2;
	private ButtonGroup buttonGroup;
	private JButton button,button1,button2;
	private int rPrice;
	private double pr;
    private double pr1;
	
	public Payment(){}
	
	public Payment(int roomPrice){
		super("Payment");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		rPrice=roomPrice;
		
		check();
		check1();
		
		label2=new JLabel("Current Balance: "+pr);
		label2.setBounds(280,100,250,40);
		panel.add(label2);
		
		label3=new JLabel("Room Price: "+pr1);
		label3.setBounds(280,150,250,40);
		panel.add(label3);
		
		label=new JLabel("How do you want to pay ?");
		label.setBounds(280,200,300,40);
		panel.add(label);
		
		radioButton1=new JRadioButton("Credit Card");
		radioButton1.setBounds(290,240,300,40);
		panel.add(radioButton1);
		
		radioButton2=new JRadioButton("Debit Card");
		radioButton2.setBounds(290,280,300,40);
		panel.add(radioButton2);
		
		buttonGroup=new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		
		button=new JButton("Next");
		button.setBounds(290,320,100,40);
		panel.add(button);
		button.addActionListener(this);
		
		button1=new JButton("Back");
		button1.setBounds(10,10,100,40);
		panel.add(button1);
		button1.addActionListener(this);
		
		button2=new JButton("Log Out");
		button2.setBounds(680,10,100,40);
		panel.add(button2);
		button2.addActionListener(this);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			BookRooms h=new BookRooms(1,2);
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Log Out")){
			Login l=new Login(1,2,3,4,5,6,7,8,9);
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Next")){
			//Successful p=new Successful(1);
			//p.setVisible(true);
			//this.setVisible(false);
			//boolean b1=radioButton1.isSelected();
			//boolean b2=radioButton2.isSelected();
			updateInDB();
		}
	}
	public void updateInDB()
	{
        String email="";
		double newBalance=0.0;
		String query = "SELECT `Email`, `DebitCard`, `CreditCard` FROM `user`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");	

            while(rs.next())
			{
                email = rs.getString("Email");
			    newBalance = rs.getDouble("DebitCard");
				
				newBalance=newBalance-rPrice;
			}
            Successful ps=new Successful();
            ps.setVisible(true);
            this.setVisible(false);			
			
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			query = "UPDATE user SET DebitCard="+newBalance+" where Email='"+email+"'";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void check()
	{
        String query = "SELECT `DebitCard` FROM `user`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
				
			while(rs.next())
			{
                double prevBalance = rs.getDouble("DebitCard");
				pr=prevBalance;
							
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    }
	public void check1()
	{
        String query = "SELECT `RoomPrice` FROM `price`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
				
			while(rs.next())
			{
                double prev = rs.getInt("RoomPrice");
				pr1=prev;
							
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    }
}