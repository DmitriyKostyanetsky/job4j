package ru.job4j.task;

public class SameArrays {

    private char[] oneArr;
    private char[] twoArr;

    public SameArrays(String one, String two) {
        oneArr = one.toCharArray();
        twoArr = two.toCharArray();
    }

    public boolean isSameArrays() {
        boolean result = false;
        for (int i = 0; i < oneArr.length; i++) {
            for (int j = 0; j < twoArr.length; j++) {
                if (oneArr[i] == twoArr[i]) {
                    result = true;
                } else {
                    return false;
                }
            }
        }
        return result;
    }
}