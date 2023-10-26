import java.util.Scanner;
/**
 *	Provides utilities for word games:
 *	1. finds all words in the dictionary that match a list of letters
 *	2. prints an array of words to the screen in tabular format
 *	3. finds the word from an array of words with the highest score
 *	4. calculates the score of a word according to a table
 *
 *	Uses the FileUtils and Prompt classes.
 *	
 *	@author Nishka Yadav
 *	@since	Oct 19, 2023
 */
 
public class WordUtils
{
	private String[] words;		// the dictionary of words
	
	// File containing dictionary of almost 100,000 words.
	private final String WORD_FILE = "wordList.txt";
	
	/* Constructor */
	public WordUtils() {
		loadWord();
	}
	
	/**	Load all of the dictionary from a file into words array. */
	private void loadWords () {
		Scanner newFile = FileUtils.openToRead(WORD_FILE);
		while (newFile.hasNext())
			words[i] = newFile.nextLine();
		
	}
	
	/** ADDED ON
	 *  Decides if a word matches a group of letters.
	 *
	 *  @param word  The word to test.
	 *  @param letters  A string of letters to compare
	 *  @return  true if the word matches the letters, false otherwise
	 */
	public boolean isWordMatch (String word, String letters) {
		for (int i = 0; i < word; i++){
			for (int j = 0; j < letters; j++){
				if (!word.charAt(i).equals(letters.charAt(j)))
					return false;
			}
		}
		return true;
		/**for (int a = 0; a < word.length(); a++){
			char c = word.charAt(a);
			if (letters.indexOf(c) > -1){
				letters = letters.substring(0, letters.indexOf(c)) + 
							letters.substring(letters.indexOf(c)+1);
			}
			else
				return false;
		}
		
		return true;*/
	}
	/** ADDED ON
	 *  Find all the words that match a string of letters.
	 *	Open wordList.txt and read each word
	 *		for each word, test with letters
	 *		if they match, add word to words array
	 *	@param letters		the letters to match
	 */
	public void findWords(String letters) {
		Scanner fileNew = FileUtils.openToRead(INFILE_NAME);
		while (fileNew.hasNext()){
			String word = fileNew.next();
			if (isWordMatch(word,letters)){
				int numChars = word.length();
				words[numChars][numWords[numChars]] = word;
				numWords[numChars]++;
			}
		}
	}
	
	/**	Find all words that can be formed by a list of letters.
	 *  @param letters	string containing list of letters
	 *  @return			array of strings with all words found.
	 */
	public String [] findAllWords (String letters)
	{	
			
		return new String[10];
	}
	
	/**	Print the words found to the screen.
	 *  @param words	array containing the words to be printed
	 */
	public void printWords (String [] wordList) {
		for (int i = 0; i < wordList.length(); i++){
			for (int d = 0; d < 5; d++){
				System.out.printf("%20s after\n", wordList[i]);
			}
			System.out.println();
		}
	}
	
	/**	Finds the highest scoring word according to a score table.
	 *
	 *  @param word  		An array of words to check
	 *  @param scoreTable	An array of 26 integer scores in letter order
	 *  @return   			The word with the highest score
	 */
	public String bestWord (String [] wordList, int [] scoreTable)
	{
		for (int g = 0; g < wordList.length; g++){
			for (int f = 0; f < wordList[g].length; f++){
				scoreTable[(int)(wordList[g].charAt(f))-97]++;
			}
		}
		return "";
	}
	
	/**	Calculates the score of one word according to a score table.
	 *
	 *  @param word			The word to score
	 *  @param scoreTable	An array of 26 integer scores in letter order
	 *  @return				The integer score of the word
	 */
	public int getScore (String word, int [] scoreTable)
	{
		int score = 0;
		for (int f = 0; f < word.length(); f++)
			score += scoreTable[(int)word.charAt(f)-(int)'a'];
		return score;
	}
	
	/***************************************************************/
	/************************** Testing ****************************/
	/***************************************************************/
	public static void main (String [] args)
	{
		WordUtils wu = new WordUtils();
		wu.run();
	}
	
	public void run() {
		String letters = Prompt.getString("Please enter a list of letters, from 3 to 12 letters long, without spaces");
		String [] word = findAllWords(letters);
		System.out.println();
		printWords(word);
		
		// Score table in alphabetic order according to Scrabble
		int [] scoreTable = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
		String best = bestWord(word,scoreTable);
		System.out.println("\nHighest scoring word: " + best + "\nScore = " 
							+ getScore(best, scoreTable) + "\n");
	}
}
