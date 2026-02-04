package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public void run() {
        System.out.println(" == 명언 앱 == ");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                actionWrite();
            }

            else if(command.equals("목록")){
                actionList();
            }

            else if (command.equals("종료")) {
                break;
            }

            else if (command.startsWith("삭제?id=")){
                actionDelete(command);
            }
            else if (command.startsWith("수정?id=")){
                actionUpdate(command);
            }
        }
    }

    private void actionUpdate(String command){
        String parts = command.split("=")[1];
        int targetId = Integer.parseInt(parts);
        WiseSaying ws = findById(targetId);

        if(ws == null){
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("멍언(기존)" + ws.getContent());
        System.out.print("명언 : ");
        String newcontent = scanner.nextLine();

        System.out.println("작가(기존)" + ws.getAuthor());
        System.out.print("작가 : ");
        String newauthor = scanner.nextLine();

        Update(ws, newcontent, newauthor);
    }

    private void Update(WiseSaying ws, String newcontent, String newauthor) {
        ws.setContent(newcontent);
        ws.setAuthor(newauthor);
    }

    private WiseSaying findById(int targetId) {
        int index = findIndexById(targetId);

        if(index == -1){
            return null;
        }

        return wiseSayings.get(index);
    }

    // id로 index 찾는 메서드 (반복문은 여기 한 곳만 존재)
    private int findIndexById(int targetId) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying ws = wiseSayings.get(i);
            if (ws.getId() == targetId) {
                return i;
            }
        }
        return -1;
    }

    private void actionDelete(String command) {
        String parts = command.split("=")[1]; // =을 만나면 짤라라. = 을 기준으로 짤라서 parts[0] -> 삭제?id , parts[1] -> 문자열
        int targetId = Integer.parseInt(parts); // 문자열이기 때문에 Int로 바꿔줘야함
        boolean found = delete(targetId);

        if (!found) {
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println(targetId + "번 명언이 삭제되었습니다.");
    }

    private boolean delete(int targetId) {
        int index = findIndexById(targetId);

        if (index == -1) {
            return false;
        }

        wiseSayings.remove(index);
        return true;
    }

    private void actionList() {
        System.out.println("번호  /  작가  /  명언");
        System.out.println("----------------------");
        for(WiseSaying wiseSaying : wiseSayings) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    private void actionWrite() { // 고객 응대
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying saved = write(content, author);
        System.out.println(saved.getId() + "번 명언이 등록되었습니다.");
    }

    private WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }
}
