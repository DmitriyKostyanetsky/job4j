package ru.job4j.tree;

import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    private Node<E> root;
    private int count = 0;

    public void addWithoutRecurse(E e) {
        if (root == null) {
            root = new Node<>(e);
        } else {
            Node<E> temp = root;
            Node<E> child;
            while (true) {
                child = temp;
                if (temp.value.compareTo(e) >= 0) {
                    temp = temp.left;
                    if (temp == null) {
                        child.left = new Node<>(e);
                        break;
                    }
                }
                if (temp.value.compareTo(e) < 0) {
                    temp = temp.right;
                    if (temp == null) {
                        child.right = new Node<>(e);
                        break;
                    }
                }
            }
        }
    }

    public void add(E e) {
        if (root == null) {
            root = new Node<>(e);
        }
        else {
            addElement(root, e);
        }
        count++;
    }

    private void addElement(Node<E> head, E value) {
        if (head.value.compareTo(value) >= 0) {
            if (head.left == null) {
                head.left = new Node<>(value);
            } else {
                addElement(head.left, value);
            }
        }
        if (head.value.compareTo(value) < 0) {
            if (head.right == null) {
                head.right = new Node<>(value);
            } else {
                addElement(head.right, value);
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<E> {
        Queue<Node<E>> queue = new LinkedList<>();
        Node<E> nextLeft = root;
        Node<E> nextRight = root;

        private TreeIterator() {
            queue.offer(root);
            while (nextLeft.left != null) {
                nextLeft = nextLeft.left;
                queue.offer(nextLeft);
                if (nextLeft.right != null) {
                    queue.offer(nextLeft.right);
                }
            }
            while (nextRight.right != null) {
                nextRight = nextRight.right;
                queue.offer(nextRight);
                if (nextRight.left != null) {
                    queue.offer(nextRight.left);
                }
            }
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
            Node<E> temp = queue.poll();
            return temp.value;
        }
    }

    private static class Node<E extends Comparable<E>>  implements Comparable<Node<E>> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        private Node(E value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node<E> o) {
            return value.compareTo(o.value);
        }
    }
}