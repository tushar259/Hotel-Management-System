import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Exp extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label1,label2;
	private JButton button;
	
	public Exp(){
		super("Experience");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		label1=new JLabel("Thank you for your time");
		label1.setBounds(300,250,300,40);
		panel.add(label1);
		
		label2=new JLabel("We appreciate your opinion");
		label2.setBounds(291,290,300,40);
		panel.add(label2);
		
		button=new JButton("Back");
		button.setBounds(10,10,100,40);
		panel.add(button);
		button.addActionListener(this);
		
		this.add(panel);
	}
	public Exp(int a){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			Login l=new Login(1);
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}