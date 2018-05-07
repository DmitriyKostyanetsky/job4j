package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Класс Tracker, используемый, как хранилище для заявок.
 */
public class Tracker {

    private final ArrayList<Item> items = new ArrayList<>();
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище.
     * @param item новая заявка.
     * @return возвращает новую заявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        position++;
        return item;
    }

    /**
     * Метод, редактирующий заявку по id.
     * @param id входящий id.
     * @param item новая заявка.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                item.setId(items.get(i).getId());
                items.set(i, item);
                break;
            }
        }
    }

    /**
     * Метод, удаляющий заявку по id.
     * @param id входящий id.
     */
    public void delete(String id) {
        for (Item value : items) {
            if (value.getId().equals(id)) {
                items.remove(value);
                break;
            }
        }
        position--;
    }

    /**
     * Метод получающий список заявок по имени.
     * @param key входящее имя.
     * @return возвращает список с именами.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item value : items) {
            if (value.getName().equals(key)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Метод получающий заявку по id.
     * @param id входящий id.
     * @return возвращает заявку по id.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                result = items.get(i);
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
    public ArrayList<Item> getAll() {
        ArrayList<Item> result = new ArrayList<>(position);
        for (int i = 0; i != position ; i++) {
            result.addAll(items);
        }
        return result;
    }
}