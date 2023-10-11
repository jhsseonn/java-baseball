package baseball;

public class BaseballException {

    public void isIllegalArgument(String inputNumber){
        if (inputNumber.length()!=3){
            throw new IllegalArgumentException();
        }
    }
}
