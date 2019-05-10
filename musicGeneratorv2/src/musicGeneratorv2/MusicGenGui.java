package musicGeneratorv2;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class MusicGenGui {

	private JFrame frame;
	private TextField textAmtChords;
	static int[] parameters = new int [6];
	private JCheckBox chckbxAtonal;

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
		textAmtChords = new TextField();
		textAmtChords.setText(Integer.toString(amtChords));
		textAmtChords.setBounds(635, 141, 36, 33);
		frame.getContentPane().add(textAmtChords);
		
		JLabel lblAmountOfChords = new JLabel("Amount of Chords:");
		lblAmountOfChords.setBounds(437, 144, 210, 26);
		frame.getContentPane().add(lblAmountOfChords);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0; i <= 12; i ++) {
					if(chckbxAtonal.isSelected() == true) {
						
						String amt = textAmtChords.getText();
						parameters[0] = Integer.parseInt(amt);
						parameters[1] = 0;
					}
					//Break This Up
					int [] playChords = new int[parameters[0]];
					playChords = Generator.generate(parameters);
					PlayAudio.play(playChords[i]);
				
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
		
		chckbxAtonal = new JCheckBox("Atonal");
		chckbxAtonal.setSelected(true);
		chckbxAtonal.setBounds(43, 85, 97, 23);
		frame.getContentPane().add(chckbxAtonal);
	}
	public JCheckBox getChckbxAtonal() {
		return chckbxAtonal;
	}
}
