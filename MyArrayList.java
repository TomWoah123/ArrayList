import java.util.Collection;

/**
 * Makes the MyArrayList class
 * @author Timothy Wu
 * @version 9.20.18
 * @param <E> Any type of element
 */
public class MyArrayList<E> 
{
    private int size;
    private Object[] values;

    /**
     * Builds the MyArrayList class with size = 0
     * and builds values
     */
    public MyArrayList()
    {
        size = 0;
        values = new Object[ size ];
    }

    /**
     * Builds the MyArrayList class with size equal 
     * to the initialCapacity and build values
     * @param initialCapacity The value for size to be set to
     */
    public MyArrayList( int initialCapacity )
    {
        if ( initialCapacity < 0 )
        {
            throw new IllegalArgumentException();
        }
        size = 0;
        values = new Object[ initialCapacity ];
    }

    /**
     * Builds the MyArrayList class with size equal
     * to 0 and the elements in the collection set in
     * values
     * @param c The collection for the values to be set into
     */
    public MyArrayList( Collection<E> c )
    {
        size = 0;
        values = new Object[ c.size() ];
        addAll( c );
    }

    /**
     * Adds the element to the array and returns true when
     * it is added
     * @param o the element to be added
     * @return true if the element is added
     */
    public boolean add( E o )
    {
        ensureCapacity( size + 1 );
        size++;
        values[ size - 1 ] = ( E ) o;
        return true;
    }

    /**
     * Adds the element to a specified index
     * @param index The specified index
     * @param o The specified element
     * @throws IndexOutOfBoundsException if invalid index
     * is given
     */
    public void add( int index, E o )
    {
        if ( index < 0 || index > size )
        {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity( size + 1 );
        size++;
        values[ index ] = o;
        for ( int i = size - 1; i > index; i-- )
        {
            values[ i ] = values[ i - 1 ];
        }
        values[ index ] = o;
    }

    /**
     * Removes the specified object from the 
     * MyArrayList and returns true when it is
     * removed
     * @param o The specified object to be removed
     * @return True if the object is removed
     */
    public boolean remove( Object o )
    {
        if ( indexOf( o ) == -1 )
        {
            return false;
        }
        remove( indexOf( o ) );
        return true;
    }

    /**
     * Removes the element at the specified index
     * @param index The index at which the element should
     * be removed at
     * @return The element in the index
     * @throws IndexOutOfBoundsException if invalid index
     * is given
     */
    public E remove( int index )
    {
        if ( index < 0 || index >= size )
        {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings( "unchecked" )
        E old = ( E ) values[ index ];
        for ( int i = index; i < size - 1; i++ )
        {
            values[i] = values[ i + 1 ];
        }
        size--;
        return old;
    }

    /**
     * Returns the object at a specified index
     * @param index The slot number of the MyArrayList
     * @return The object at the specified index
     * @throws IndexOutOfBoundsException if invalid index
     * is given
     */
    public E get( int index )
    {
        if ( index < 0 || index >= size )
        {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings( "unchecked" )
        E elm = ( E ) values[ index ];
        return elm;
    }

    /**
     * Sets a specified element at a specified index
     * and returns the element that was originally in
     * the MyArrayList
     * @param index The specified index
     * @param o The specified element
     * @return The element that was originally in the
     * MyArrayList
     * @throws IndexOutOfBoundsException if invalid index
     * is given
     */
    public E set( int index, E o )
    {
        if ( index < 0 || index > size )
        {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings( "unchecked" )
        E old = ( E ) values[ index ];
        values[ index ] = o;
        return old;
    }

    /**
     * Returns the size of the MyArrayList
     * @return size
     */
    public int size()
    {
        return size;
    }

    /**
     * Adds the elements from the collection into
     * the MyArrayList
     * @param c The collection of elements
     */
    public void addAll( Collection<E> c )
    {
        for ( E e : c )
        {
            add( e );
        }
    }

    /**
     * Checks if there is nothing in the MyArrayList
     * @return True if the MyArrayList is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns true if the object is in the MyArrayList,
     * else return false
     * @param o The object to be looked for
     * @return True if the object is in the MyArrayList
     */
    public boolean contains( Object o )
    {
        for ( int i = 0; i < size; i++ )
        {
            if ( values[ i ].equals( o ) )
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the MyArrayList in the form of a string
     * @return The string version of the array
     */
    public String toString()
    {
        if ( size == 0 )
        {
            return "[]";
        }
        StringBuilder ans = new StringBuilder();
        ans.append( "[ " );
        for ( int i = 0; i < size - 1; i++ )
        {
            ans.append( "" + values[ i ] + ", " );
        }
        ans.append( "" + values[ size - 1 ] + " ]" );
        return ans.toString();
    }

    /**
     * Clears the MyArrayList
     */
    public void clear()
    {
        for ( int i = 0; i < size; i++ )
        {
            values[ i ] = null;
        }
        size = 0;
    }

    /**
     * Changes the length of the MyArrayList to
     * at least the minimum number
     * @param min The minimum length of the MyArrayList
     */
    public void ensureCapacity( int min )
    {
        int newLength = 1;
        if ( min >= Integer.MAX_VALUE / 2 )
        {
            newLength = Integer.MAX_VALUE;
        }
        while ( min > newLength )
        {
            newLength *= 2;
        }
        Object[] newVals = new Object[ newLength ];
        for ( int i = 0; i < size; i++ )
        {
            newVals[ i ] = values[ i ];
        }
        values = newVals;
    }

    /**
     * Returns the first occurrence of the specified
     * object
     * @param o The specified object
     * @return The first index of the specified object
     */
    public int indexOf( Object o )
    {
        for ( int i = 0; i < size; i++ )
        {
            if ( values[ i ].equals( o ) )
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the last occurrence of the specified
     * object
     * @param o The specified object
     * @return The last index of the specified object
     */
    public int lastIndexOf( Object o )
    {
        for ( int i = size - 1; i >= 0; i-- )
        {
            if ( values[ i ].equals( o ) )
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the objects from the MyArrayList from
     * the first index, inclusive, to the second index,
     * exclusive
     * @param from The starting index
     * @param to The ending index
     * @throws IndexOutOfBoundsException if invalid indices are
     * given
     */
    public void removeRange( int from, int to )
    {
        if ( from < 0 || to > size || to < from )
        {
            throw new IndexOutOfBoundsException();
        }
        for ( int i = to - 1; i >= from; i-- )
        {
            remove( i );
        }
    }

    /**
     * Converts the MyArrayList into a normal array
     * @return the array version of MyArrayList
     */
    public Object[] toArray()
    {
        Object[] arr = new Object[ size ];
        for ( int i = 0; i < size; i++ )
        {
            arr[ i ] = values[ i ];
        }
        return arr;
    }

    /**
     * Trims the length of the MyArrayList to the size
     */
    public void trimToSize()
    {
        int numUsed = 0;
        for ( int i = 0; i < values.length; i++ )
        {
            if ( values[ i ] != null )
            {
                numUsed++;
            }
        }
        size = numUsed;
    }

    /**
     * Checks if the MyArrayList has the same objects in
     * the same order as another MyArrayList
     * @param o The other MyArrayList to be checked
     * @return True if the MyArrayLists are equal
     */
    public boolean equals( Object o )
    {
        if ( o == this )
        {
            return true;
        }
        if ( !( o instanceof MyArrayList ) )
        {
            return false;
        }
        @SuppressWarnings( "unchecked" )
        MyArrayList<E> other = ( MyArrayList<E> ) o;
        if ( size != other.size() )
        {
            return false;
        }
        for ( int i = 0; i < size; i++ )
        {
            if ( !values[ i ].equals( other.get( i ) ) )
            {
                return false;
            }
        }
        return true;
    }
}