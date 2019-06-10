import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Testing the MyArrayList class
 * @author Timothy Wu
 * @version 9.26.18
 */
public class MyArrayListTest 
{
    private MyArrayList<Integer> nums;
    private MyArrayList<String> str;

    /**
     * Sets up the 2 MyArrayLists
     */
    @Before
    public void setUp()
    {
        nums = new MyArrayList<Integer>();
        str = new MyArrayList<String>();
        nums.add( new Integer( 1 ) );
        nums.add( new Integer( 2 ) );
        nums.add( new Integer( 3 ) );
        nums.add( new Integer( 4 ) );
        nums.add( new Integer( 5 ) );
        str.add( "John" );
        str.add( "JV Corsino" );
        str.add( "Meermans" );
        str.add( "hello" );
        str.add( "how are you?" );
    }

    /**
     * Sets the 2 MyArrayLists equal to null
     */
    @After
    public void tearDown()
    {
        nums = null;
        str = null;
    }
    
    /**
     * Tests the constructor
     */
    @Test
    public void testConstructor()
    {
        MyArrayList<Integer> s = new MyArrayList<Integer>();
        assertEquals( "[]", s.toString() );
    }
    
    /**
     * Tests the constructor
     */
    @Test
    public void testMoreConstructor()
    {
        MyArrayList<String> ss = new MyArrayList<String>( 9 );
        assertEquals( 0, ss.size() );
    }
    
    /**
     * Tests the constructor
     */
    @Test( expected = IllegalArgumentException.class )
    public void testMoreCon()
    {
        assertEquals( nums, nums );
        MyArrayList<String> s = new MyArrayList<String>( -2 );
        s.size();
    }
    
    /**
     * Tests the constructor
     */
    @Test
    public void testOtherConstructor()
    {
        Collection<Integer> g = new ArrayList<Integer>();
        g.add( new Integer( 7 ) );
        g.add( new Integer( 1008 ) );
        MyArrayList<Integer> numbers = new MyArrayList<Integer>( g );
        assertEquals( "[ 7, 1008 ]", numbers.toString() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testAdd() 
    {
        assertTrue( nums.add( new Integer( 3 ) ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testAddWithTwoParams()
    {
        str.add( 1, "good" );
        assertEquals( "hello", str.get( 4 ) );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testMoreAddWithTwoParams()
    {
        nums.add( 3, new Integer( 77 ) );
        assertEquals( new Integer( 77 ), nums.get( 3 ) );
    }

    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testMoreEvenAddWithTwoParams()
    {
        assertEquals( nums, nums );
        str.add( 18, "j" );
    }
    
    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testOutOfBoundsAdd()
    {
        assertEquals( str, str );
        str.add( -1, "help" );
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemove()
    {
        str.remove( 2 );
        assertEquals( "hello", str.get( 2 ) );
    }

    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testMoreRemove()
    {
        assertEquals( str, str );
        str.remove( 69 );
    }
    
    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testEvenMoreRemove()
    {
        assertEquals( nums, nums );
        nums.remove( -18 );
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveWithObj()
    {
        str.remove( "Meermans" );
        assertEquals( "hello", str.get( 2 ) );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testMoreRemoveWithObj()
    {
        assertFalse( str.remove( "gg" ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testGet()
    {
        MyArrayList<Integer> arr = new MyArrayList<Integer>();
        arr.add( new Integer( 3 ) );
        arr.add( new Integer( 5 ) );
        arr.add( new Integer( 17 ) );
        assertEquals( ( Object ) 17, arr.get( 2 ) );
    }

    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testMoreGet()
    {
        assertEquals( nums, nums );
        nums.get( -1 );
    }
    
    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testEvenMoreGet()
    {
        assertEquals( str, str );
        str.get( 99 );
    }

    /**
     * Tests the method
     */
    @Test
    public void testSet()
    {
        nums.set( 1, new Integer( 64 ) );
        String s = "[ 1, 64, 3, 4, 5 ]";
        assertEquals( s, nums.toString() );
    }

    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testMoreSet()
    {
        assertEquals( str, str );
        str.set( -1, "87" );
    }
    
    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testEvenMoreSet()
    {
        assertEquals( nums, nums );
        nums.set( 97,  new Integer( 8 ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testSize()
    {
        assertEquals( 5, str.size() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testAddAll()
    {
        Collection<String> c = new ArrayList<String>();
        c.add( "hola" );
        c.add( "gg" );
        str.addAll( c );
        String s = "[ John, JV Corsino, Meermans,"
                + " hello, how are you?, hola, gg ]";
        assertEquals( s, str.toString() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testToString()
    {
        assertEquals( "[ 1, 2, 3, 4, 5 ]", nums.toString() );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testMoreToString()
    {
        MyArrayList<String> t = new MyArrayList<String>();
        assertEquals( "[]", t.toString() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testIndexOf()
    {
        assertEquals( 2, str.indexOf( "Meermans" ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreIndexOf()
    {
        assertEquals( -1, nums.indexOf( new Integer( 6 ) ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testLastIndexOf()
    {
        nums.add( new Integer( 3 ) );
        assertEquals( 5, nums.lastIndexOf( new Integer( 3 ) ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreLastIndexOf()
    {
        assertEquals( -1, str.lastIndexOf( "g" ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testContains()
    {
        assertTrue( nums.contains( new Integer( 3 ) ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreContains()
    {
        assertFalse( str.contains( "good morning" ) );
    }

    /**
     * Tests the method
     */
    @Test
    public void testIsEmpty()
    {
        MyArrayList<Double> d = new MyArrayList<Double>();
        assertTrue( d.isEmpty() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreIsEmpty()
    {
        assertFalse( nums.isEmpty() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testClear()
    {
        nums.clear();
        assertEquals( 0, nums.size() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveRange()
    {
        nums.removeRange( 1,  4 );
        assertEquals( "[ 1, 5 ]", nums.toString() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreRemoveRange()
    {
        str.removeRange( 0, 5 );
        assertEquals( "[]", str.toString() );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testRemoveBegin()
    {
        str.removeRange( 0,  3 );
        assertEquals( "[ hello, how are you? ]", str.toString() );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testRemoveEnd()
    {
        nums.removeRange( 3,  5 );
        assertEquals( "[ 1, 2, 3 ]", nums.toString() );
    }

    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testEvenMoreRemoveRange()
    {
        assertEquals( nums, nums );
        str.removeRange( 3,  2 );
    }

    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testOutOfBoundsRemoveRange()
    {
        assertEquals( str, str );
        str.removeRange( -1, 3 );
    }
    
    /**
     * Tests the method
     */
    @Test( expected = IndexOutOfBoundsException.class )
    public void testMoreOutOfBoundsRemoveRange()
    {
        assertEquals( nums, nums );
        str.removeRange( 3,  69 );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testRRNothing()
    {
        nums.removeRange( 0, 0 );
        assertEquals( "[ 1, 2, 3, 4, 5 ]", nums.toString() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testEnsureCapacity()
    {
        nums.ensureCapacity( nums.toArray().length + 1 );
        nums.add( new Integer( 6 ) );
        assertEquals( 6, nums.toArray().length );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testToArray()
    {
        Integer[] arr = {1, 2, 3, 4, 5};
        assertArrayEquals( arr, nums.toArray() );
    }

    /**
     * Tests the method
     */
    @Test
    public void testTrimToSize()
    {
        MyArrayList<String> s = new MyArrayList<String>( 8 );
        s.add( "hi" );
        s.add( "my name is" );
        s.add( "tom" );
        s.trimToSize();
        assertEquals( 3, s.toArray().length );
    }
    
    /**
     * Tests the method
     */
    @Test
    public void testMoreTrimToSize()
    {
        MyArrayList<Integer> s = new MyArrayList<Integer>();
        s.trimToSize();
        s.trimToSize();
        assertEquals( 0, s.toArray().length );
    }

    /**
     * Tests the method
     */
    @Test
    public void testEquals()
    {
        MyArrayList<Integer> arr = new MyArrayList<Integer>();
        arr.add( new Integer( 1 ) );
        arr.add( new Integer( 2 ) );
        arr.add( new Integer( 3 ) );
        arr.add( new Integer( 4 ) );
        arr.add( new Integer( 5 ) );
        assertEquals( arr, nums );
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreEquals()
    {
        Integer i = new Integer( 4 );
        assertFalse( nums.equals( i ) );
    }

}
