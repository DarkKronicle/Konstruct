package io.github.darkkronicle.addons;

import io.github.darkkronicle.Konstruct.parser.IntRange;
import io.github.darkkronicle.Konstruct.parser.ParseContext;
import io.github.darkkronicle.Konstruct.parser.Result;
import io.github.darkkronicle.Konstruct.functions.Function;
import io.github.darkkronicle.Konstruct.functions.NamedFunction;
import io.github.darkkronicle.Konstruct.nodes.Node;
import io.github.darkkronicle.Konstruct.type.IntegerObject;

import java.util.List;

/**
 * A function to return the index of list.
 * <p>Example: <code>[if(0,this is one,this is two,this is three)]</code></p> will return <code>this is one</code>
 */
public class GetFunction implements NamedFunction {

    @Override
    public Result parse(ParseContext context, List<Node> input) {
        Result res = Function.parseArgument(context, input, 0);
        if (Function.shouldReturn(res)) return res;
        int val = IntegerObject.fromObject(res.getContent()).orElse(0);
        if (val < 0 || val >= input.size() - 1) {
            return Function.parseArgument(context, input, 1);
        }
        return Function.parseArgument(context, input, val + 1);
    }

    @Override
    public IntRange getArgumentCount() {
        return IntRange.greaterThanEqual(3);
    }

    @Override
    public String getName() {
        return "get";
    }

}
