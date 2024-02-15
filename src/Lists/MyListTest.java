package Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    MyList list;

    @BeforeEach
    void setUp() {
        list = new MyList();
    }

    @Test
    void testAddValid1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
        });
        assertEquals(3, list.size());
    }

    @Test
    void testAddValid2() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);
        });
        assertEquals(5, list.size());
    }
    @Test
    void testAddAtValid1() {
        assertDoesNotThrow(() -> {
            list.add(20);
            list.add(40);
            list.add(50);
            list.addAt(2, 30);
            list.addAt(1, 10);
        });
        assertEquals(5, list.size());
        assertEquals(40, list.get(4));
        assertEquals(50, list.get(5));
    }

    @Test
    void testAddAtValid2() {
        assertDoesNotThrow(() -> {
            list.addAt(1, 10);
            list.add(20);
            list.add(30);
            list.addAt(1, 5);
            list.addAt(5, 50);
        });
        assertEquals(5, list.size());
        assertEquals(30, list.get(4));
    }

    @Test
    void testAddAtInvalid1() {
        assertDoesNotThrow(() -> {
            list.addAt(1, 10);
            list.add(20);
            list.add(30);
            list.addAt(1, 5);
            list.addAt(5, 50);
        });
        Exception e = assertThrowsExactly(ArrayFullException.class, ()->{list.addAt(2, 8);});
        assertEquals("The array is full and 8 cannot be inserted.", e.getMessage());
        assertEquals(5, list.size());
        assertEquals(30, list.get(4));
    }

    @Test
    void testAddAtInvalid2() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.addAt(2, 20);
            list.addAt(1, 5);
        });
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.addAt(5, 100);});
        assertEquals("Position must be between 1 and 4", e.getMessage());
        assertEquals(3, list.size());
    }

    @Test
    void testAddAtInvalid3() {
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.addAt(2, 100);});
        assertEquals("Position must be between 1 and 1", e.getMessage());
        assertEquals(0, list.size());
    }

    @Test
    void testAddInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);
        });
        ArrayFullException e1 = assertThrowsExactly(ArrayFullException.class, () -> {
            list.add(60);
        });
        Exception e2 = assertThrowsExactly(ArrayFullException.class, () -> {
            list.add(70);
        });
        assertEquals(5, list.size());
        assertEquals("The array is full and 60 cannot be inserted.", e1.getMessage());
        assertEquals("The array is full and 70 cannot be inserted.", e2.getMessage());
        assertFalse(e2 instanceof RuntimeException);
    }

    @Test
    void testRemoveTrue() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);
        });
        assertTrue(list.remove(50));
        assertTrue(list.remove(20));
        assertTrue(list.remove(40));
    }

    @Test
    void testRemoveFalse1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(50);
        });
        assertFalse(list.remove(2));
        assertFalse(list.remove(40));
    }

    @Test
    void testGetValid1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);
        });
        assertEquals(10, list.get(1));
        assertEquals(30, list.get(3));
        assertEquals(50, list.get(5));
    }

    @Test
    void testGetInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
        });
        assertEquals(10, list.get(1));
        assertEquals(30, list.get(3));
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.get(4);});
        assertEquals("Position must be between 1 and 3", e.getMessage());
        assertTrue(e instanceof RuntimeException);
    }

    @Test
    void testGetInvalid2() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
        });
        assertEquals(10, list.get(1));
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.get(0);});
        assertEquals("Position must be between 1 and 2", e.getMessage());
    }

    @Test
    void testRemoveFalse2() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(50);
        });
        assertTrue(list.remove(20));
        assertFalse(list.remove(20));
    }

    @Test
    void testRemoveThenAddContains() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(50);
        });
        assertTrue(list.contains(20));
        assertTrue(list.remove(20));
        assertFalse(list.contains(20));
        assertFalse(list.remove(20));
        assertDoesNotThrow(() -> {list.add(20);});
        assertTrue(list.contains(20));
    }

    @Test
    void testRemoveAtValid() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(50);

        });
        assertEquals(4, list.size());
        assertEquals(30, list.removeAt(3));
        assertEquals(50, list.get(3));
        assertEquals(3, list.size());
    }

    @Test
    void testRemoveAtInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);

        });
        assertEquals(3, list.size());
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.removeAt(4);});
        assertEquals("Position must be between 1 and 3", e.getMessage());
        assertEquals(30, list.get(3));
        assertEquals(3, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        assertDoesNotThrow(() -> {list.add(13);});
        assertFalse(list.isEmpty());
    }

    @Test
    void setValid1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
            assertEquals(20, list.set(2, 13));
        });
        assertEquals(13, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void setInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(10);
            list.add(20);
            list.add(30);
        });
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.set(4, 50);});
        assertEquals("Position must be between 1 and 3", e.getMessage());
        assertEquals(3, list.size());
    }
}