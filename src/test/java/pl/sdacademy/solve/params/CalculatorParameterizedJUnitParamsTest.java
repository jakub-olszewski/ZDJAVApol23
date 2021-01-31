package pl.sdacademy.solve.params;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.sdacademy.solve.calculator.Calculator;
import pl.sdacademy.solve.calculator.CalculatorImpl;

import static org.junit.Assert.assertEquals;


@RunWith(JUnitParamsRunner.class)
public class CalculatorParameterizedJUnitParamsTest {

    /**
     * Test bez parametrów
     */
    @Test
    public void add1And2Test(){

        // given
        Calculator calc = new CalculatorImpl();

        // when
        calc.add(1,2);

        // then
        assertEquals("3", calc.display());

    }

    @Test
    // dane do testów
    @Parameters({"1,2,3","3,2,5","7,3,10","3,9,12","1,9,10"})
    public void addParametersTest(int numberA, int numberB, String expected){

        // given
        Calculator calc = new CalculatorImpl();

        // when
        calc.add(numberA,numberB);

        // then
        assertEquals(expected, calc.display());

    }

}
