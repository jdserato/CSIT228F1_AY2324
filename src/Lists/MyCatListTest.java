package Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCatListTest {
    MyCatList list;

    @BeforeEach
    void setUp() {
        list = new MyCatList();
    }

    @Test
    void testAddValid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Aries"));
            list.add(new Cat("Lily"));
            list.add(new Cat("Phoebe"));
        });
        assertEquals(3, list.size());
    }

    @Test
    void testAddValid2() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Lion"));
            list.add(new Cat("Tiger"));
            list.add(new Cat("Katol"));
            list.add(new Cat("Pooh"));
            list.add(new Cat("Pusacat"));
        });
        assertEquals(5, list.size());
    }
    @Test
    void testAddAtValid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Kathniel"));
            list.add(new Cat("Kathryn"));
            list.add(new Cat("Wow"));
            list.addAt(2, new Cat("Omai"));
            list.addAt(1, new Cat("Siomeow"));
        });
        assertEquals(5, list.size());
        assertEquals("Kathryn", list.get(4).name);
        assertEquals("Wow", list.get(5).name);
    }

    @Test
    void testAddAtValid2() {
        assertDoesNotThrow(() -> {
            list.addAt(1, new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.addAt(1, new Cat("Kirara"));
            list.addAt(5, new Cat("Urie"));
        });
        assertEquals(5, list.size());
        assertEquals("Furbaby", list.get(4).name);
    }

    @Test
    void testAddAtInvalid1() {
        assertDoesNotThrow(() -> {
            list.addAt(1, new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.addAt(1, new Cat("Kirara"));
            list.addAt(5, new Cat("Urie"));
        });
        Exception e = assertThrowsExactly(ArrayFullException.class, ()->{list.addAt(2, new Cat("Elle"));});
        assertEquals("The array is full and Elle cannot be inserted.", e.getMessage());
        assertEquals(5, list.size());
        assertEquals("Furbaby", list.get(4).name);
    }

    @Test
    void testAddAtInvalid2() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.addAt(2, new Cat("Cathy"));
            list.addAt(1, new Cat("Kirara"));
        });
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.addAt(5, new Cat("Lynette"));});
        assertEquals("Position must be between 1 and 4", e.getMessage());
        assertEquals(3, list.size());
    }

    @Test
    void testAddAtInvalid3() {
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.addAt(2, new Cat("Elle"));});
        assertEquals("Position must be between 1 and 1", e.getMessage());
        assertEquals(0, list.size());
    }

    @Test
    void testAddInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.add(new Cat("Kirara"));
            list.add(new Cat("Urie"));
        });
        ArrayFullException e1 = assertThrowsExactly(ArrayFullException.class, () -> {
            list.add(new Cat("Mrow"));
        });
        Exception e2 = assertThrowsExactly(ArrayFullException.class, () -> {
            list.add(new Cat("Fufu"));
        });
        assertEquals(5, list.size());
        assertEquals("The array is full and Mrow cannot be inserted.", e1.getMessage());
        assertEquals("The array is full and Fufu cannot be inserted.", e2.getMessage());
        assertFalse(e2 instanceof RuntimeException);
    }

    @Test
    void testRemoveTrue() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.add(new Cat("Kirara"));
            list.add(new Cat("Urie"));
        });
        assertTrue(list.remove("Urie"));
        assertTrue(list.remove("Cathy"));
        assertTrue(list.remove("Kirara"));
    }

    @Test
    void testRemoveFalse1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.add(new Cat("Urie"));
        });
        assertFalse(list.remove("Furina"));
        assertFalse(list.remove("Karina"));
    }

    @Test
    void testGetValid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.add(new Cat("Vince"));
            list.add(new Cat("Urie"));
        });
        assertEquals("Meowy", list.get(1).name);
        assertEquals("Furbaby", list.get(3).name);
        assertEquals("Urie", list.get(5).name);
    }

    @Test
    void testGetInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
        });
        assertEquals("Meowy", list.get(1).name);
        assertEquals("Furbaby", list.get(3).name);
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.get(4);});
        assertEquals("Position must be between 1 and 3", e.getMessage());
        assertTrue(e instanceof RuntimeException);
    }

    @Test
    void testGetInvalid2() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
        });
        assertEquals("Meowy", list.get(1).name);
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.get(0);});
        assertEquals("Position must be between 1 and 2", e.getMessage());
    }

    @Test
    void testRemoveFalse2() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.add(new Cat("Urie"));
        });
        assertTrue(list.remove("Cathy"));
        assertFalse(list.remove("Cathy"));
    }

    @Test
    void testRemoveThenAddContains() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.add(new Cat("Urie"));
        });
        assertTrue(list.contains("Cathy"));
        assertTrue(list.remove("Cathy"));
        assertFalse(list.contains("Cathy"));
        assertFalse(list.remove("Cathy"));
        assertDoesNotThrow(() -> {list.add(new Cat("Cathy"));});
        assertTrue(list.contains("Cathy"));
    }

    @Test
    void testRemoveAtValid() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            list.add(new Cat("Urie"));

        });
        assertEquals(4, list.size());
        assertEquals("Furbaby", list.removeAt(3).name);
        assertEquals("Urie", list.get(3).name);
        assertEquals(3, list.size());
    }

    @Test
    void testRemoveAtInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));

        });
        assertEquals(3, list.size());
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.removeAt(4);});
        assertEquals("Position must be between 1 and 3", e.getMessage());
        assertEquals("Furbaby", list.get(3).name);
        assertEquals(3, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        assertDoesNotThrow(() -> {list.add(new Cat("Flounder"));});
        assertFalse(list.isEmpty());
    }

    @Test
    void setValid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
            assertEquals("Cathy", list.set(2, new Cat("Flounder")).name);
        });
        assertEquals("Flounder", list.get(2).name);
        assertEquals(3, list.size());
    }

    @Test
    void setInvalid1() {
        assertDoesNotThrow(() -> {
            list.add(new Cat("Meowy"));
            list.add(new Cat("Cathy"));
            list.add(new Cat("Furbaby"));
        });
        Exception e = assertThrowsExactly(InvalidPositionException.class, ()->{list.set(4, new Cat("Urie"));});
        assertEquals("Position must be between 1 and 3", e.getMessage());
        assertEquals(3, list.size());
    }
}