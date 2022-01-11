import static org.junit.Assert.*;
import org.junit.*;


public class JDKSortTest {
    private JDKSort jsort;
    @Before
    public void setup(){
        jsort = new JDKSort();
    }
    @Test
    public void test_sorting_array(){
        int[] unsorted = {4,9,6,8,3,2,1,7,5};
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        //int[] true_unsorted = {4,9,6,8,3,2,1,7,5};
        int[] jdksorted = jsort.sort(unsorted);
        /*for (int i = 0; i < unsorted.length; i++) {
            assertEquals(sorted[i],jdksorted[i]);
        }*/
        assertArrayEquals(sorted,jdksorted);
    }
    @Test
    public void testNegativeArray(){
        int[] unsorted = {-4,-9,-6,-8,-3,-2,-1,-7,-5};
        int[] sorted = {-9,-8,-7,-6,-5,-4,-3,-2,-1};
        int[] jdksorted = jsort.sort(unsorted);
        /*for (int i = 0; i < unsorted.length; i++) {
            assertEquals(sorted[i],jdksorted[i]);
        }*/
        assertArrayEquals(sorted,jdksorted);
    }
    @Test
    public void testEmptyArray(){
        int[] unsorted = {};
        int[] sorted = {};
        int[] jdksorted = jsort.sort(unsorted);
        assertTrue(jdksorted.length==0);
    }
    @Test
    public void testRandomArray(){
        int[] unsorted = {-9,5,4,-6,2,-200,3,7,7};
        int[] sorted = {-200,-9,-6,2,3,4,5,7,7};
        int[] jdksorted = jsort.sort(unsorted);
        assertArrayEquals(sorted,jdksorted);
    }
    @Test
    public void testMinArray(){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int[] unsorted = {-9,5,4,-6,2,min,3,7,7,max};
        int[] sorted = {min,-9,-6,2,3,4,5,7,7,max};
        int[] jdksorted = jsort.sort(unsorted);
        assertArrayEquals(sorted,jdksorted);
    }


}
