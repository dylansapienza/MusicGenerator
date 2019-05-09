package musicGeneratorv2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MusicGenGui {

	private JFrame frame;
	private JTextField textChordInput;

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
		frame.setBounds(100, 100, 629, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(423, 266, -164, -290);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnTestPlay = new JButton("New button");
		btnTestPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int playChord = 0;
				String amt = textChordInput.getText();
				playChord = Integer.parseInt(amt);
				
				PlayAudio.play(playChord);
			}
		});
		btnTestPlay.setBounds(149, 190, 89, 23);
		frame.getContentPane().add(btnTestPlay);
		
		textChordInput = new JTextField();
		textChordInput.setBounds(149, 141, 86, 20);
		frame.getContentPane().add(textChordInput);
		textChordInput.setColumns(10);
	}

}
