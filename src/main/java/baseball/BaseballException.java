package baseball;

public class BaseballException {

    public void isValidInput(String inputNumber){
        if (inputNumber.length()!=3){
            throw new IllegalArgumentException();
        }
    }

    public void isValidRestart(String startOrEnd){
        if (!startOrEnd.equals("1") && !startOrEnd.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
