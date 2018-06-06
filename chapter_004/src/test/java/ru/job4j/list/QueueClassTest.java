package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QueueClassTest {

    private QueueClass<Integer> queueClass;
    private DynamicLinkedList<Integer> list = new DynamicLinkedList<>();

    @Before
    public void setUp() {
        queueClass = new QueueClass<>(list);
        queueClass.push(1);
        queueClass.push(2);
    }

    @Test
    public void whenPushThenAddElement() {
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenPollThenResult2() {
        assertThat(queueClass.poll(), is(1));
        assertThat(list.get(0), is(2));
    }
}