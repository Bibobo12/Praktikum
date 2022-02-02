import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class primeNumberTest02 {
    private ProbeDivision pn;
    @Before
    public void setUp(){
         pn = new ProbeDivision();
    }
    @Test
    public void testgetPrime_punkt1(){
        int[] z = {4};
        pn.getPrime(z);
        assertEquals(false,pn.hashTab.get(4));
        assertEquals(true,pn.alreadyKnown.contains(4));
    }
    @Test
    public void testgetPrime_punkt2(){
        int[] z = {7};
        pn.getPrime(z);
        assertEquals(true,pn.hashTab.get(7));
        assertEquals(true,pn.alreadyKnown.contains(7));
    }
    @Test
    public void testgetPrime_punkt3(){
        int[] z = {7};
        List<Integer> res = pn.getPrime(z);
        res=pn.getPrime(z);
        List<Integer> test = new ArrayList<>();
        test.add(7);
        assertEquals(test,res);
    }


}
