package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        for (int i = 0; i < o1.length() && i < o2.length(); i++) {
            if (o1.charAt(i) == o2.charAt(i)) {
                continue;
            }
            if (o1.charAt(i) != o2.charAt(i)) {
                return o1.charAt(i) - o2.charAt(i);
            }
        }
        if (o2.length() > o1.length() || o2.length() < o1.length()) {
            result = (o2.length() > o1.length() ? o1.length() - o2.length() : o2.length() - o1.length());
        }
        return result;
    }
}