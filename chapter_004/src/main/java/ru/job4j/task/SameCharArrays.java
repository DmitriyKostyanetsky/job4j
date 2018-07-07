package ru.job4j.task;

public class SameCharArrays {

    private char[] oneArr;
    private char[] twoArr;

    public SameCharArrays(String one, String two) {
        oneArr = one.toCharArray();
        twoArr = two.toCharArray();
    }

    public boolean isSameArrays() {
        boolean coincidence = false;
        for (int i = 0; i < oneArr.length; i++) {
            for (int j = 0; j < twoArr.length; j++) {
                if (oneArr[i] == twoArr[j]) {
                    coincidence = true;
                    twoArr[j] = 0;
                    break;
                }
                if (j == twoArr.length - 1) {
                    return false;
                }
            }
        }
        return coincidence;
    }
}