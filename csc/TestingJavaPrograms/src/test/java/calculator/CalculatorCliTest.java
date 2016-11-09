package calculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.StringReader;

import static org.junit.Assert.*;

public class CalculatorCliTest {

    private Calculator calculatorMock;
    private CalculatorCli calculatorCli;

    @Before
    public void setUp(){
        calculatorMock = Mockito.mock(Calculator.class);
        calculatorCli = new CalculatorCli(calculatorMock);
    }

    @Test
    public void emptyExpressionsMustBeSkipped() throws Exception {
        calculatorCli.runInteractiveSession(new StringReader(";\n   ;;;\t\n;"));
        Mockito.verifyZeroInteractions(calculatorMock);
    }

    @Test
    public void eachExpressionSeparatedBysSemicolonMustBeEvaluated() {
        calculatorCli.runInteractiveSession(new StringReader("1;2;3"));
        Mockito.verify(calculatorMock).calculate("1");
        Mockito.verify(calculatorMock).calculate("2");
        Mockito.verify(calculatorMock).calculate("3");
        Mockito.verifyZeroInteractions(calculatorMock);
    }

    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluatedSecondEdition(){
        Mockito.when(calculatorMock.calculate("1")).thenReturn(1d);
        Mockito.when(calculatorMock.calculate("2")).thenReturn(2d);
        Mockito.when(calculatorMock.calculate("3")).thenReturn(3d);

        calculatorCli.runInteractiveSession(new StringReader("1;2;3"));
        Mockito.verify(calculatorMock).calculate("1");
        Mockito.verify(calculatorMock).calculate("2");
        Mockito.verify(calculatorMock).calculate("3");
        Mockito.verifyZeroInteractions(calculatorMock);
    }
}