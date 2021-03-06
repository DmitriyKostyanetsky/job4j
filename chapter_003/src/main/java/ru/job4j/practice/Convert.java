package ru.job4j.practice;

/**Лишние пробелы. Большая часть библиотеки не используется, поэтому можно импортировать отдельную часть*/
import java.util.*;

public class Convert {

    /**Пустой конструктор не нужен. default'ный создается по умолчанию*/
    public Convert(){

    }

    //Converts array to list
    /**Для перебора листа практичнее использовать цикл foreach*/
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }
    /**Пробел*/

    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);
        /**Пробел*/

        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
}