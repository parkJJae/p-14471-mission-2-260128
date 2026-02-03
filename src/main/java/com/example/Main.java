package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(" == 명언 앱 == ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
            }

            if (command.equals("종료")) {
                break;
            }
        }


    }
}
