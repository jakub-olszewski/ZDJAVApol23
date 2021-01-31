package pl.sdacademy.solve.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.sdacademy.zdjavapol23.Calculator;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author : Jakub Olszewski [http://github.com/jakub-olszewski]
 * @project : zdjavapol23
 * @since : 31.01.2021
 **/
public class MockitoAnnotationMockTest {

    /**
     * Zamokowana lista / atrapa listy
     * Wymagane init mock z before
     */
    @Mock
    List<String> mockedList;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);// this-testowana klasa czyli ta klasa
    }

    /**
     * Test nie zamockowanej listy
     */
    @Test
    public void whenNotUseMockAnnotationMockInject(){

        // given
        List<String> notMockedList = new ArrayList();

        // when
        notMockedList.add("one");
        notMockedList.add("two");
        notMockedList.add("three");
        // ... i tak jeszcze 2020 razy ???

        // then
        assertEquals(notMockedList.size(),3);
        assertTrue(notMockedList.get(0).equals("one"));
    }

    @Test
    public void whenUseMockAnnotatnionMockInject2(){

        // when
        mockedList.add("one");

        // działanie atrapy
        // kiedy mockedList zapytamy o size() wtedy return 2020
        when(mockedList.size()).thenReturn(2020);

        // then
        assertEquals(2020,mockedList.size());
        // weryfikacja
        verify(mockedList).add("one");
        //verify(mockedList).add("two");// nie zostało wywołane add("two")

    }

    /**
     * Mock bez użycia adnotacji
     */
    @Test
    public void whenNoUseMockAnnotationTest(){

        // given
        List<String> mockedListInMethod = mock(ArrayList.class);// równoznaczne jak użycie @Mock

        // when
        when(mockedListInMethod.size()).thenReturn(2020);

        // then
        assertEquals(mockedListInMethod.size(),2020);
    }

    @Test
    public void calculatorAddMockitoTest(){

        // given
        Calculator calc = mock(Calculator.class);

        // when
        calc.add(1,2);
        when(calc.display()).thenReturn("3");// implementacja zachowania atrapy kalkulatora

        // then
        assertEquals(calc.display(),"3");
        // weryfikacja czy kalkulator wykonał raz metodę add
        verify(calc,times(1)).add(anyInt(),anyInt());
        // weryfikacja czy nigdy nie została użyta metoda div
        verify(calc,never()).div(anyInt(),anyInt());
    }

    @Test
    public void calculatorSubMockitoTest(){
        // TODO Zadanie: Odejmowanie z użyciem mockito calculator
    }
}
