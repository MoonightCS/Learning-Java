package calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.nio.DoubleBuffer;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(String expression) {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            return ((Number) scriptEngine.eval(expression)).doubleValue();
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Failed to evaluate expression");
        }
    }

}
