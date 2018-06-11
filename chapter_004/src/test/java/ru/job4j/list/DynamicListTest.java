package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DynamicListTest {

    private DynamicList<Integer> list;

    @Before
    public void setUp() {
        list = new DynamicList<>(new Integer[2]);
        list.add(3);
        list.add(1);
    }

    @Test
    public void whenAddElementThenException() {
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(1));
        list.add(9);
    }

    @Test
    public void whenAddElementThenOkAdd() {
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(1));
    }

    @Test
    public void whenGetElementThenTrue() {
        assertThat(list.get(1), is(1));
    }

    @Test
    public void checkNext() {
        assertThat(list.iterator().next(), is(3));
        assertThat(list.iterator().next(), is(1));
    }
}