package handbuilt;

import compile.ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Source code:
begin
   int size;

   size = 3 * 2;
   println(1 + size);
end
 */

public class Ex1 {

    public static void main(String[] args) throws IOException {
        List<VarDecl> decls = new ArrayList<>();
        // to be completed

        List<Stm> stms = new ArrayList<>();
        // to be completed

        Program program = new Program(decls, stms);

        program.compile();
        AST.write(Paths.get("Ex1.ssma"));
    }
}
