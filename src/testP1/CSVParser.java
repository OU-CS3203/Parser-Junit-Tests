package testP1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;
import static com.github.pemistahl.lingua.api.Language.ENGLISH;
import static com.github.pemistahl.lingua.api.Language.SPANISH;
import java.io.File;
import java.io.FileNotFoundException;;

public class CSVParser {
	
	private Scanner in;
	final private LanguageDetector detector = LanguageDetectorBuilder.fromLanguages(ENGLISH, SPANISH).build();
	
	public CSVParser(File csvFile) throws FileNotFoundException {
		in = new Scanner(csvFile);
		in.useDelimiter(",");
		
	}
	
	public CSVParser(String input) {
		in = new Scanner(input);
		in.useDelimiter(",");
	}
	
	public String[] nextLine() {
		String temp = in.nextLine();
		return temp.split(",");
	}
	
	public String next() {
		String temp = in.next();
		return temp;
	}
	
	public boolean hasNext() {
		return in.hasNext();
	}
	
	public ArrayList<String> translateCSV(){
		
		ArrayList<String> translatedList = new ArrayList<String>();
		
		
		while(in.hasNext()) {
			
			String temp = "";
			temp = in.next();
			SortedMap<Language, Double> tempMap = detector.computeLanguageConfidenceValues(temp);
			
				
			if(!tempMap.isEmpty()) {
				if(tempMap.containsKey(ENGLISH) && tempMap.get(ENGLISH) > 0.9) {
					temp += ",en";
				}
				if(tempMap.containsKey(SPANISH) && tempMap.get(SPANISH) > 0.9) {
					temp += ",es";
				}	
			}
			else {
				temp += ",Unknown";
			}
			
			translatedList.add(temp);
			
		}
		
		return translatedList;
	}
	
	public void close() {
		in.close();
	}
	
}
