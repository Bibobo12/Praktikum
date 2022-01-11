import static org.junit.Assert.*;
import org.junit.*;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.NoSuchElementException;

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

    // Coverage: 23% Blatt 10 --
    @Test(expected = IllegalArgumentException.class)
    public void setUp2(){
        vector = new Vector(-2,3);

    }
    @Test
    public void setUp3(){
        int[] x = {1,2};
        LinkedList<Integer> y = new LinkedList<>();
        y.addFirst(0);
        y.add(1);
        y.add(2);
        vector = new Vector(y);
        assertEquals(0,vector.get(0));
    }
    @Test
    public void testCopyInto(){
        int[][] x = {{1,2,3},{4,5,6}};
        vector.copyInto(x);

    }
    @Test
    public void testTrimToSize(){
        vector.trimToSize();
    }
    @Test
    public void testTrimToSize2(){
        Vector v = new Vector(2);
        v.insertElementAt(0,0);
        v.insertElementAt(1,1);
        v.insertElementAt(2,2);
        vector.trimToSize();
        v.insertElementAt(3,3);
        v.insertElementAt(4,4);
        v.insertElementAt(5,5);
        vector.trimToSize();

    }
    @Test
    public void testEnsureCapacity(){
        Vector v = new Vector(2,2);
        v.ensureCapacity(400);
    }
    @Test
    public void setSize(){ // ??
        Vector v = new Vector(2,2);
        v.setSize(400);
        Vector v1 = new Vector(2,2);
        v1.insertElementAt(2,0);
        v1.insertElementAt(3,1);
        v1.setSize(1);
        Vector v2 = new Vector(2,2);
        v2.insertElementAt(2,0);
        v2.insertElementAt(3,1);
        v2.setSize(2);
        Vector v3 = new Vector();
        v3.setSize(0);
    }
    @Test
    public void setSize2(){
        Vector v = new Vector(2,2);
        v.setSize(1);
    }
    @Test
    public void testCapacity(){
        Vector v = new Vector(2,2);
        v.capacity();
    }

    @Test
    public void testSize(){
        vector.size();
    }
    @Test
    public void testIsEmpty(){
        vector.isEmpty();
        vector.insertElementAt(0,0);
        vector.isEmpty();
    }
    @Test
    public void testElements(){
        Enumeration e = vector.elements();
        vector.insertElementAt(0,0);
        vector.insertElementAt(0,1);
        e.hasMoreElements();
        e.nextElement();

    }
    @Test (expected = NoSuchElementException.class)
    public void testElements2(){
        Enumeration e = vector.elements();
        e.hasMoreElements();
        e.nextElement();

    }
    @Test
    public void testContains(){
        vector.contains(1);
        vector.insertElementAt(0,0);
        vector.contains(0);

    }
    @Test
    public void TestIndexOf(){
        vector.insertElementAt(0,0);
        vector.indexOf(0);

    }
    @Test
    public void testIndexOf_2par(){

        vector.insertElementAt(0,0);
        vector.insertElementAt(0,1);
        vector.insertElementAt(0,2);
        vector.indexOf(null,0);
        vector.insertElementAt(null,3);
        vector.indexOf(null,0);
        vector.indexOf(1,0);
        vector.indexOf(1,5);
    }
//65% coverage


}
