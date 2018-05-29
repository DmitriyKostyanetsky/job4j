package ru.job4j.generic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    private SimpleArray<Integer> simpleArray;
    private Integer[] result = new Integer[] {3, 5, 23, -2, 8, 0, 1, 7, -10};
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(result);
        it = simpleArray.iterator();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCheckLastNumberThenException () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(23));
        assertThat(it.next(), is(-2));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(-10));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenAddModelThenResult1() {
        simpleArray.add(1);
        assertThat(result[8], is(1));
    }

    @Test
    public void whenSetModelThenResult15() {
        simpleArray.set(6, 15);
        assertThat(result[6], is(15));
    }

    @Test
    public void whenDeleteModelThenResult1() {
        simpleArray.delete(2);
        assertThat(result[2], is(-2));
    }

    @Test
    public void whenGetModelThenResult0() {
        assertThat(simpleArray.get(5), is(0));
    }
}