package com.rohgibong.book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int packCount = -1;
        int sugar = Integer.parseInt(sc.nextLine());

        for(int i = sugar/5; i>=0; i--){
            if((sugar - (i*5)) % 3 == 0 ){
                packCount = i + ((sugar - (i*5)) / 3);
                break;
            }
        }

        System.out.println(sugar == 3 ? 1 : packCount);
    }
}