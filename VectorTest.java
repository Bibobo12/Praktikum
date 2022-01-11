import static org.junit.Assert.*;
import org.junit.*;

public class VectorTest {
    private Vector vector;
    @Before public void setUp(){
        vector = new Vector();
    }


    @Test
    public void testFirstElement(){
        for(int i = 0; i <10; i++)
            vector.insertElementAt(i, i);

        assertEquals(0, vector.firstElement());
    }
    @Test
    public void testRemoveElement(){
        for(int i = 0; i <10; i++)
            vector.insertElementAt(i, i);
        vector.removeElementAt(1);
        assertEquals(2, vector.get(1));
    }
    @Test
    public void testGet(){ //works fine
        for(int i = 0; i <10; i++)
            vector.insertElementAt(i, i);


        assertEquals(9, vector.get(9));
    }
    @Test
    public void testRemoveRange(){ //works fine
        for(int i = 0; i <10; i++)
            vector.insertElementAt(i, i);

        vector.removeRange(0,3);
        assertEquals(3, vector.get(0));
    }
    @Test
    public void testEnsureCapacity(){
        for(int i = 0; i <10; i++)
            vector.insertElementAt(i, i);

        vector.ensureCapacity(20);
        assertEquals(20, vector.size());
    }
}
