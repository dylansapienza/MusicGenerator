package musicGeneratorv2;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

//Implement Functional Check and Secondary Dominant Check

public class CheckInput {
	
	public static int checkTonality(JCheckBox checkAtonal, JCheckBox checkTonal){
		
		if(checkAtonal.isSelected() == true && checkTonal.isSelected() == true) {
			JOptionPane.showMessageDialog(null, "Please Selected Either One Tonality", "Contradicting Selection", JOptionPane.WARNING_MESSAGE);
			return 2;
		}
		
		if(checkAtonal.isSelected() == true) {
			return 0;
		}
		if(checkTonal.isSelected() == true) {
			return 1;
		}
		
		return 2;
	}
	
	public static int checkMode(JCheckBox checkMajor, JCheckBox checkMinor) {
		
		if(checkMajor.isSelected() == true && checkMinor.isSelected() == true) {
			JOptionPane.showMessageDialog(null, "Please Select Either Major or Minor", "Contradicting Selection", JOptionPane.WARNING_MESSAGE);
			return 2;
		}
		
		if(checkMajor.isSelected() == true) {
			return 0;
		}
		if(checkMinor.isSelected() == true) {
			return 1;
		}
		
		return 2;

	}
	
	public static int checkV7Chord(JCheckBox checkV7Chord) {
		
		if(checkV7Chord.isSelected() == true) {	
			return 1;
		}
		else {
			return 0;	
		}
	}

}
