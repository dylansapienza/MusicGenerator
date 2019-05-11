package musicGeneratorv2;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class MusicGenGui {

	private JFrame frame;
	static int[] parameters = new int [6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicGenGui window = new MusicGenGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MusicGenGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1370, 940);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label titleText = new Label("Dylan's Music Generator");
		titleText.setBounds(10, 10, 435, 33);
		frame.getContentPane().add(titleText);
		
		int amtChords = 0;
		TextField textAmtChords = new TextField();
		textAmtChords.setText("4");
		textAmtChords.setBounds(556, 144, 36, 33);
		frame.getContentPane().add(textAmtChords);
		
		JLabel lblAmountOfChords = new JLabel("Amount of Chords:");
		lblAmountOfChords.setBounds(437, 144, 97, 26);
		frame.getContentPane().add(lblAmountOfChords);
		
		JCheckBox checkAtonal = new JCheckBox("Atonal");
		checkAtonal.setBounds(43, 85, 78, 23);
		frame.getContentPane().add(checkAtonal);
		
		JCheckBox checkTonal = new JCheckBox("Tonal");
		checkTonal.setBounds(123, 85, 97, 23);
		frame.getContentPane().add(checkTonal);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				parameters[0] = Integer.parseInt(textAmtChords.getText());
				
				if(checkAtonal.isSelected() == true && checkTonal.isSelected() == true) {
					JOptionPane.showMessageDialog(null, "Tonal and Atonal Cannot Both Be Selected", "Contradicting Selection", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(checkAtonal.isSelected() == true) {
					parameters[1] = 0;
				}
				if(checkTonal.isSelected() == true) {
					parameters[1] = 1;
				}
			
			}
		});
		btnGenerate.setBounds(161, 300, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<=parameters[0]; i++) {
					//Setup Play
				}
			}
		});
		btnPlay.setBounds(316, 300, 89, 23);
		frame.getContentPane().add(btnPlay);
		

	}

}
