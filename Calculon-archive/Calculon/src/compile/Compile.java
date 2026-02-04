package compile;

import compile.ast.*;
import parse.CalculonParser;
import sbnf.ParseException;
import sbnf.lex.Lexer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/** Compile a Calculon program.  */
public class Compile {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: compile.Compile <source-file>");
            System.exit(1);
        }
        Path sourcePath = Paths.get(args[0]);
        String assemblyFileName = sourcePath.getFileName().toString().replaceFirst("\\.[^.]*$", "") + ".ssma";
        Path parentPath = sourcePath.getParent();
        Path assemblyPath = Paths.get(assemblyFileName);
        if (parentPath != null) assemblyPath = parentPath.resolve(assemblyPath);
        CalculonParser parser = new CalculonParser();
        Program p = parser.parse(sourcePath.toString());
        p.compile();
        AST.write(assemblyPath);
        System.out.println("Assembly code written to: " + assemblyPath);
    }
}
