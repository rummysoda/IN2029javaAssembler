package handbuilt;

import compile.ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Source code:
begin
   int x;
   int y;

   println 1;
   { println 2; println 3; }
end
 */

public class Ex0 {

    public static void main(String[] args) throws IOException {
        List<VarDecl> decls = new ArrayList<>();

        decls.add(new VarDecl("x"));
        decls.add(new VarDecl("y"));

        List<Stm> stms = new ArrayList<>();

        stms.add(new StmPrintln(new ExpInt(1)));

        List<Stm> blockStms = new ArrayList<>();
        blockStms.add(new StmPrintln(new ExpInt(2)));
        blockStms.add(new StmPrintln(new ExpInt(3)));
        stms.add(new StmBlock(blockStms));

        Program program = new Program(decls, stms);

        program.compile();
        AST.write(Paths.get("Ex0.ssma"));
    }
}
