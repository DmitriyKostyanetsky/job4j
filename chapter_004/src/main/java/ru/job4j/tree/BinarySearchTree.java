package ru.job4j.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    private Node<E> root;
    private int count = 0;

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
        return new TreeIterator(root);
    }

    private class TreeIterator implements Iterator<E> {
        private Node<E> next;
        private Node<E> temp;
        private boolean countRight = false;
        private boolean over = false;

        private TreeIterator(Node<E> root) {
            next = root;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        /**
         * Метод находит "родителя" самого левого узла
         * @param node узел
         * @return возвращает левый узел
         */
        private Node<E> findLeftmost(Node<E> node) {
            if (!isTempOver()) {
                return temp;
            }
            if (node.left == null) {
                return node;
            }
            while(node.left.left != null) {
                node = node.left;
            }
            return node;
        }

        /**
         * Метод проверяет проверены ли все все элементы узла
         * @return true если проверены, false если нет
         */
        private boolean isTempOver() {
            if (temp != null) {
                if (temp.left != null || temp.right != null) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Метод находит "родителя" самого правого узла
         * @param node узел
         * @return возвращает правый узел
         */
        private Node<E> findRightmost(Node<E> node) {
            if (!isTempOver()) {
                return temp;
            }
            if (node.right == null) {
                return node;
            }
            while(node.right.right != null) {
                node = node.right;
            }
            return node;
        }

        /**
         * Метод проверяет, что левый узел пройден и можно перейти к правому
         */
        private void checkLeftNodeOver() {
            if (next.left.equals(temp)) {
                countRight = true;
            }
        }

        /**
         * Метод проверяет, что правый узел пройден
         */
        private void checkRightNodeOver() {
            if (next.right.equals(temp)) {
                over = true;
            }
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result;
            if (!countRight) {
                temp = findLeftmost(next.left);
            }
            if (countRight) {
                temp = findRightmost(next.right);
            }
            if (temp.left != null) {
                result = temp.left.value;
                temp.left = null;
                return result;
            }
            if (temp.right != null) {
                result = temp.right.value;
                temp.right = null;
                return result;
            }
            if (over) {
                result = next.value;
                next = null;
                return result;
            }
            checkLeftNodeOver();
            checkRightNodeOver();
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