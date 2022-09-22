import javax.swing.*;
import java.awt.event.*;
public class Select extends JFrame implements ActionListener{
	private JPanel panel;
	private JButton button1,button2;
	
	public Select(){
		super("Select");
		this.setSize(800,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);
		
		button1=new JButton("User");
		button1.setBounds(350,250,100,40);
		panel.add(button1);
		button1.addActionListener(this);
		
		button2=new JButton("Administrator");
		button2.setBounds(340,350,120,40);
		panel.add(button2);
		button2.addActionListener(this);
		
		this.add(panel);
	}
	public Select(int a){
		this();
	}
	public void actionPerformed(ActionEvent a){
		String s=a.getActionCommand();
		if(s.equals("User")){
			Login l=new Login(1);
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals("Administrator")){
			AdminLogin al=new AdminLogin(1);
			al.setVisible(true);
			this.setVisible(false);
		}
	}
}