package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class BaseballService {

    BaseballOutput baseballOutput = new BaseballOutput();

    BaseballException baseballException = new BaseballException();

    public String getRandNum(){
        String randNumStr = "";
        for (int i=0; i<3; i++){
            randNumStr+=Integer.toString(Randoms.pickNumberInRange(1, 9));
        }
        return randNumStr;
    }

    public int countStrikeOrBall(StrikeOrBall strikeOrBall, String randNumStr, String inputNumber){
        int count = 0;
        for (int i=0; i<3; i++){
            int index = 0;
            String rn = Character.toString(randNumStr.charAt(i));
            if (inputNumber.contains(rn)){
                index = inputNumber.indexOf(rn);
            } else continue;
            count += addStrikeOrBall(strikeOrBall, i, index);
        }
        return count;
    }

    public int addStrikeOrBall(StrikeOrBall strikeOrBall, int i, int index){
        if (strikeOrBall==StrikeOrBall.STRIKE){
            if (i==index) return 1;
        } else {
            if (i!=index) return 1;
        }
        return 0;
    }

    public int getStrike(String randNumStr, String inputNumber){
        return countStrikeOrBall(StrikeOrBall.STRIKE, randNumStr, inputNumber);
    }

    public int getBall(String randNumStr, String inputNumber) {
        return countStrikeOrBall(StrikeOrBall.BALL, randNumStr, inputNumber);
    }

    public int startGame(String randNumStr) {

        baseballOutput.printInputNum();
        String inputNumber = Console.readLine();

        baseballException.isValidInput(inputNumber);

        int strike = getStrike(randNumStr, inputNumber);
        int ball = getBall(randNumStr, inputNumber);

        baseballOutput.printResult(strike, ball);

        return strike;
    }

    public int restartGame(){
        int restart = 0;
        baseballOutput.printGameOver();
        String startOrEnd = Console.readLine();
//            System.out.println(startOrEnd);
        if (startOrEnd.equals("1")){
            restart = 1;
        } else if (startOrEnd.equals("2")){
            baseballOutput.printGameEnd();
        } else {
            baseballException.isValidRestart(startOrEnd);
        }
        return restart;
    }
}
