import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contacts extends JFrame implements ActionListener
{
	private JLabel k1,k2;
	private JComboBox j1,j2;
	private JPanel panel;
	private String s[]={"XXXXXXXXXX","YYYYYYYYYYY"};
	private String p[]={"XXXX@gmail.com","YYYY@yahoo.com"};
	private JButton button1,button2;
	
	
	public Contacts()
	{
		super("Contacts");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		k1 = new JLabel("Contact no:");
		k1.setBounds(100,100,100,50);
		panel.add(k1);
		
		j1 = new JComboBox(s);
		j1.setBounds(200,150,100,50);
		panel.add(j1);
		
		k2 = new JLabel("Email:");
		k2.setBounds(100,300,100,50);
		panel.add(k2);
		
		j2 = new JComboBox(p);
		j2.setBounds(200,350,100,50);
		panel.add(j2);
		
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
	public Contacts(int a){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			Home h=new Home(1,2,3,4);
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Log Out")){
			Login l=new Login(1,2,3,4,5,6,7,8);
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}