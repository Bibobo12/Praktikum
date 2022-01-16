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
    @Test
    public void testIndexOf_2par_for(){
        vector.insertElementAt(0,0);
        vector.insertElementAt(0,1);
        vector.indexOf(0,0);
        vector.indexOf(10,0);

    }
//65% coverage
    @Test
    public void testLastIndexOf_1par(){
        vector.insertElementAt(0,0);
        vector.insertElementAt(0,1);

        vector.lastIndexOf(null);
        vector.insertElementAt(null,1);
        vector.lastIndexOf(null);
        vector.lastIndexOf(10);
        vector.lastIndexOf(0);

    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testLastIndexOf_2par(){
        vector.lastIndexOf(1,10);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testElementAt(){
        vector.insertElementAt(0,0);
        vector.elementAt(2);

    }
    @Test
    public void testElementAt_2(){
        vector.insertElementAt(0,0);
        vector.insertElementAt(1,1);
        vector.elementAt(0);

    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testElementAt_3(){
        vector.insertElementAt(0,0);
        vector.insertElementAt(1,1);
        vector.elementAt(-1);

    }
    @Test (expected = NoSuchElementException.class)
    public void testFirstElement2(){
        vector.elementCount=-2;
        vector.firstElement();

    }
    @Test (expected = NoSuchElementException.class)
    public void testLastElement2(){
        vector.elementCount=0;
        vector.lastElement();
    }
    @Test
    public void testLastElement3(){
        vector.elementCount=2;
        vector.lastElement();
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSetElementAt(){
        vector.elementCount=2;
        vector.setElementAt(null,5);

    }
    @Test
    public void testSetElementAt2(){
        vector.elementCount=2;
        vector.setElementAt(null,1);

    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveElementAt(){
        vector.elementCount=2;
        vector.removeElementAt(5);

    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveElementAt2(){
        vector.elementCount=2;
        vector.removeElementAt(-1);

    }
    @Test
    public void testRemoveElementAt3(){
        vector.elementCount=2;
        vector.removeElementAt(1);

    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testInsertElementAt(){
        vector.elementCount=2;
        vector.insertElementAt(null,5);

    }
    @Test
    public void testAddElement(){
        vector.addElement(null);

    }
    @Test
    public void testRemoveElement2(){
        vector.removeElement(null);
        vector.insertElementAt(0,0);
        vector.insertElementAt(0,1);
        vector.insertElementAt(0,2);
        vector.removeElement(0);
    }
    @Test
    public void testRemoveAllElements(){
        vector.elementCount=2;
        vector.removeAllElements();
    }
    @Test
    public void testclone(){
        vector.clone();

    }
    @Test (expected = NullPointerException.class)
    public void testToArray(){
        Object[] x = null;
        vector.toArray(x);

    }
    @Test
    public void testToArray2(){
        vector.elementCount=10;
        Object[] x = {null,null,2};
        vector.toArray(x);

    }
    @Test
    public void testToArray3(){
        vector.elementCount=1;
        Object[] x = {null,null,2};
        vector.toArray(x);

    }
    @Test
    public void testToArray4(){
        vector.toArray();

    }
    @Test
    public void testget(){
        vector.elementCount=2;
        vector.get(0);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testget2(){
        vector.elementCount=2;
        vector.get(10);
    }
    @Test
    public void testSet(){
        vector.elementCount=2;
        vector.set(0,null);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSet2(){
        vector.elementCount=2;
        vector.set(10,null);
    }
    @Test
    public void testadd(){
        vector.add(null);
    }
    @Test
    public void testremove(){
        vector.remove(null);
    }
    @Test
    public void testadd_2par(){
        vector.add(2,null);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testremove2(){
        vector.elementCount=2;
        vector.remove(6);
    }
    @Test
    public void testremove3(){
        vector.elementCount=2;
        vector.remove(0);
    }

    @Test
    public void testclear(){
        vector.clear();
    }
    @Test (expected = NullPointerException.class)
    public void testcontainsAll(){
        LinkedList<Integer> x = null;
        vector.containsAll(x);
    }
    @Test
    public void testaddAll(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        vector.addAll(x);
    }
    @Test
    public void testaddAll_2par(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        vector.addAll(2,x);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testaddAll_2par_2(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        vector.addAll(-2,x);
    }
    @Test
    public void testaddAll_2par_3(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        vector.addAll(1,x);
    }
    @Test
    public void testaddAll_2par_4(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        vector.addAll(5,x);
    }
    @Test
    public void testaddAll_2par_5(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        vector.addAll(0,x);
    }
    @Test
    public void testremoveAll(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        vector.removeAll(x);
    }
    @Test
    public void testretainAll(){
        vector.elementCount=2;
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        vector.retainAll(x);
    }
    @Test
    public void testEquals(){
        vector.equals(null);
    }
    @Test
    public void testhashCode(){
        vector.hashCode();
    }
    @Test
    public void testtoString(){
        vector.toString();
    }
    @Test
    public void testsubList(){
        vector.subList(1,2);
    }


}
