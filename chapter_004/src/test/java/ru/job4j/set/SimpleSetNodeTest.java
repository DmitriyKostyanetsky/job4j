package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetNodeTest {

    private SimpleSetNode<Integer> simpleSet;

    @Before
    public void setUp() {
        simpleSet = new SimpleSetNode<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(2);
    }

    @Test
    public void whenAddEqualElementThenChangeOldElement() {
        assertThat(simpleSet.iterator().next(), is(3));
        assertThat(simpleSet.iterator().next(), is(2));
        assertThat(simpleSet.iterator().next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenLastNextThenException() {
        assertThat(simpleSet.iterator().next(), is(3));
        assertThat(simpleSet.iterator().next(), is(2));
        assertThat(simpleSet.iterator().next(), is(1));
        simpleSet.iterator().next();
    }
}