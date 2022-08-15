package pro.sky.skyprospringhomew215;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListImplTest {

    private final ListImpl arr = new ListImpl(new Integer[]{5, 1});

    private final ListImpl out = new ListImpl(new Integer[]{5, 1});

    @Test
    public void addItem() {
        Integer[] expected = new Integer[]{5, 1};
        out.add(5);
        out.add(1);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addIndex() {
        Integer[] expected = new Integer[]{5, 1};
        out.add(0, 5);
        out.add(1, 1);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setIndex() {
        Integer[] expected = new Integer[]{5, 1};
        out.set(0, 5);
        out.set(1, 1);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeItem() {
        Integer[] expected = new Integer[]{1};
        out.remove(5);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeIndex() {
        Integer[] expected = new Integer[]{1};
        out.removeInd(0);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void containsItem() {
        boolean expected = true;
        boolean actual = out.contains(5);
        assertEquals(expected, actual);
    }

    @Test
    public void searchIndexOf() {
        int expected = 0;
        int actual = out.indexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void searchLastIndexOf() {
        int expected = 0;
        int actual = out.indexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void getIndex() {
        Integer expected = 5;
        Integer actual = out.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getSize() {
        Integer[] array = new Integer[2];
        int expected = array.length;
        int actual = out.size();
        assertEquals(expected, actual);
    }

    @Test
    public void equals() {
        Integer[] array = new Integer[]{5, 1};
        boolean expected = Arrays.equals(arr.toArray(), array);
        boolean actual = out.equals(array);
        assertEquals(expected, actual);
    }

    @Test
    public void empty() {
        boolean expected = false;
        boolean actual = out.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void arrayNew() {
        Integer[] expected = new Integer[]{5, 1};
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getListIndexExceptionAddItem() {
        Assertions.assertThrows(ListIndexException.class, () -> out.add(null));
    }

    @Test
    public void getListIndexExceptionAddIndex() {
        Assertions.assertThrows(ListIndexException.class, () -> out.add(3, 2));
    }

    @Test
    public void getListIndexExceptionSet() {
        Assertions.assertThrows(ListIndexException.class, () -> out.set(5, 1));
    }

    @Test
    public void getListIndexExceptionRemove() {
        Assertions.assertThrows(ListIndexException.class, () -> out.removeInd(5));
    }

}
