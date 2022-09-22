import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Rooms extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label,label2,label3,label4;
	private JTextField tfield1,tfield2,tfield3,tfield4;
	private JButton button1,button2,button3,button4,button5;
	private JComboBox combo1,combo2;
	private String a[]=new String[20];
	private String b[]={"001","002","003","004","005",null};
	private int j;
	
	public Rooms(){
		super("Home");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		label=new JLabel("Rooms you want to Add or Remove");
		label.setBounds(200,100,500,40);
		label.setFont(new Font("Times New Roman",0,30));
		panel.add(label);
		
		tfield1=new JTextField();
		tfield1.setBounds(240,200,250,40);
		panel.add(tfield1);
		
		button1=new JButton("Add");
		button1.setBounds(500,200,100,40);
		panel.add(button1);
		button1.addActionListener(this);
		
		tfield2=new JTextField();
		tfield2.setBounds(240,250,250,40);
		panel.add(tfield2);
		
		button2=new JButton("Remove");
		button2.setBounds(500,250,100,40);
		panel.add(button2);
		button2.addActionListener(this);
		
		button3=new JButton("Back");
		button3.setBounds(10,10,100,40);
		panel.add(button3);
		button3.addActionListener(this);
		
		button4=new JButton("Log Out");
		button4.setBounds(680,10,100,40);
		panel.add(button4);
		button4.addActionListener(this);
		
		check();
		
		label2=new JLabel("Room No.");
		label2.setBounds(200,350,200,40);
		panel.add(label2);
		
		combo1=new JComboBox(b);
		combo1.setBounds(200,400,100,40);
		panel.add(combo1);
		
		label3=new JLabel("Available Rooms");
		label3.setBounds(400,350,300,40);
		panel.add(label3);
		
		combo2=new JComboBox(a);
		combo2.setBounds(400,400,100,40);
		panel.add(combo2);
		
		label4=new JLabel("Room Price: ");
		label4.setBounds(170,500,100,40);
		panel.add(label4);
		
		tfield4=new JTextField();
		tfield4.setBounds(260,500,200,40);
		panel.add(tfield4);
		
		button5=new JButton("Update");
		button5.setBounds(470,500,100,40);
		panel.add(button5);
		button5.addActionListener(this);
		
		this.add(panel);
	}
	public Rooms(int a){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			AdminLogin al=new AdminLogin(1,2);
			al.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Log Out")){
			AdminLogin ab=new AdminLogin(1);
			ab.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Add")){
			String s1=tfield1.getText();
		    j=Integer.parseInt(tfield1.getText().toString());
			j=j-1;
			updateInDB(s1,j);
			JOptionPane.showMessageDialog(this,s1+" Room is Added");
		}
		else if(s.equals("Remove")){
			String s1=tfield2.getText();
			updateInDB1(s1);
			JOptionPane.showMessageDialog(this,s1+" Room is Removed");
		}
		else if(s.equals("Update")){
			updateInDB2();
			JOptionPane.showMessageDialog(this,"Price "+Integer.parseInt(tfield4.getText().toString())+" is Added");
		}
	}
	public void updateInDB(String s1,int j)
	{
		//int i=0;
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
			
			
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			query = "UPDATE rooms SET AvailableRooms='"+s1+"' where RoomNo="+j;
			//query = "UPDATE rooms SET AvailableRooms=replace(AvailableRooms, 'Not Available', '"+s1+"');";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB1(String s1)
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
			
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			//query = "UPDATE rooms SET AvailableRooms=`"+s1+"` where RoomNo="+roomNo1;
			query = "UPDATE rooms SET AvailableRooms=replace(AvailableRooms, '"+s1+"', 'Not Available');";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
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
				if(availableRooms!="Not Available"){
				    a[i]=availableRooms;
				    i++;
                }					
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
	
	public void updateInDB2()
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
			
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			//query = "UPDATE rooms SET AvailableRooms=`"+s1+"` where RoomNo="+roomNo1;
			//query = "UPDATE rooms SET AvailableRooms=replace(AvailableRooms, 'Not Available', '"+s1+"');";
			query= "UPDATE price SET RoomPrice="+Integer.parseInt(tfield4.getText().toString())+" where No=1";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
}