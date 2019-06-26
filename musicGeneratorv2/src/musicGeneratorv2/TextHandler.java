package musicGeneratorv2;

public class TextHandler {
	
	//Infinite Loop is in here
	
	public static String chordNamer(int[] inputChords){
		
		String chordList = "Chords:\n\n";
		int rootNote = 0;
		
		for(int i = 0; i<inputChords.length; i++) {
			
			rootNote = inputChords[i];
			
			while(rootNote>12) {
				
				rootNote -= 12;
			}
			
			//Assigning the Root Note
			
			switch(rootNote) {
				case 1:
					chordList += "A";
					break;
				case 2:
					chordList+= "A#";
					break;
				case 3:
					chordList += "B";
					break;
				case 4:
					chordList+= "C";
					break;
				case 5:
					chordList+= "C#";
					break;
				case 6:
					chordList+= "D";
					break;
				case 7:
					chordList+= "D#";
					break;
				case 8:
					chordList+= "E";
					break;
				case 9:
					chordList+= "F";
					break;
				case 10:
					chordList+= "F#";
					break;
				case 11:
					chordList+= "G";
					break;
				case 12:
					chordList+= "G#";
					break;
			
			//Assigning Chord Quality
			}
				if(inputChords[i]<=12) {
					chordList+="Maj";
				}
				else if(inputChords[i]<=24) {
					chordList+="min";
				}
				else if(inputChords[i]<=36) {
					chordList+="7";
				}
				else if(inputChords[i]<=48) {
					chordList+="dim7";
				}
				
				chordList+="\n";
			
		}
			
			
			
		return chordList;
		

	}
	
	
	public static int noteToNumber() {
		
		
		
		
		
		
		return 0;
		
		
		
		
	}
	
	
	
	
}
