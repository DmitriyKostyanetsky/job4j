package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс Tracker, используемый, как хранилище для заявок.
 */
public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище.
     * @param item новая заявка.
     * @return возвращает новую заявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод, редактирующий заявку по id.
     * @param id входящий id.
     * @param item новая заявка.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
            }
        }
    }

    /**
     * Метод, удаляющий заявку по id.
     * @param id входящий id.
     */
    public void delete(String id) {
        Item[] newItem = items;
        for (int index = 0; index <= newItem.length; index++) {
            System.arraycopy(newItem, 0, items, 0, index);
            String currentId = newItem[index].getId();
            if (id.equals(currentId)) {
                System.arraycopy(newItem, index + 1, items, index, position - index);
                break;
            }
        }
    }

    /**
     * Метод получающий список заявок по имени.
     * @param key входящее имя.
     * @return возвращает список с именами.
     */
    public Item[] findByName(String key) {
        int lengthResult = 0;
        Item[] result = new Item[position];
        for (int i = 0; i < result.length; i++) {
            if (items[i].getName().equals(key)) {
                result[lengthResult] = items[i];
                lengthResult++;
                continue;
            }
        }
        Arrays.copyOf(result, lengthResult);
        return result;
    }

    /**
     * Метод получающий заявку по id.
     * @param id входящий id.
     * @return возвращает заявку по id.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод возвращающий список объектов.
     * @return список объектов.
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int i = 0; i != position; i++) {
            result[i] = items[i];
        }
        return result;
    }
}
