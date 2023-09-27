package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");

        int randomNumber = Randoms.pickNumberInRange(1, 9);
        System.out.println("숫자를 입력해주세요 : ");
        int inputNumber = sc.nextInt();





    }
}
