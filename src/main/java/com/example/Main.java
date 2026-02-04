package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(" == 명언 앱 == ");
        Scanner scanner = new Scanner(System.in);
        List<WiseSaying> wiseSayings = new ArrayList<>();
        int lastId = 0;

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                WiseSaying wiseSaying = new WiseSaying();
                wiseSaying.id = ++lastId;
                System.out.print("명언 : ");
                wiseSaying.content = scanner.nextLine();
                System.out.print("작가 : ");
                wiseSaying.author = scanner.nextLine();
                wiseSayings.add(wiseSaying);
                System.out.println(wiseSaying.id + "번 명언이 등록되었습니다.");
            }

            else if(command.equals("목록")){
                System.out.println("번호  /  작가  /  명언");
                System.out.println("----------------------");
                for(WiseSaying wiseSaying : wiseSayings) {
                    System.out.println(wiseSaying.id + " / " + wiseSaying.author + " / " + wiseSaying.content);
                }
            }

            else if (command.equals("종료")) {
                break;
            }

            else if (command.startsWith("삭제?id=")){
                String[] parts = command.split("="); // =을 만나면 짤라라. = 을 기준으로 짤라서 parts[0] -> 삭제?id , parts[1] -> 문자열
                int targetId = Integer.parseInt(parts[1]); // 문자열이기 때문에 Int로 바꿔줘야함
                boolean found = false;
                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying ws = wiseSayings.get(i);
                    if(ws.id == targetId){
                        wiseSayings.remove(i);
                        System.out.println(targetId + "번 명언이 삭제되었습니다.");
                        found = true;
                        break;
                    }

                }
                if(!found){
                    System.out.println(targetId + "번 명언은 존재하지 않습니다.");
                }
            }
        }


    }
}
