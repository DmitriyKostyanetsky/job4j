package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        SimpleTreeNode<Integer> tree = new SimpleTreeNode<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        SimpleTreeNode<Integer> tree = new SimpleTreeNode<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false)
        );
    }

    @Test
    public void checkNext() {
        SimpleTreeNode<Integer> tree = new SimpleTreeNode<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
    }

    @Test
    public void whenTreeIsBinaryThenTrue() {
        SimpleTreeNode<Integer> tree = new SimpleTreeNode<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenTreeIsNotBinaryThenFalse() {
        SimpleTreeNode<Integer> tree = new SimpleTreeNode<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.isBinary(), is(false));
    }
}