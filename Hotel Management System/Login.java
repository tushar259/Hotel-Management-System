import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label1,label2,label3,label4,label5;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton button1,button2,button3,button4;
	private JRadioButton radioButton1,radioButton2;
	private ButtonGroup buttonGroup;
	private boolean flag;
	
	public Login(){
		super("Hotel Management");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.DISOISE_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		label1=new JLabel("THE SKYBLUE HOTEL");
		label1.setBounds(220,50,600,30);
		label1.setFont(new Font("Times New Roman",0,30));
		panel.add(label1);
		
		label2=new JLabel("Sign in with your email");
		label2.setBounds(100,180,600,30);
		panel.add(label2);
		
		textField=new JTextField();
		textField.setBounds(100,220,600,40);
		panel.add(textField);
		
		label3=new JLabel("Password");
		label3.setBounds(100,270,600,30);
		panel.add(label3);
		
		passwordField=new JPasswordField();
        passwordField.setBounds(100,310,600,40);
        panel.add(passwordField);

        button1=new JButton("Log In");
        button1.setBounds(100,360,600,40);
        panel.add(button1);
		button1.addActionListener(this);

        label4=new JLabel("If you can't access");
        label4.setBounds(200,430,160,30);
        panel.add(label4);

        button2=new JButton("Click Here");
        button2.setBounds(365,430,100,30);
        panel.add(button2);
		button2.addActionListener(this);
		
		button4=new JButton("Back");
		button4.setBounds(10,10,100,40);
		panel.add(button4);
		button4.addActionListener(this);

        label5=new JLabel("Your experience about our system ?");
        label5.setBounds(100,480,500,30);
        panel.add(label5);

        radioButton1=new JRadioButton("Good");
        radioButton1.setBounds(120,520,100,30);
        panel.add(radioButton1);

        radioButton2=new JRadioButton("Bad");
        radioButton2.setBounds(120,555,100,30);
        panel.add(radioButton2);

        buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        button3=new JButton("Submit");
        button3.setBounds(120,595,100,40);
        panel.add(button3);
		button3.addActionListener(this);

        this.add(panel);		
		
	}
	public Login(int a){
		this();
	}
	public Login(int a,int b){
		this();
	}
	public Login(int a,int b,int c){
		this();
	}
	public Login(int a,int b,int c,int d){
		this();
	}
	
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Log In")){
		   // Home h=new Home(1);
		   // h.setVisible(true);
		   // this.setVisible(false);
		    flag=true;
		    check();
		   
	    }
		else if(s.equals("Submit")){
			
			if(radioButton1.isSelected()==true){
				updateInDB1();
			}
			else if(radioButton2.isSelected()==true){
				updateInDB2();
			}
			Exp e=new Exp(1);
			e.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Click Here")){
			ClickHere ch=new ClickHere(1);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Back")){
			Select s1=new Select();
			s1.setVisible(true);
			this.setVisible(false);
		}
	}
	public void check(){
        String query = "SELECT `Email`, `Password`, `Mobile`, `DebitCard`, `CreditCard` FROM `user`;";     
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
					
			while(rs.next()){
                String email = rs.getString("Email");
                String password = rs.getString("Password");
				int mobile = rs.getInt("Mobile");
				double debitCard = rs.getDouble("DebitCard");
				double creditCard = rs.getDouble("CreditCard");
				
				if(email.equals(textField.getText())){
					flag=false;
					
					if(password.equals(passwordField.getText())){
						
						Home h=new Home(1);
		                h.setVisible(true);
		                this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid Password"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid Email"); }
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
	
	public void updateInDB1()
	{
		int good=0;
		String query = "SELECT `SL_No`, `Good`, `Bad` FROM `experience`;";     
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
			
			while(rs.next()){
                int slno = rs.getInt("SL_No");
                int newGood = rs.getInt("Good");
		        int newBad = rs.getInt("Bad");
			    good=newGood;
			    good++;
            }			
			
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			query = "UPDATE experience SET Good="+good+" where SL_No=1";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public void updateInDB2()
	{
		int bad=0;
		String query = "SELECT `SL_No`, `Good`, `Bad` FROM `experience`;";     
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
				
			while(rs.next()){
                int slno = rs.getInt("SL_No");
                int newGood = rs.getInt("Good");
		        int newBad = rs.getInt("Bad");
			    bad=newBad;
			    bad++;
            }
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			query = "UPDATE experience SET Bad="+bad+" where SL_No=1";
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public static void main(String args[]){
		Login l=new Login();
		l.setVisible(true);
	}
}