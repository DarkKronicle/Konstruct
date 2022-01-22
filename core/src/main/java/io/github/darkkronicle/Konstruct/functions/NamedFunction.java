package io.github.darkkronicle.Konstruct.functions;

import io.github.darkkronicle.Konstruct.parser.NodeProcessor;

/**
 * An extension to {@link Function} that includes a string to get the name of the function
 */
public interface NamedFunction extends Function {

    /**
     * Returns the name of the function that should be used for key values in {@link NodeProcessor}
     * @return Function name
     */
    String getName();

}
