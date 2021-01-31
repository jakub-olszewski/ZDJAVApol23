package pl.sdacademy.solve.calculator;

/**
 * Własny wyjątek dla kalkulatora
 **/
public class CalculatorException extends Exception {

    public CalculatorException(){
        super("Ogólny błąd kalkulatora");
    }

    public CalculatorException(String message) {
        super(message);
    }

    public static CalculatorException divide(){
        return new CalculatorException(CalculatorImpl.DIV_ERROR_MESSAGE);
    }
}
