package musicGeneratorv2;

public class Generator {
	
	
	/*
	 * Parameters
	 * 0 - Amount of Chords (Any Integer)
	 * 1 - Atonal / Tonal (Binary)
	 * 2 - Major / Minor (Binary)
	 * 4 - Key Center (1-12)
	 * 5 - V7 Chord (Binary)
	 * 6 - Functional Harmony (Binary)
	 * 7 - Secondary Dominant (Binary)
	 * 8 - 
	 */
	
	
	public static int[] generate(int [] parameters){
		
		int[] generatedChords = new int[parameters[0]];
		
		if(parameters[1] == 0) {
			
			generatedChords = generateAtonal(parameters[0]);
		
		}
		
		if(parameters[2] == 1) {
			generateMajorChords(parameters[0], parameters[3]);
		}
		
		return generatedChords;
	
	}
	
	//public static int [] chordSelection(int [] chords) {
		
		//for(int )	
		
		//return selectedChords; 
	//}
	
	
	public static int [] generateMajorChords(int amtChords, int key) {
		
		int[] majorChords = new int [6];
		
		majorChords[0] = key;
		majorChords[1] = key+14;
		majorChords[2] = key+16;
		majorChords[3] = key+5;
		majorChords[4] = key+7;
		majorChords[5] = key+21;
		majorChords[6] = key+23;
		
		for(int i = 0; i<amtChords; i++) {
			if(majorChords[i]>24) {
				majorChords[i] = majorChords[i] - 12;
			}
		}
		
		//Fix Major IV, V Chords
		if(majorChords[3]>12) {
			majorChords[3] = majorChords[3] - 12;
		}
		if(majorChords[4]>12) {
			majorChords[4] = majorChords[4] - 12;
		}
		
		return majorChords;
		
	}
	
	public static int [] generateAtonal(int amtChords) {
		
		int[] atonalChords = new int[amtChords];
		
		for(int i = 0; i < amtChords; i++) {
			
			atonalChords[i] = (int)(Math.random()* 36 + 1);
			
		}
		
		return atonalChords;
	}

}
