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
        sort(oneArr);
        sort(twoArr);
        for (int i = 0; i < oneArr.length; i++) {
            for (int j = 0; j < twoArr.length; j++) {
                if (oneArr[i] == twoArr[j]) {
                    coincidence = true;
                } else {
                    return false;
                }
                i++;
            }
        }
        return coincidence;
    }

    private void sort(char[] arr) {
        for (int i = 0; i + 1 < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                char temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
                i = 0;
            }
        }
    }
}