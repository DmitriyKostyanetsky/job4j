package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleHashSetTest {

    private SimpleHashSet<Integer> simpleSet;

    @Before
    public void setUp() {
        simpleSet = new SimpleHashSet<>(new Integer[3]);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
    }

    @Test
    public void whenAddElementThenTrue() {
        assertThat(simpleSet.add(4), is(true));
    }

    @Test
    public void whenAddElementThenFalse() {
        assertThat(simpleSet.add(2), is(false));
    }

    @Test
    public void whenCheckContainsElementThenTrue() {
        assertThat(simpleSet.contains(3), is(true));
    }

    @Test
    public void whenCheckContainsElementThenFalse() {
        assertThat(simpleSet.contains(6), is(false));
    }

    @Test
    public void whenCheckRemoveElementThenTrue() {
        assertThat(simpleSet.remove(2), is(true));
    }

    @Test
    public void whenCheckRemoveElementThenFalse() {
        assertThat(simpleSet.remove(5), is(false));
    }
}