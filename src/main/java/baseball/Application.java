package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int randomNumber = Randoms.pickNumberInRange(1, 9);
        int inputNumber = sc.nextInt();


    }
}
