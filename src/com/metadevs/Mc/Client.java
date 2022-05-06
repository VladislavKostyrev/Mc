package com.metadevs.Mc;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    static ArrayList<Integer> intArray = new ArrayList<Integer>();
    static String answer = "NO";

    public static void main(String[] args) {
        inputIntArray();
        isIntArrayIncludeNegativeNumber(answer);
    }

    public static void inputIntArray() {
        for (int i = 0; i != -9999; i = new Scanner(System.in).nextInt()) {
            intArray.add(i);
        }
    }

    public static void isIntArrayIncludeNegativeNumber(String answer) {
        for (int i = 1; i < intArray.size(); i++) {
            if (intArray.get(i) <= 0 ) {
                break;
            }
            answer = "YES";
        }
        System.out.println(answer);
    }
}