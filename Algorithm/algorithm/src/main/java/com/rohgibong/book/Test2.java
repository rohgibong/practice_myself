package com.rohgibong.book;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputNum = sc.nextLine();

        String numbers[] = inputNum.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        String result = num1 > num2 ? ">" : num1 < num2 ? "<" : "==";

        System.out.println(result);
    }
}
