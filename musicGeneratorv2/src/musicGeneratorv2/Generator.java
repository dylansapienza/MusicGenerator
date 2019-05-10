package musicGeneratorv2;

public class Generator {
	
	
	/*
	 * Parameters
	 * 0 - Amount of Chords (Any Integer)
	 * 1 - Atonal / Tonal (Binary)
	 * 2 - Major / Minor (Binary)
	 * 3 - V7 Chord (Binary)
	 * 4 - Functional Harmony (Binary)
	 * 5 - Secondary Dominant (Binary)
	 * 6 - Key Center (1-12)
	 */
	
	
	public static int[] generate(int [] parameters){
		
		int[] generatedChords = new int[parameters[0]];
		
		if(parameters[1] == 0) {
			
			return generateAtonal(parameters[0]);
		
		}
		
		
		return generatedChords;
	
	}
	
	public static int [] generateAtonal(int amtChords) {
		
		int[] atonalChords = new int[amtChords];
		
		for(int i = 0; i < amtChords; i++) {
			
			atonalChords[i] = (int)(Math.random()* 36 + 1);
			
		}
		
		
		return atonalChords;
	}

}
