package lesson150928;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Anonymous {
	
	static class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("you clicked me!");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Example");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(400, 400);
		
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		
		frame.add(panel);
		
		JButton button = new JButton("Click me!");
		
		panel.add(button);
		
		frame.pack();
		
		button.addActionListener(new MyActionListener());
		
//		panel.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				System.out.println(e);
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println(e);
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				System.out.println(e);
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				System.out.println(e);
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println(e);
//			}
//		});
//		
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
