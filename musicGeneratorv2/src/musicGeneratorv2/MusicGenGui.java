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
import javax.swing.JTextPane;

public class MusicGenGui {

	private JFrame frame;
	public static int[] playChords = new int[16];
	private JTextField textFieldProgressionCode;
	

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
		lblAmountOfChords.setBounds(437, 144, 113, 26);
		frame.getContentPane().add(lblAmountOfChords);
		
		JCheckBox checkAtonal = new JCheckBox("Atonal");
		checkAtonal.setBounds(43, 80, 78, 23);
		frame.getContentPane().add(checkAtonal);
		
		JCheckBox checkTonal = new JCheckBox("Tonal");
		checkTonal.setBounds(123, 80, 97, 23);
		frame.getContentPane().add(checkTonal);
		
		JCheckBox checkMajor = new JCheckBox("Major");
		checkMajor.setBounds(43, 120, 78, 23);
		frame.getContentPane().add(checkMajor);
		
		JCheckBox checkMinor = new JCheckBox("Minor");
		checkMinor.setBounds(123, 120, 78, 23);
		frame.getContentPane().add(checkMinor);
		
		JCheckBox checkV7Chord = new JCheckBox("V7 Chord");
		checkV7Chord.setBounds(43, 160, 83, 23);
		frame.getContentPane().add(checkV7Chord);
		
		JCheckBox checkFunctional = new JCheckBox("Functional Harmony");
		checkFunctional.setBounds(123, 160, 185, 23);
		frame.getContentPane().add(checkFunctional);
		
		JCheckBox checkSecondaryDom = new JCheckBox("Secondary Dominant");
		checkSecondaryDom.setBounds(123, 200, 185, 23);
		frame.getContentPane().add(checkSecondaryDom);
		
		
		JLabel lblKeyCenter = new JLabel("Key Center:");
		lblKeyCenter.setBounds(437, 181, 97, 26);
		frame.getContentPane().add(lblKeyCenter);
		
		TextField textKeyCenter = new TextField();
		textKeyCenter.setText("0");
		textKeyCenter.setBounds(556, 183, 36, 33);
		frame.getContentPane().add(textKeyCenter);
		
		JTextPane textOutput = new JTextPane();
		textOutput.setBounds(437, 253, 230, 307);
		frame.getContentPane().add(textOutput);
		
		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setBounds(437, 226, 97, 26);
		frame.getContentPane().add(lblOutput);
		
		int[] parameters = new int [10];
		int[] savedChords = new int[16];
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				parameters[0] = Integer.parseInt(textAmtChords.getText());
				
				parameters[1] = CheckInput.checkTonality(checkAtonal, checkTonal);
				
				parameters[2] = CheckInput.checkMode(checkMajor, checkMinor);
				
				parameters[3] = Integer.parseInt(textKeyCenter.getText());
				
				//If Selected Key is 0 then pick a key
				if(parameters[3] == 0) {
					parameters[3] = (int)(Math.random() * 12 + 0);
				}
				else {
					//parameters[3] = check
				}
				
				parameters[4] = CheckInput.checkV7Chord(checkV7Chord);
				
				parameters[5] = CheckInput.checkFunctionalHarmony(checkFunctional);
				
				parameters[6] = CheckInput.checkSecondaryDom(checkSecondaryDom);
				
				playChords = Generator.generate(parameters);
				
				
			}
		});
		btnGenerate.setBounds(161, 300, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<parameters[0]; i++) {
					
					if(playChords[i] == 0) {
						return;
					}
					
					PlayAudio.play(playChords[i]);
					
				}
				
				textOutput.setText(TextHandler.chordNamer(playChords));
			}
		});
		
		btnPlay.setBounds(316, 300, 89, 23);
		frame.getContentPane().add(btnPlay);
		
		JButton btnSave = new JButton("SaveProg");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<parameters[0]; i++) {
					
					if(playChords[i] == 0) {
						return;
					}
					
					savedChords[i] = playChords[i];
				}
				
				
			}
		});
		btnSave.setBounds(43, 461, 121, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnLoadProg = new JButton("LoadProg");
		btnLoadProg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				for(int i = 0; i<playChords.length; i++) {
					playChords[i] = 0;
				}
				
				for(int i = 0; i<parameters[0]; i++) {
					playChords[i] = savedChords[i];
				}
				
			}
		});
		btnLoadProg.setBounds(43, 495, 114, 23);
		frame.getContentPane().add(btnLoadProg);
		
		JLabel lblProgressionSaved = new JLabel("Progression Saved");
		lblProgressionSaved.setBounds(43, 419, 113, 14);
		frame.getContentPane().add(lblProgressionSaved);
		
		textFieldProgressionCode = new JTextField();
		textFieldProgressionCode.setBounds(194, 419, 126, 20);
		frame.getContentPane().add(textFieldProgressionCode);
		textFieldProgressionCode.setColumns(10);
		
		JButton btnLoadProgCode = new JButton("LoadCode");
		btnLoadProgCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String progressionCode = textFieldProgressionCode.getText();
				
				
				
			}
		});
		btnLoadProgCode.setBounds(206, 461, 114, 23);
		frame.getContentPane().add(btnLoadProgCode);


		
	}
}
