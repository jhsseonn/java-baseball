package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class BaseballController {

    BaseballOutput baseballOutput = new BaseballOutput();
    BaseballService baseballService = new BaseballService();

    public void startBaseball(){

        int strike = 0;

        baseballOutput.printGameStart();
        String randNumStr = baseballService.getRandNum();

        while (strike<3) {
            strike = baseballService.startGame(randNumStr);
        }

        if (strike==3){
            int restartOrNot = baseballService.restartGame();
            if (restartOrNot==1){
                startBaseball();
            }
        }
    }
}
