package ru.job4j.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<V>{

    private static final int CONTAINER_SIZE = 5;
    private HashEntry<K, V>[] container;
    private int position = 0;
    private int iteratorPosition = 0;
    private int modCount = 0;

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return container.length > iteratorPosition;
            }

            @Override
            public V next() {
                checkModificationException();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (container[iteratorPosition] == null) {
                    iteratorPosition++;
                }
                return container[iteratorPosition++].value;
            }

            private void checkModificationException() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    /**
     * Класс используется для хранения элементов
     * @param <K> ключ элемента
     * @param <V> значение жлемента
     */
    static class HashEntry<K, V> {
        private K key;
        private V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            HashEntry entry = (HashEntry) obj;
            return  Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value);
        }
    }

    /**
     * @SuppressWarnings отключение предупреждения
     */
    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        container = new HashEntry[CONTAINER_SIZE];
    }

    /**
     * Метод вычисляет хэш-код элемента
     * @param key ключ элемента
     * @return возвращает хэш-код
     */
    private int hash(K key) {
        int result = 17;
        result = 31 * result + key.hashCode();
        return Math.abs(result % container.length);
    }

    /**
     * Метод предусматривает возможность роста хэш-таблицы при нехватке места для нового элемента
     * При увелечении таблицы индексы пересчитываются
     */
    private void checkArray() {
        if (position == container.length) {
            HashEntry<K, V>[] temp = container;
            container = Arrays.copyOf(container, container.length + 10);
            for (int i = 0; i < temp.length; i++) {
                int newHash = hash(temp[i].key);
                container[i] = null;
                container[newHash] = temp[i];
            }
        }
    }

    /**
     * Добавление элемента
     * @param key ключ элемента
     * @param value значение элемента
     * @return возвращает true если элемент добавился или перезаписался, false если элемент не добавлен
     */
    boolean insert(K key, V value) {
        checkArray();
        int hash = hash(key);
        HashEntry<K, V> temp = new HashEntry<>(key, value);
        if (container[hash] == null) {
            container[hash] = temp;
            position++;
            ++modCount;
            return true;
        }
        if (container[hash] != null && container[hash].equals(value)) {
            container[hash] = temp;
            return true;
        }
        return false;
    }

    /**
     * Возвращение элемента по ключу
     * @param key ключ элемента
     * @return возвращает значение по ключу
     */
    V get(K key){
        int hash = hash(key);
        return container[hash].value;
    }

    /**
     * Удаление элемента
     * @param key ключ элемента
     * @return возвращает true если элемент удален, false если нет
     */
    boolean delete(K key){
        int hash = hash(key);
        if (container[hash] != null) {
            container[hash] = null;
            ++modCount;
            return true;
        }
        return false;
    }
}