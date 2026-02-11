package compile.ast;

import compile.SymbolTable;

import java.util.Collections;
import java.util.List;

public class Program extends AST {

    public final List<Stm> body;

    /**
     * Initialise a new Program AST.
     * @param body the statements in the main body of the program
     */
    public Program(List<Stm> body) {
        this.body = Collections.unmodifiableList(body);
    }

    /**
     * Emit SSM assembly code for this program.
     */
    public void compile() {
        SymbolTable st = new SymbolTable(this);
        for(Stm stm: body) {
            stm.compile(st);
        }
        emit("halt");
    }
 
}
