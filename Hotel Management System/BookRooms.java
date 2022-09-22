import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookRooms extends JFrame implements ActionListener
{
	private JLabel myLabel,myLabel2;
	private JComboBox c;
	private JPanel panel;
	private String s[]=new String[20];//={"Room no. 001","Room no. 002","Room no. 003","Room no. 004","Room no. 005",null};
	private JButton b,button1,button2;
	private int roomPrice;
	
	public BookRooms()
	{
		super("BookRooms");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    
		panel=new JPanel();
		panel.setLayout(null);
		
		check();
		check1();
		
		myLabel2=new JLabel("Price per Room: "+roomPrice);
		myLabel2.setBounds(200,50,200,40);
		panel.add(myLabel2);
		
		
		myLabel=new JLabel("Select Rooms");
		myLabel.setBounds(200,100,200,40);
		panel.add(myLabel);
		
		c=new JComboBox(s);
		c.setBounds(200,150,300,50);
		panel.add(c);
		
		b=new JButton("Enter");
		b.setBounds(200,350,100,50);
		panel.add(b);
		b.addActionListener(this);
	
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
	public BookRooms(int a){
		this();
	}
	public BookRooms(int a,int b){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			Home h=new Home(1,2,3);
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Log Out")){
			Login l=new Login(1,2,3,4,5,6,7);
			l.setVisible(true);
			this.setVisible(false);
		} 
		else if(s.equals("Enter")){
			//Payment p=new Payment(1);
			//p.setVisible(true);
			//this.setVisible(false);
			//System.out.println(c.getSelectedItem());
			//System.out.println(c.getActionCommand());
			//System.out.println(c.getSelectedIndex());
			//String s1=c.getSelectedItem().getText();
			int s1=c.getSelectedIndex();
			updateInDB(s1);
		}
	}
	public void check()
	{
        String query = "SELECT `RoomNo`, `AvailableRooms` FROM `rooms`;";     
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
			int i=0;		
			while(rs.next())
			{
                String availableRooms = rs.getString("AvailableRooms");
				
				s[i]=availableRooms;
				i++;			
			}
			s[i]=null;
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
        String query = "SELECT `No`, `RoomPrice` FROM `price`;";     
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
                roomPrice = rs.getInt("RoomPrice");
				
							
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
	public void updateInDB(int s1)
	{
		double prevBalance=0, newBalance=0;
		String query = "SELECT `RoomNo`, `AvailableRooms` FROM `rooms`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		int i1=0;
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
                String availableRooms = rs.getString("AvailableRooms");
				
				if((availableRooms!="Not Available")&&(i1==s1))
				{
					Payment p=new Payment(roomPrice);
					p.setVisible(true);
					this.setVisible(false);
				}
				
				i1++;
			}		
			
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			query = "UPDATE rooms SET AvailableRooms='Not Available' where RoomNo="+s1;
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	
}