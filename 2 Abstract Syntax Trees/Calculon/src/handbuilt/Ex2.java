package handbuilt;

import compile.ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Source code:
begin
   int y;

   y = 0 - 4;
   println(3 * (y + 7));
end
 */

public class Ex2 {

    public static void main(String[] args) throws IOException {
        List<VarDecl> decls = new ArrayList<>();
        // to be completed

        List<Stm> stms = new ArrayList<>();
        // to be completed

        Program program = new Program(decls, stms);

        program.compile();
        AST.write(Paths.get("Ex2.ssma"));
    }
}