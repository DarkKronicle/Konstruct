package io.github.darkkronicle.Konstruct;

import io.github.darkkronicle.Konstruct.functions.Function;
import io.github.darkkronicle.Konstruct.functions.Variable;
import io.github.darkkronicle.Konstruct.nodes.Node;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


/**
 * Processes {@link Node}'s that have been built. This class is meant to store functions and variables
 * to be referenced at a later time. This class automatically sends in {@link ParseContext} to the
 * parsed {@link Node}'s.
 */
public class NodeProcessor {

    /**
     * All stored {@link Function}'s in this class
     */
    @Getter
    private Map<String, Function> functions;

    /**
     * All stored {@link Variable}'s in this class
     */
    @Getter
    private Map<String, Variable> variables;

    /**
     * Constructs an empty {@link NodeProcessor} with zero functions or variables.
     */
    public NodeProcessor() {
        this(new HashMap<>(), new HashMap<>());
    }

    /**
     * Constructs a {@link NodeProcessor} with functions and variables.
     * @param functions {@link Map} of {@link Function} with the key being the name and value being the function
     * @param variables {@link Map} of {@link Variable} with key being the name and value being the value of the variable
     */
    public NodeProcessor(Map<String, Function> functions, Map<String, Variable> variables) {
        this.functions = functions;
        this.variables = variables;
    }

    /**
     * Adds a {@link Variable} to the class
     * @param key Key to reference this variable
     * @param value {@link Variable} to get value
     */
    public void addVariable(String key, Variable value) {
        variables.put(key, value);
    }

    /**
     * Adds a {@link Variable} to the class constructed out of just a string
     * @param key Key of the variable
     * @param value Value of the variable
     */
    public void addVariable(String key, String value) {
        addVariable(key, Variable.of(value));
    }

    /**
     * Adds a {@link Function} to the class
     * @param key Key to reference this function
     * @param function {@link Function} to execute on call
     */
    public void addFunction(String key, Function function) {
        functions.put(key, function);
    }

    /**
     * Adds all functions and variables from a different {@link NodeProcessor}
     * @param processor {@link NodeProcessor} to copy from
     */
    public void addAll(NodeProcessor processor) {
        functions.putAll(processor.functions);
        variables.putAll(processor.variables);
    }

    /**
     * Creates a {@link ParseContext} with the current settings of this class
     * @return Constructed {@link ParseContext}
     */
    public ParseContext createContext() {
        return new ParseContext(functions, variables);
    }

    /**
     * Parses a {@link Node} with the current functions and variables
     * @param node {@link Node} to parse
     * @return The parsed string
     */
    public String parse(Node node) {
        return node.parse(createContext());
    }

}
