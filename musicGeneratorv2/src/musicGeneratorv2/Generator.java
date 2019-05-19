package musicGeneratorv2;

public class Generator {
	
	
	/*
	 * Parameters
	 * 0 - Amount of Chords (Any Integer)
	 * 1 - Atonal / Tonal (Binary)
	 * 2 - Major / Minor (Binary)
	 * 3 - Key Center (1-12)
	 * 4 - V7 Chord (Binary)
	 * 5 - Functional Harmony (Binary)
	 * 6 - Secondary Dominant (Binary)
	 * 7 - 
	 */
	
	public static int[] generate(int [] parameters){
		
		int[] generatedChords = new int[parameters[0]];
		int[] tonalChords = new int [6];
		
		//If 0 Generate Atonal Chords, If 1 Tonal Chords
		if(parameters[1] == 0) {
			return generateAtonal(parameters[0]);
		}	
		
		
		//If 0 Generate Major Chords, If 1 Minor Chords
		if(parameters[2] == 0) {
			generatedChords = generateMajorChords(parameters[0], parameters[3]);
			tonalChords = generateMajorChords(parameters[0], parameters[3]);

		}
		
		if(parameters[2] == 1) {
			generatedChords = generateMinorChords(parameters[0], parameters[3]);
			tonalChords = generateMinorChords(parameters[0], parameters[3]);
		}
		//If 1 Generate V7 Chord
		if(parameters[4] == 1) {
			generatedChords[4] = transformV7Chord(generatedChords[4]);
			tonalChords[4] = generatedChords[4];
		}
		
		generatedChords = chordRandomizer(parameters, generatedChords);
		
		if(parameters[5] == 1) {
			generatedChords = functionalHarmony(parameters, generatedChords, tonalChords);
		}
		
		if(parameters[5] == 1 && parameters[6] == 1) {
			generatedChords[parameters[0]-3] = secondaryDominantChord(parameters, tonalChords);
		}
		
		return generatedChords;
	
	}
	
	public static int secondaryDominantChord(int[] parameters, int[] referenceChords) {
		
		int secondaryDominant = referenceChords[4];
		
		secondaryDominant = secondaryDominant + 7;
		if(secondaryDominant > 36) {
			secondaryDominant = secondaryDominant - 12;
		}
		if(secondaryDominant < 25) {
			secondaryDominant = secondaryDominant + 24;
		}
		
		if(secondaryDominant > 36) {
			secondaryDominant = secondaryDominant - 12;
		}
		
		return secondaryDominant;
	}
	
	public static int[] functionalHarmony(int[] parameters, int[] inputChords, int[] referenceChords) {	
		
		inputChords[parameters[0]-1] = referenceChords[0];
		inputChords[parameters[0]-2] = referenceChords[4];
				
		return inputChords;
	}
	
	public static int transformV7Chord (int VChord) {
		
		int transformedVChord = VChord + 24;
		
		return transformedVChord;
	}
	
	public static int [] generateMinorChords(int amtChords, int key) {
		
		int [] minorChords = new int [7];
		
		minorChords[0] = key;
		minorChords[1] = key+2;
		minorChords[2] = key+3;
		minorChords[3] = key+5;
		minorChords[4] = key+7;
		minorChords[5] = key+8;
		minorChords[6] = key+10;
		
		//Fix 24 Overflow
		for(int i = 0; i<minorChords.length; i++) {
			if(minorChords[i]>24) {
				minorChords[i] = minorChords[i] - 12;
			}
		}
		
		//Fix Minor ii, iv, v Chords
		if(minorChords[1]>24) {
			minorChords[1] = minorChords[1] - 12;
		}
		if(minorChords[3]>24) {
			minorChords[3] = minorChords[3] - 12;
		}
		if(minorChords[4]>24) {
			minorChords[4] = minorChords[4] - 12;
		}
		
		//Fix Major III, VI, VIII Chords
		
		if(minorChords[2]>12) {
			minorChords[2] = minorChords[2] - 12;
		}
		if(minorChords[5]>12) {
			minorChords[5] = minorChords[5] - 12;
		}
		if(minorChords[6]>12) {
			minorChords[6] = minorChords[6] - 12;
		}
		
		return minorChords;
	}
	
	public static int [] generateMajorChords(int amtChords, int key) {
		
		int[] majorChords = new int [7];
		
		majorChords[0] = key;
		majorChords[1] = key+14;
		majorChords[2] = key+16;
		majorChords[3] = key+5;
		majorChords[4] = key+7;
		majorChords[5] = key+21;
		majorChords[6] = key+23;
		
		for(int i = 0; i<majorChords.length; i++) {
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
		majorChords[6] = majorChords[6] + 24;
		
		return majorChords;
		
	}
	
	public static int [] generateAtonal(int amtChords) {
		
		int[] atonalChords = new int[amtChords];
		
		for(int i = 0; i < amtChords; i++) {
			
			atonalChords[i] = (int)(Math.random()* 36 + 1);
			
		}
		
		return atonalChords;
	}
	
	public static int [] chordRandomizer(int [] parameters, int [] inputChords) {
		 
		int [] outputChords = new int [parameters[0]];
		
		 for(int i = 0; i<parameters[0]; i++) {
			 outputChords[i] = inputChords[(int)(Math.random() * 7 + 0)];
		 }
		
		 return outputChords;

	}
	
}


