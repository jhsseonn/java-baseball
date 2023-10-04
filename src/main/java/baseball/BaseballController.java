package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class BaseballController {

    BaseballOutput baseballOutput = new BaseballOutput();
    BaseballService baseballService = new BaseballService();
    Scanner sc = new Scanner(System.in);

    public void startBaseball(){

        int strike = 0;

        baseballOutput.printGameStart();

        while (strike<3) {
            strike = baseballService.startGame(baseballService.getRandNum());
        }

        if (strike==3){
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
