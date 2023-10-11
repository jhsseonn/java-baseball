package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class BaseballService {

    BaseballOutput baseballOutput = new BaseballOutput();
    BaseballController baseballController = new BaseballController();

    BaseballException baseballException = new BaseballException();

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

    public int countStrike(String randNumStr, String inputNumber, int ball){
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
        String inputNumber = Console.readLine();

        baseballException.isIllegalArgument(inputNumber);

        strike = getStrike(randNumStr, inputNumber, strike);
        ball = getBall(randNumStr, inputNumber, ball);

        baseballOutput.printResult(strike, ball);

        return strike;
    }

    public void restartGame(){
        baseballOutput.printGameOver();
        String startOrEnd = Console.readLine();
//            System.out.println(startOrEnd);
        if (startOrEnd.equals("1")){
            baseballController.startBaseball();
        } else {
            baseballOutput.printGameEnd();
        }
    }
}
