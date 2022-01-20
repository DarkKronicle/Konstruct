package io.github.darkkronicle.addons;

import io.github.darkkronicle.Konstruct.IntRange;
import io.github.darkkronicle.Konstruct.ParseContext;
import io.github.darkkronicle.Konstruct.Result;
import io.github.darkkronicle.Konstruct.functions.Function;
import io.github.darkkronicle.Konstruct.functions.NamedFunction;
import io.github.darkkronicle.Konstruct.nodes.Node;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.PrimitiveElement;

import java.util.List;

public class CalculatorFunction implements NamedFunction {

    /**
     * Elements to use within the {@link Expression}
     */
    private final PrimitiveElement[] elements;

    /**
     * Creates a calculator function. The {@link PrimitiveElement}'s are optional.
     * @param elements Elements to evaluate with expression
     */
    public CalculatorFunction(PrimitiveElement... elements) {
        this.elements = elements;
    }

    @Override
    public Result parse(ParseContext context, List<Node> input) {
        Result result = Function.parseArgument(context, input, 0);
        if (Function.shouldReturn(result)) return result;
        Expression e = new Expression(result.getContent(), elements);
        return Result.success(String.valueOf(e.calculate()));
    }

    @Override
    public IntRange getArgumentCount() {
        return IntRange.of(1);
    }

    @Override
    public String getName() {
        return "calc";
    }

}
