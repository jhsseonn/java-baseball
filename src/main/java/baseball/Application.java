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

    }
}
