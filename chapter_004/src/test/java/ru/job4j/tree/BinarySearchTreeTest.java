package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(5);
        tree.add(8);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(9);
        tree.add(1);
        tree.add(7);
        it = tree.iterator();
    }

    @Test(expected = NoSuchElementException.class)
    public void checkNext() {
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(6));
    }

    @Test
    public void checkAdd() {
        tree = new BinarySearchTree<>();
        tree.addWithoutRecurse(6);
        tree.addWithoutRecurse(5);
        tree.addWithoutRecurse(8);
        tree.addWithoutRecurse(4);
        tree.addWithoutRecurse(2);
        tree.addWithoutRecurse(3);
        tree.addWithoutRecurse(9);
        tree.addWithoutRecurse(1);
        tree.addWithoutRecurse(7);
    }
}