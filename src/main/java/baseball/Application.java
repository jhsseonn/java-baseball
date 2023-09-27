package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        int strike = 0;
        int ball = 0;

        Scanner sc = new Scanner(System.in);

        while (strike<3) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            int randomNumber = Randoms.pickNumberInRange(1, 9);
            System.out.println("숫자를 입력해주세요 : ");
            int inputNumber = sc.nextInt();

            String randNumStr = Integer.toString(randomNumber);
            String inputNumStr = Integer.toString(inputNumber);

            for (int i=0; i<3; i++){
                int index = 0;
                Character rn = randNumStr.charAt(i);
                if (inputNumStr.contains(rn.toString())){
                    index = inputNumStr.indexOf(rn);
                }
                if (i==index){
                    strike+=1;
                } else {
                    ball+=1;
                }
            }

            if (strike==0){
                System.out.println(ball+"볼");
            } else if (ball==0){
                System.out.println(strike+"스트라이크");
            } else {
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }
        }

        if (strike==3){
            System.out.println(strike+"스트라이크\n"+
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int startOrEnd = sc.nextInt();
            if (startOrEnd==1){
                strike=0;
            }
        }

    }
}
