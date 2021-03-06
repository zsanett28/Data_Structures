package singlylinkedlist.list;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void testCreate() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals(0, list.size());
    }

    @Test
    void testAddSingleElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(10);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testAddMultipleElements() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        list.add(23);
        list.add(2);

        assertEquals(3, list.size());
        assertEquals(5, list.get(0));
        assertEquals(23, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void testToArray() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        list.add(10);
        list.add(15);
        assertArrayEquals(new int[]{5, 10, 15}, list.toArray());
    }

    @Test
    void testOf() {
        List list = List.of();

        assertArrayEquals(new int[]{}, list.toArray());

        list = List.of(10, 5, 6);

        assertArrayEquals(new int[]{10, 5, 6}, list.toArray());

    }

    @Test
    void testEquals() {
        // Empty lists
        List list1 = new SinglyLinkedList();
        List list2 = List.of();

        // reflexive
        assertEquals(list1, list1);
        assertEquals(list2, list2);

        // symmetric
        assertEquals(list1, list2);
        assertEquals(list2, list1);

        // null
        assertNotEquals(list1, null);


        // Equal lists

        list1.add(5);
        list1.add(10);
        list1.add(15);

        list2 = List.of(5, 10, 15);

        // reflexive
        assertEquals(list1, list1);
        assertEquals(list2, list2);

        // symmetric
        assertEquals(list1, list2);
        assertEquals(list2, list1);

        // null
        assertNotEquals(list1, null);

        // transitive
        List list3 = new SinglyLinkedList();

        list3.add(0, 15);
        list3.add(0, 10);
        list3.add(0, 5);

        assertEquals(list2, list3);
        assertEquals(list1, list3);


        // Same size, different element
        list1.set(1, 8);

        // reflexive
        assertEquals(list1, list1);
        assertEquals(list2, list2);

        // symmetric
        assertNotEquals(list1, list2);
        assertNotEquals(list2, list1);

        // null
        assertNotEquals(list1, null);
        assertNotEquals(list2, null);


        // Different size
        list1 = List.of(5, 10, 15, 6);

        // reflexive
        assertEquals(list1, list1);
        assertEquals(list2, list2);

        // symmetric
        assertNotEquals(list1, list2);
        assertNotEquals(list2, list1);

        // null
        assertNotEquals(list1, null);
        assertNotEquals(list2, null);
    }

    @Test
    void testHashCode() {
        // Empty lists
        List list1 = new SinglyLinkedList();
        List list2 = List.of();

        assertEquals(list1.hashCode(), list2.hashCode());

        // Equal lists

        list1.add(5);
        list1.add(10);
        list1.add(15);

        list2 = List.of(5, 10, 15);

        assertEquals(list1.hashCode(), list2.hashCode());

    }

    @Test
    void testIndexOutOfBound() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(13));

        list.add(3);
        list.get(0);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));

        list.add(5);
        list.add(11);
        list.get(1);
    }

    @Test
    void testAddFirst() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(5);
        assertEquals(List.of(5), list);

        list.addFirst(10);
        assertEquals(List.of(10, 5), list);

        list.addFirst(7);
        assertEquals(List.of(7, 10, 5), list);
    }

    @Test
    void testAddLast() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(5);
        assertEquals(5, list.get(0));

        list.addLast(10);
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(0));

        list.addLast(7);
        assertEquals(7, list.get(2));
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(0));
    }

    @Test
    void testGetFirst() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(NoSuchElementException.class, () -> list.getFirst());

        list.addFirst(5);
        assertEquals(5, list.getFirst());

        list.addFirst(10);
        assertEquals(10, list.getFirst());

        list.addFirst(7);
        assertEquals(7, list.getFirst());
    }

    @Test
    void testGetLast() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(NoSuchElementException.class, () -> list.getLast());

        list.addLast(5);
        assertEquals(5, list.getLast());

        list.addLast(10);
        assertEquals(10, list.getLast());

        list.addLast(7);
        assertEquals(7, list.getLast());
    }

    @Test
    void testAddAtIndex() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(0, 5);
        assertEquals(5, list.get(0));

        list.add(1, 10);
        assertEquals(10, list.get(1));

        list.add(1, 15);
        assertEquals(15, list.get(1));

        list.add(0, 11);
        assertEquals(11, list.get(0));
    }

    @Test
    void testAddIndexOutOfBound() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 13));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 13));

        list.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, 13));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 13));

        list.add(1, 10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 13));
    }

    @Test
    void testSet() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 10));

        list.add(2);
        assertEquals(2, list.set(0, 10));
        assertEquals(10, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void testIndexOf() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals(-1, list.indexOf(3));

        list.add(10);
        list.add(15);
        assertEquals(1, list.indexOf(15));

        list.add(2, 20);
        assertEquals(2, list.indexOf(20));
        assertEquals(0, list.indexOf(10));

        list.set(0, 30);
        assertEquals(-1, list.indexOf(10));

        list.add(2, 6);
        list.add(4, 6);
        assertEquals(2, list.indexOf(6));
    }

    @Test
    void testContains() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertFalse(list.contains(10));
        list.add(10);
        assertTrue(list.contains(10));

        list.set(0, 15);
        assertTrue(list.contains(15));
        assertFalse(list.contains(10));
    }

    @Test
    void testIsEmpty() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertTrue(list.isEmpty());

        list.add(10);
        assertFalse(list.isEmpty());
    }

    @Test
    void testLastIndexOf() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals(-1, list.lastIndexOf(3));

        list.add(10);
        list.add(15);
        assertEquals(1, list.lastIndexOf(15));

        list.add(2, 20);
        assertEquals(2, list.lastIndexOf(20));
        assertEquals(0, list.lastIndexOf(10));

        list.set(0, 30);
        assertEquals(-1, list.lastIndexOf(10));

        list.add(2, 6);
        list.add(4, 6);
        assertEquals(4, list.lastIndexOf(6));

        list.add(6);
        assertEquals(5, list.lastIndexOf(6));
    }

    @Test
    void testRemove() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));

        list.add(10);
        assertEquals(10, list.remove(0));
        assertEquals(0, list.size());

        list.add(8);
        list.add(5);
        assertEquals(8, list.remove(0));
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));

        list.add(10);
        list.add(15);
        assertEquals(15, list.remove(2));
        assertEquals(2, list.size());
        assertEquals(List.of(5, 10), list);

        list.add(20);
        assertEquals(10, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(List.of(5, 20), list);
    }

    @Test
    void testClear() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        list.add(10);
        list.add(8);
        list.clear();
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    @Test
    void testAddBefore() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(10);
        list.add(8);
        list.add(10);
        list.addBefore(5, 10);
        assertEquals(5, list.get(0));
    }

    @Test
    void testRemoveFirstLast() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        list.add(10);
        list.add(8);
        list.add(5);
        assertEquals(List.of(5, 10, 8, 5), list);

        list.removeFirst();
        assertEquals(List.of(10, 8, 5), list);

        list.add(7);
        list.removeLast();
        assertEquals(List.of(10, 8, 5), list);

        list.removeFirst();
        assertEquals(List.of(8, 5), list);

        list.removeFirst();
        assertEquals(List.of(5), list);

        list.removeLast();
        assertEquals(List.of(), list);
    }

    @Test
    void testSubList() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        list.add(10);
        list.add(8);
        list.add(6);
        list.add(13);
        list.add(20);

        assertArrayEquals(new int[]{}, list.subList(0, 0).toArray());
        assertArrayEquals(new int[]{}, list.subList(6, 6).toArray());
        assertArrayEquals(list.toArray(), list.subList(0, 6).toArray());
        assertArrayEquals(new int[]{10, 8, 6, 13}, list.subList(1, 5).toArray());

    }

}
