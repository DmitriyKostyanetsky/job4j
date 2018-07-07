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
        String s1 = sort(oneArr);
        String s2 = sort(twoArr);
        if (s1.equals(s2)) {
            coincidence = true;
        }
        return coincidence;
    }

    private String sort(char[] arr) {
        String result = "";
        for (int i = 0; i + 1 < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                char temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
                i = 0;
            }
        }
        for (Character c : arr) {
            result += c.toString();
        }
        return result;
    }
}