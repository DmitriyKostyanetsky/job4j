package ru.job4j.list;

public class StackClass<T> {

    private DynamicLinkedList<T> list;

    public StackClass(DynamicLinkedList<T> list) {
        this.list = list;
    }

    /**
     * Возвращает значение и удаляет его из коллекции
     * @return возвращаемое значение
     */
    public T poll() {
        return list.removeFirst();
    }

    /**
     * Добавляет элемент на вершину стека
     * @param value добавляемое значение
     */
    public void push(T value) {
        list.add(value);
    }
}