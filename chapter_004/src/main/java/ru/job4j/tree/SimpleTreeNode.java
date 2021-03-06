package ru.job4j.tree;

import java.util.*;

public class SimpleTreeNode<E extends Comparable<E>> implements SimpleTree<E> {

    private final E value;
    private Node<E> root;
    private Node<E> children;
    private int modCount = 0;

    public SimpleTreeNode(final E value) {
        this.value = value;
        root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent()) {
            Node<E> newRoot = findBy(parent).get();
            Node<E> children = new Node<>(child);
            newRoot.add(children);
            this.children = children;
            ++modCount;
            return true;
        }
        return false;
    }

    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            for (Node<E> child : el.leaves()) {
                data.offer(child);
                if (data.size() > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<E> {
        int expectedModCount = modCount;
        Queue<Node<E>> queue = new LinkedList<>();

        private TreeIterator() {
            queue.offer(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }


        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            Node<E> temp = queue.poll();
            for (Node<E> child : temp.leaves()) {
                queue.offer(child);
            }
            return temp.getValue();
        }
    }
}