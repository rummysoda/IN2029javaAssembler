package compile;

import compile.ast.Program;

import java.util.*;

public class SymbolTable {
    private int freshNameCounter;

    /**
     * Initialise a new symbol table.
     *
     * @param program the program
     */
    public SymbolTable(Program program) {
        this.freshNameCounter = 0;
    }

    /**
     * Transform an LPL26 identifier into an SSM label.
     *
     * @param id the LPL26 identifier
     * @return id prefixed with "$_"
     */
    public static String makeIdLabel(String id) {
        return "$_" + id;
    }

    /**
     * Each call to this method will return a fresh label which is
     * guaranteed not to clash with any label returned by makeIdLabel(x),
     * where x is any LPL26 identifier.
     *
     * @param tag a string to include as part of the generated name.
     * @return a fresh name which is prefixed with "$$_".
     */
    public String freshLabel(String tag) {
        return "$$_" + tag + "_" + (freshNameCounter++);
    }

}
