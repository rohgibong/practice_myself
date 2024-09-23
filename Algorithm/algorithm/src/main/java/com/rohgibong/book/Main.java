package com.rohgibong.book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int finalRollCount = 1;
        Scanner scanner = new Scanner(System.in);

        String roomNumber = scanner.nextLine();
        String numbers[] = roomNumber.split("");

        for(int count = 1; count < numbers.length; count++){
            int newRollCount = 1;
            if(numbers[count-1].equals("6") || numbers[count-1].equals("9")){
                int sixNineCount = 0;
                for(int i = count; i < numbers.length; i++){
                    if(numbers[i].equals("6") || numbers[i].equals("9")){
                        sixNineCount++;
                    }
                    if(sixNineCount == 2){
                        newRollCount++;
                        sixNineCount = 0;
                    }
                }
            } else {
                for(int i = count; i < numbers.length; i++){
                    if(numbers[i].equals(numbers[count-1])){
                        newRollCount++;
                    }
                }
            }
            if(newRollCount > finalRollCount){
                finalRollCount = newRollCount;
            }
        }

        System.out.println(finalRollCount);
    }
}