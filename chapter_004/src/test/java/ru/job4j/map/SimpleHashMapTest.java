package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {

    private SimpleHashMap<Integer, String> hashMap;

    @Before
    public void setUp() {
        hashMap = new SimpleHashMap<>();
        hashMap.insert(2, "two");
        hashMap.insert(1, "one");
        hashMap.insert(3, "third");
        hashMap.insert(2, "two");
        hashMap.insert(0, "zero");
    }

    @Test
    public void whenInsertThenTrue() {
        assertThat(hashMap.insert(9, "nine"), is(true));
        assertThat(hashMap.insert(4123, "BigNumber"), is(true));
    }

    @Test
    public void whenFindElementByTheKeyThenGetValue() {
        assertThat(hashMap.get(3), is("third"));
        assertThat(hashMap.get(1), is("one"));
        assertThat(hashMap.get(2), is("two"));
    }

    @Test
    public void whenDeleteElementThenTrue() {
        assertThat(hashMap.delete(3), is(true));
        assertThat(hashMap.delete(0), is(true));
    }

    @Test
    public void whenDeleteElementThenFalse() {
        assertThat(hashMap.delete(9), is(false));
    }

    @Test
    public void checkIterator() {
        assertThat(hashMap.iterator().next(), is("third"));
        assertThat(hashMap.iterator().next(), is("zero"));
        assertThat(hashMap.iterator().next(), is("one"));
        assertThat(hashMap.iterator().next(), is("two"));
    }
}