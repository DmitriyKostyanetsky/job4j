package ru.job4j.task;

public class SameCharArrays {

    private char[] oneArr;
    private char[] twoArr;

    public SameCharArrays(String one, String two) {
        oneArr = one.toCharArray();
        twoArr = two.toCharArray();
    }

    public boolean isSameArrays() {
        boolean result = false;
        for (int i = 0; i < oneArr.length;) {
            for (int j = 0; j < twoArr.length; j++) {
                if (oneArr[i] == twoArr[j]) {
                    result = true;
                } else {
                    return false;
                }
                i++;
            }
        }
        return result;
    }
}