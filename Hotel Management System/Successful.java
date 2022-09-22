import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Successful extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label1,label2,label3;
	private JButton button1,button2;
	
	public Successful(){
		super("Successful");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		label1=new JLabel("Congratulations");
		label1.setBounds(300,230,300,40);
		panel.add(label1);
		
		label2=new JLabel("Your booking is completed Successfully. A pin code is sent in your mobile. You need to bring your pin code to get your room.");
		label2.setBounds(43,300,700,40);
		panel.add(label2);
		
		label3=new JLabel("Thank you");
		label3.setBounds(360,340,100,40);
		panel.add(label3);
		
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
	public Successful(int a){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			Home h=new Home();
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Log Out")){
			Login l=new Login(1,2,3,4,5,6,7,8,9,10);
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}