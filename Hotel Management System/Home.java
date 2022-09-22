import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Home extends JFrame implements ActionListener{
	private JPanel panel;
	private JButton button1,button2,button3,button4,button5,button6;
	private JLabel label;
	private double pr;
	
	public Home(){
		super("Home");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		check();
		
		label=new JLabel("Current Balance: "+pr);
		label.setBounds(250,100,250,40);
		panel.add(label);
		
		button1=new JButton("Book Rooms");
		button1.setBounds(250,200,200,40);
		panel.add(button1);
		button1.addActionListener(this);
		
		button2=new JButton("Contacts");
		button2.setBounds(250,350,200,40);
		panel.add(button2);
		button2.addActionListener(this);
		
		
		button4=new JButton("Instructions");
		button4.setBounds(250,570,200,40);
		panel.add(button4);
		button4.addActionListener(this);
		
		button5=new JButton("Back");
		button5.setBounds(10,10,100,40);
		panel.add(button5);
		button5.addActionListener(this);
		
		button6=new JButton("Log Out");
		button6.setBounds(680,10,100,40);
		panel.add(button6);
		button6.addActionListener(this);
		
		this.add(panel);
	}
	public Home(int a){
		this();
	}
	public Home(int a,int b){
		this();
	}
	public Home(int a,int b,int c){
		this();
	}
	public Home(int a,int b,int c,int d){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Instructions")){
			Instruction i=new Instruction(1);
			i.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Back")){
			Login l1=new Login(1,2,3,4);
			l1.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Log Out")){
			Login l=new Login(1,2,3,4,5);
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Book Rooms")){
			BookRooms b=new BookRooms(1);
			b.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Contacts")){
			Contacts c=new Contacts(1);
			c.setVisible(true);
			this.setVisible(false);
		}
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
                double prevBalance = rs.getInt("DebitCard");
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
	
}