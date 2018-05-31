package ru.job4j.generic;

public interface Store<T extends Base> {

    /**
     * Добавление элемента
     * @param model элемент
     */
    void add(T model);

    /**
     * Редактирование элемента
     * @param id id элемента
     * @param model элемент
     * @return возвращает true если элемент заменился, false если нет
     */
    boolean replace(String id, T model);

    /**
     * Удаление элемента
     * @param id id элемента
     * @return возвращает true если элемент удалился, false если нет
     */
    boolean delete(String id);

    /**
     * Нахождение элемента по id
     * @param id id элемента
     * @return возвращает найденный элемент
     */
    T findById(String id);
}