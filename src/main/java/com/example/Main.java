package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(" == 명언 앱 == ");
        Scanner scanner = new Scanner(System.in);
        List<WiseSaying> wiseSayings  = new ArrayList<>();
        int lastId = 0;


        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                WiseSaying wiseSaying = new WiseSaying();
                wiseSaying.id = ++lastId;
                System.out.print("명언 : ");
                wiseSaying.wiseSaying = scanner.nextLine();
                System.out.print("작가 : ");
                wiseSaying.author = scanner.nextLine();
                wiseSayings.add(wiseSaying);
                System.out.println(wiseSaying.id + "번 명언이 등록되었습니다.");
            }

            else if(command.equals("목록")){
                System.out.println("번호  /  작가  /  명언");
                System.out.println("----------------------");
                for (WiseSaying wiseSaying : wiseSayings) {
                    System.out.println(wiseSaying.id + " / " + wiseSaying.author + " / " + wiseSaying.wiseSaying);
                }
            }

            if (command.equals("종료")) {
                break;
            }
        }


    }
}
