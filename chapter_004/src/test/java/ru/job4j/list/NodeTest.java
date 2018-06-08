package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeTest {

    private Node<Integer> node = new Node<>();
    private Node<Integer> first;
    private Node<Integer> two;
    private Node<Integer> third;
    private Node<Integer> four;

    @Before
    public void setUp() {
        first = new Node<>(1);
        two = new Node<>(2);
        third = new Node<>(3);
        four = new Node<>(4);
    }

    @Test
    public void whenCheckCycleThenTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        boolean result = node.hasCycle(first);
        assertThat(result, is(true));
    }

    @Test
    public void whenCheckCycleThenFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        boolean result = node.hasCycle(first);
        assertThat(result, is(false));
    }

    @Test
    public void whenCycleInMiddleThenTrue() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;
        boolean result = node.hasCycle(first);
        assertThat(result, is(true));
    }
}