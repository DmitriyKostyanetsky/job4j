package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DynamicLinkedListTest {

    private DynamicLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new DynamicLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddElementThenConcurrentModificationException() {
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(2));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenGetElementThenTrue() {
        list.add(2);
        assertThat(list.iterator().next(), is(2));
        assertThat(list.iterator().next(), is(1));
    }

    @Test
    public void whenDeleteElementThenDeleteFirst() {
        list.removeFirst();
        assertThat(list.get(0), is(2));
        assertThat(list.get(1), is(1));
    }

    @Test
    public void whenDeleteElementThenDeleteLast() {
        list.removeLast();
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(2));
    }
}