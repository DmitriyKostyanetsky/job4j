package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    private T[] array;
    private SimpleArray<T> models;

    public AbstractStore(T[] array, SimpleArray<T> models) {
        this.array = array;
        this.models = models;
    }

    public void add(T model) {
        models.add(model);
    }

    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getId().equals(id)) {
                array[i] = model;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i <= array.length; i++) {
            if (array[i].getId().equals(id)) {
                if (i == array.length) {
                    array[i] = null;
                }
                array[i] = array[i + 1];
                array[i + 1] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public T findById(String id) {
        T result = null;
        for (T value : array) {
            if (value != null && value.getId().equals(id)) {
                result = value;
                break;
            }
        }
        return result;
    }
}