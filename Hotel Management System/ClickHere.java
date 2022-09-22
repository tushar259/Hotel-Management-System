import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickHere extends JFrame implements ActionListener
{
	private JTextField t;
	private JLabel k;
	private JPanel panel;
	private JButton b,b1;
	
	public ClickHere()
	{
		super("ClickHere");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		k =new JLabel("Give your phone no. to get your new id and password");
		k.setBounds(100,200,400,50);
		panel.add(k);
		
		t=new JTextField();
		t.setBounds(100,300,200,50);
		panel.add(t);
		
		b=new JButton("Send");
		b.setBounds(100,400,100,50);
		panel.add(b);
		b.addActionListener(this);
		
		b1=new JButton("Back");
		b1.setBounds(10,10,100,40);
		panel.add(b1);
		b1.addActionListener(this);
		
		this.add(panel);
	}
	public ClickHere(int a){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("Back")){
			Login h=new Login(1,2);
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Send")){
			Login l=new Login(1,2,3);
			l.setVisible(true);
			this.setVisible(false);
		}
	}
}