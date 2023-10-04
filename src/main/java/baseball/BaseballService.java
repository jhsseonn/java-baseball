package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class BaseballService {

    BaseballOutput baseballOutput = new BaseballOutput();
    Scanner sc = new Scanner(System.in);

    public String getRandNum(){
        String randNumStr = "";
        for (int i=0; i<3; i++){
            randNumStr+=Integer.toString(Randoms.pickNumberInRange(1, 9));
        }
        return randNumStr;
    }

    public int getStrike(String randNumStr, String inputNumber, int strike){
        for (int i=0; i<3; i++){
            int index = 0;
            String rn = Character.toString(randNumStr.charAt(i));
            if (inputNumber.contains(rn)){
                index = inputNumber.indexOf(rn);
            } else continue;
            if (i==index){
                strike+=1;
            }
        }
        return strike;
    }

    public int getBall(String randNumStr, String inputNumber, int ball) {
        for (int i=0; i<3; i++){
            int index = 0;
            String rn = Character.toString(randNumStr.charAt(i));
            if (inputNumber.contains(rn)){
                index = inputNumber.indexOf(rn);
            } else continue;
            if (i!=index){
                ball+=1;
            }
        }
        return ball;
    }

    public int startGame(String randNumStr) {
        int strike = 0;
        int ball =0;

        baseballOutput.printInputNum();
        String inputNumber = sc.next();

        if (inputNumber.length()!=3){
            throw new IllegalArgumentException();
        }

        strike = getStrike(randNumStr, inputNumber, strike);
        ball = getBall(randNumStr, inputNumber, ball);

        baseballOutput.printResult(strike, ball);

        return strike;
    }
}
