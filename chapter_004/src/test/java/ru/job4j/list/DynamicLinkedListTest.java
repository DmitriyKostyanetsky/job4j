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
    }

    @Test
    public void whenAddElementThenConcurrentModificationException() {
        list.add(2);
        assertThat(list.get(0), is(2));
        assertThat(list.get(1), is(1));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenGetElementThenTrue() {
        list.add(2);
        assertThat(list.iterator().next(), is(2));
        assertThat(list.iterator().next(), is(1));
    }
}