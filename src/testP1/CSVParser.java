package testP1;

import java.util.Scanner;

import com.detectlanguage.DetectLanguage;

import java.io.File;
import java.io.FileNotFoundException;;

public class CSVParser {
	
	private Scanner in;
	
	private DetectLanguage dl;
	
	public CSVParser(File csvFile) throws FileNotFoundException {
		
		try {
			in = new Scanner(csvFile);
		}
		catch(Exception e) {
			System.out.print("File not found \n");
		}
		
	}
	
	
	public String[] nextLine() {
		String temp = in.nextLine();
		return temp.split(",");
	}
	
	
}
