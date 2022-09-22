import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Instruction extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label1,label2,label3,label4;
	private JButton button1,button2;
	
	public Instruction(){
		super("Instruction");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
	  //label2=new JLabel("Your booking is completed Successfully. A pin code is sent in your mobile. You need to bring your pin code to get your room.");
	  //label2.setBounds(43,300,700,40);
		label1=new JLabel("If you want to book any room, you need to select a room no. After selecting Book no. you need to pay for it. There are two");
		label1.setBounds(43,250,700,40);
		panel.add(label1);
		
		label2=new JLabel("options(Credit Card and Debit Card) available in our system to pay. You can also pay by cash. After clearing payment a pin");
		label2.setBounds(43,290,700,40);
		panel.add(label2);
		
		label3=new JLabel("no. will be sent to your mobile no. by whom we can verify your room no. for more information you can contact with us. ");
		label3.setBounds(43,330,700,40);
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
	public Instruction(int a){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			Home h=new Home(1,2);
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Log Out")){
			Login l=new Login(1,2,3,4,5,6);
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}