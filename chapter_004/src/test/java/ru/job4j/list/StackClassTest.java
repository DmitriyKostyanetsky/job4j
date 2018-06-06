package ru.job4j.list;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StackClassTest {

    private StackClass<Integer> stackClass;
    private DynamicLinkedList<Integer> list = new DynamicLinkedList<>();

    @Before
    public void setUp() {
        stackClass = new StackClass<>(list);
        stackClass.push(1);
        stackClass.push(2);
    }

    @Test
    public void whenPushThenAddElement() {
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenPollThenResult2() {
        assertThat(stackClass.poll(), is(2));
        assertThat(list.get(0), is(1));
    }
}