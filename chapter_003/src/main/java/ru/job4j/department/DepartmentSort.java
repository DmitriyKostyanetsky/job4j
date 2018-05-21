package ru.job4j.department;

import java.util.*;

public class DepartmentSort {
    private List<Departments> list = new ArrayList<>();

    /**
     * Метод конвертирует массив строк в лист
     * @param s массив строк
     */
    public void stringToList(String[] s) {
        for (String value : s) {
            list.add(new Departments(value));
        }
        addDep();
    }

    /**
     * Метод создает недостающие отделы
     */
    private void addDep() {
        List<Departments> newDep = new ArrayList<>();
        for (Departments value : list) {
            String[] s = value.getName().split("\\\\");
            String[] all = new String[s.length];
            for (int i = 0; i < s.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    if (j > 0) {
                        sb.append("\\");
                    }
                    sb.append(s[j]);
                }
                all[i] = sb.toString();
                newDep.add(new Departments(all[i]));
            }
        }
        addDepInList(newDep);
    }

    /**
     * Метод добавляет недостающие отделы в коллекцию
     * @param dep список отделов
     */
    private void addDepInList(List<Departments> dep) {
        for (Departments value : dep) {
            if (!list.contains(value) && !value.getName().equals("")) {
                list.add((value));
            }
        }
    }

    /**
     * Метод сортирует отделы по возрастанию или по убыванию в зависимости от значения number
     * @param number выбор сортировки
     * @return возвращает отсортированную коллекцию
     */
    public List<Departments> AscendingOrDescendingSort(int number) {
        list.sort(new Comparator<Departments>() {
            @Override
            public int compare(Departments o1, Departments o2) {
                int result = o1.getName().compareTo(o2.getName()) * number;
                if (result != 0) {
                    if (o1.getName().indexOf(o2.getName()) == 0) {
                        result = 1;
                    }
                    if (o2.getName().indexOf(o1.getName()) == 0) {
                        result = -1;
                    }
                }
                return result;
            }
        });
        return list;
    }
}