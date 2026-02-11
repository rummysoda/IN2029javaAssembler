package parse;

import compile.ast.*;
import sbnf.ParseException;
import sbnf.lex.Lexer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/** Parse Calculon program and build its AST.  */
public class CalculonParser {

    /**
     * Path to an SBNF file containing the relevant token definitions.
     */
    public static final String SBNF_FILE = "data/Calculon.sbnf";

    private Lexer lex;
    /**
     * Initialise a new Calculon parser.
     */
    public CalculonParser() {
        lex = new Lexer(SBNF_FILE);
    }

    public Program parse(String sourcePath) throws IOException {
        lex.readFile(sourcePath);
        lex.next();
        Program prog = Program();
        if (!lex.tok().isType("EOF")) {
            throw new ParseException(lex.tok(), "EOF");
        }
        return prog;
    }

    /**
      Program -> BEGIN Stm* END
     */
    public Program Program() {
        List<Stm> body = new LinkedList<>();
        lex.eat("BEGIN");
        while (!lex.tok().isType("END")) {
            body.add(Stm());
        }
        lex.eat("END");
        return new Program(body);
    }


    /**
      Stm -> PRINTLN LBR Exp RBR SEMIC
     */
    private Stm Stm() {
        switch (lex.tok().type) {
            case "PRINTLN": {
                lex.next();
                lex.eat("LBR");
                Exp e = Exp();
                lex.eat("RBR");
                lex.eat("SEMIC");
                return new StmPrintln(e);
            }
            default:
                throw new ParseException(lex.tok(), "PRINTLN");
        }
    }

    /**
      Exp -> SimpleExp OperatorClause
     */
    private Exp Exp() {
        Exp e1 = SimpleExp();
        return OperatorClause(e1);
    }

    /**
      SimpleExp -> INTLIT
      SimpleExp -> LBR Exp RBR
     */
    private Exp SimpleExp() {
        switch (lex.tok().type) {
            case "INTLIT": {
                int n = Integer.parseInt(lex.tok().image);
                lex.next();
                return new ExpInt(n);
            }
            case "LBR": {
                lex.next();
                Exp e = Exp();
                lex.eat("RBR");
                return e;
            }
            default:
                throw new ParseException(lex.tok(), "INTLIT", "LBR");
        }
    }

    /**
      OperatorClause -> BINARY_OP SimpleExp
      OperatorClause ->
     */
    private Exp OperatorClause(Exp e) {
        switch (lex.tok().type) {
            case "BINARY_OP": {
                String operator = lex.tok().image;
                lex.next();
                return new ExpBinaryOp(operator, e, SimpleExp());
            }
            default:
                return e;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: parse.CalculonParser <source-file>");
            System.exit(1);
        }
        System.out.println("Lexing with token defs from file " + SBNF_FILE);
        parse.CalculonParser parser = new parse.CalculonParser();
        System.out.println("Parsing source file " + args[0]);
        Program p = parser.parse(args[0]);
        System.out.println("... parse succeeded.");
    }
}
