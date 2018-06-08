package ru.job4j.list;

public class Node<T> {
    private T value;
    public Node<T> next;

    public Node(){}

    public Node(T value) {
        this.value = value;
    }

    /**
     * Метод проверяет, содержит ли список замыкания
     * @param first первый узел
     * @return true если содержит, false если нет
     */
    boolean hasCycle(Node first) {
        boolean result = false;
        Node temp = first;
        Node middle = first.next;
        while(true) {
            temp = temp.next;
            middle = middle.next;
            if (middle.next == null) {
                break;
            }
            if (first.value.equals(temp.value) || temp.value.equals(middle.next.value)) {
                result = true;
                break;
            }
        }
        return result;
    }
}