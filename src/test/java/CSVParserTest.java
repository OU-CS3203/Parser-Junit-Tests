import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testP1.CSVParser;

public class CSVParserTest {

	@Before
	public void setUp() throws Exception {
		CSVParser parser;
	}

	@Test
	public void testCognate() {
		CSVParser parser = new CSVParser("global,total");
		ArrayList<String> temp = parser.translateCSV();
		String[] answer = {"global,en,es", "total,en,es"};
		assertTrue(temp.get(0).equals(answer[0]) && temp.get(1).equals(answer[1]));
	}
	
	@Test
	public void testNumber() {
		
		final int upperbound = 100000;
		Random rand = new Random();
		int[] randInt = {rand.nextInt(upperbound), rand.nextInt(upperbound)};
		String parseString = "" + randInt[0] + "," + randInt[1];
		CSVParser parser = new CSVParser(parseString);
		
		String[] answer = {"" + randInt[0] + ",Unknown", "" + randInt[1] + ",Unknown"};
		ArrayList<String> temp = parser.translateCSV();
		
		assertTrue(temp.get(0).equals(answer[0]) && temp.get(1).equals(answer[1]));
		
	}
	
	@Test
	public void testTranslate() {
		
		CSVParser parser = new CSVParser("University,Dónde");
		ArrayList<String> temp = parser.translateCSV();
		String[] answer = {"University,en", "Dónde,es"};
		
		assertTrue(temp.get(0).equals(answer[0]) && temp.get(1).equals(answer[1]));
		
	}

	@Test
	public void testOrder() throws FileNotFoundException {
		File file = new File("src\\testP1\\testcsv\\testOrder.csv");
		CSVParser parser = new CSVParser(file);
		String[] answer = {"Talent","Purpose","Guatemala","Tower","Television","1024","Hatsune Miku","Keyboard","Por qué"};
		int bool = 1;
		
		for(int i = 0; parser.hasNext(); ++i) {
			if(!parser.next().equals(answer[i])) {
				bool = 0;
			}
		}
		
		assertTrue(bool == 0);
		
	}
	
}
