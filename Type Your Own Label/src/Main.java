
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main {

	Main(){
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				TextController tControl = new TextController();
				
				JFrame frame = new JFrame("Type your own label (Backspace to delete & Enter to exit");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(300, 200);
				
				
				frame.setLayout(new GridBagLayout());
				GridBagConstraints gc = new GridBagConstraints();
				
				
				JLabel textLabel = new JLabel(tControl.getText());
				JButton changeButton = new JButton("Click to change button text");
				
				
				
				changeButton.setMaximumSize(new Dimension(100, 30));
				changeButton.setFocusable(false);
				changeButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						changeButton.setText(tControl.getText());
						
					}
					
				});
				
				
				gc.gridx = 0;
				
				gc.gridy = 0;
				frame.getContentPane().add(textLabel, gc);
				
				gc.gridy = 1;
				frame.getContentPane().add(changeButton, gc);
				
				frame.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
						char c = e.getKeyChar();
						
						//For debugging
						int i = c;
						System.out.println(i);
						
						if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == ' ') {
							
							tControl.addText(c);
							
						} else if (c == 8) {
							
							tControl.emptyText();
							
						} else if (c == 27) {
							
							frame.dispose();
							
						} else if (c == 10){
							
							changeButton.setText(tControl.getText());
							
						}
						
						textLabel.setText(tControl.getText());
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				frame.setVisible(true);
				
				
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		
		new Main();
		
	}
	
}
