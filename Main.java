import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	static int rScore = 0;
	static int gScore = 0;
	static int periodCount = 1;
	static JButton red = new JButton("0");
	static JButton green = new JButton("0");
	static JButton period = new JButton("1");
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Scoreboard");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setVisible(true);
		int x = frame.getWidth()/12;
		int y = frame.getHeight()/12;
		
		JButton reset = new JButton("RESET");
		reset.setBounds(0, 0, x*2, y);
		frame.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rScore = 0;
				red.setText("0");
				gScore = 0;
				green.setText("0");
				periodCount = 1;
				period.setText("1");
			}
		});
		
		JTextField weight = new JTextField("125");
		weight.setHorizontalAlignment(JTextField.CENTER);
		weight.setFont(new Font("Arial", Font.BOLD, x));
		weight.setBounds(x*5, 0, x*2, y*2);
		frame.add(weight);
		
		red.setBounds(0, y*3, x*6, y*4);
		red.setBackground(Color.RED);
		red.setFont(new Font("Arial", Font.BOLD, x));
		frame.add(red);
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.paramString().contains("modifiers=Button1")) {
					rScore++;
				} else {
					rScore--;
				}
				red.setText(Integer.toString(rScore));
			}
		});
		
		green.setBounds(x*6, y*3, x*6, y*4);
		green.setBackground(Color.GREEN);
		green.setFont(new Font("Arial", Font.BOLD, x));
		frame.add(green);
		green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.paramString().contains("modifiers=Button1")) {
					gScore++;
				} else {
					gScore--;
				}
				green.setText(Integer.toString(gScore));
			}
		});
		
		period.setBounds(x*5, y*8, x*2, y*2);
		period.setFont(new Font("Arial", Font.BOLD, x));
		frame.add(period);
		period.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.paramString().contains("modifiers=Button1")) {
					periodCount++;
				} else {
					periodCount--;
				}
				period.setText(Integer.toString(periodCount));
			}
		});
		
		frame.repaint();
	}
}
