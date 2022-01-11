import static org.junit.Assert.*;
import org.junit.*;

public class WordCountTest {
private WordCount wc;

@Before
    public void setup(){
        wc = new WordCount();
    }

@Test
    public void testNumberOfLines(){
    int correctAnswer = 4;
    String path ="C:\\Arhiva\\FAU\\1 Praktikum\\Blatt09\\test.txt";
    assertEquals(correctAnswer,wc.countLines(path),0);

}
    @Test
    public void testNumberOfLinesEmpty(){
        int correctAnswer = 0;
        String path ="C:\\Arhiva\\FAU\\1 Praktikum\\Blatt09\\test_empty.txt";
        assertEquals(correctAnswer,wc.countLines(path),0);

    }

    @Test
    public void testNumberOfWords(){
        int correctAnswer = 8;
        String path ="C:\\Arhiva\\FAU\\1 Praktikum\\Blatt09\\test.txt";
        assertEquals(correctAnswer,wc.countWords(path),0);

    }
    @Test
    public void testNumberOfWordsEmpty(){
        int correctAnswer = 0;
        String path ="C:\\Arhiva\\FAU\\1 Praktikum\\Blatt09\\test_empty.txt";
        assertEquals(correctAnswer,wc.countWords(path),0);
    }
    @Test
    public void testNumberOfWordsEmpty_exception(){
        int correctAnswer = 0;
        String path ="C:\\Arhiva\\FAU\\1 Praktikum\\Blatt09\\incorrect_path.txt";
        assertEquals(correctAnswer,wc.countWords(path),0);
    }
    @Test
    public void testNumberOfLinesEmpty_exception(){
        int correctAnswer = 0;
        String path ="C:\\Arhiva\\FAU\\1 Praktikum\\Blatt09\\incorrect_path.txt";
        assertEquals(correctAnswer,wc.countLines(path),0);
    }



}
