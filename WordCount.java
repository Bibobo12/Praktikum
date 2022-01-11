import java.io.*;
import java.util.StringTokenizer;

public class WordCount { //
    public int countLines(String filename) {
        int linecount = 0;
        try {
            File inFile = new File(filename);
            BufferedReader inReader = new BufferedReader( new FileReader(inFile));
            String line = inReader.readLine();
            while ( line != null ) {
                linecount ++;
                line = inReader.readLine();
            }
        } catch (Exception e) {
            System.err.println("Exception: "+ e.getMessage());
            return -1;
        }
        return linecount;
    }
    public int countWords(String filename) {
        int wordcount = 0;
        try {
            File inFile = new File(filename);
            BufferedReader inReader = new BufferedReader( new FileReader(inFile));
            String line = inReader.readLine();
            while ( line != null ) {
                wordcount += new StringTokenizer( line ).countTokens();
                line = inReader.readLine();
            }
        } catch (Exception e) {
            System.err.println("Exception: "+ e.getMessage());
            return -1;
        }
        return wordcount;
    }
}

