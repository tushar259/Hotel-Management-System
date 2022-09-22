import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AdminLogin extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label1,label2,label3,label4,label5;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton button1,button2,button3;
	private JRadioButton radioButton1,radioButton2;
	private ButtonGroup buttonGroup;
	private boolean flag;
	
	public AdminLogin(){
		super("Hotel Management");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
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
		
		button2=new JButton("Back");
		button2.setBounds(10,10,100,40);
		panel.add(button2);
		button2.addActionListener(this);

        button1=new JButton("Log In");
        button1.setBounds(100,360,600,40);
        panel.add(button1);
		button1.addActionListener(this);
    
        this.add(panel);		
		
	}
	public AdminLogin(int a){
		this();
	}
	public AdminLogin(int a,int b){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Log In")){
			//Rooms r=new Rooms(1);
			//r.setVisible(true);
			//this.setVisible(false);
			flag=true;
			check();
		    
		}
		else if(s.equals("Back")){
			Select s1=new Select(1);
			s1.setVisible(true);
			this.setVisible(false);
		}
	}
	public void check(){
        String query = "SELECT `Email`, `Password` FROM `admin`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try{
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
				
				if(email.equals(textField.getText())){
					flag=false;
					if(password.equals(passwordField.getText())){
						Rooms r=new Rooms(1);
			            r.setVisible(true);
			            this.setVisible(false); 
						
					}	
					else{
						JOptionPane.showMessageDialog(this,"Invalid Password"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid Email"); }
		}
        catch(Exception ex){
			System.out.println("Exception : " +ex.getMessage());
        }
        finally{
            try{
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