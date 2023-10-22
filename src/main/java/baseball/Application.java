package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean game = true;


        // 먼저 랜덤 숫자 만들어야 됨, Randoms이용해서

        List computer = shuffleNumber();

        System.out.println("정보 : " + computer);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (game) {

            int strike = 0;
            int ball = 0;
            //숫자 입력 받기
            Scanner s = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 : ");

            int in = s.nextInt();
            int in2 = in;
            //예외 처리
            Set<Integer> exceptList = new HashSet<>();
            while(in2 > 0){
                exceptList.add(in2 % 10);
                in2 /= 10;
            }
            List<Integer> inputList = new ArrayList<>();
            if(in > 0 && in < 1000 && exceptList.size() == 3){
                while (in > 0) {
                    inputList.add(in % 10);
                    in /= 10;
                }
            }else{
                throw new IllegalArgumentException();
            }


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j && computer.get(i) == inputList.get(j)) {
                        strike += 1;
                    } else if (i != j && computer.get(i) == inputList.get(j)) {
                        ball += 1;
                    }
                }
            }

            if (strike > 0) {
                if (strike == 3) {
                    System.out.println(strike + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    Scanner input = new Scanner(System.in);
                    int choice = input.nextInt();
                    if(choice == 1){
                        computer = shuffleNumber();
                    } else if (choice == 2) {
                        game = false;
                    }
                } else if (ball > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            } else {
                if (ball > 0) {
                    System.out.println(ball + "볼");
                }
            }

        }


    }

    public static List shuffleNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}



