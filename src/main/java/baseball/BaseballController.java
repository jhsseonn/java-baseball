package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class BaseballController {

    BaseballOutput baseballOutput = new BaseballOutput();
    Scanner sc = new Scanner(System.in);

    public void startBaseball(){

        int strike = 0;
        int ball = 0;

        baseballOutput.printGameStart();
        String randNumStr = "";
        for (int i=0; i<3; i++){
            randNumStr+=Integer.toString(Randoms.pickNumberInRange(1, 9));
        }

        while (strike<3) {
            strike = 0;
            ball =0;

            baseballOutput.printInputNum();
            String inputNumber = sc.next();
//            System.out.println(randNumStr);

            if (inputNumber.length()!=3){
                throw new IllegalArgumentException();
            }

            for (int i=0; i<3; i++){
                int index = 0;
                String rn = Character.toString(randNumStr.charAt(i));
                if (inputNumber.contains(rn)){
                    index = inputNumber.indexOf(rn);
                } else continue;
                if (i==index){
                    strike+=1;
                } else {
                    ball+=1;
                }
            }

            baseballOutput.printResult(strike, ball);
        }

        if (strike>=3){
            baseballOutput.printGameOver();
            String startOrEnd = sc.next();
//            System.out.println(startOrEnd);
            if (startOrEnd.equals("1")){
                startBaseball();
            } else {
                baseballOutput.printGameEnd();
            }
        }
    }
}
