package handbuilt;

import compile.ast.AST;
import compile.ast.Program;
import compile.ast.Stm;
import compile.ast.VarDecl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Source code:
begin
  int x;

  x = 3;
  // Note: there are no Booleans in Calculon
  // 0 is false, any other number is true
  while (x)
  {
      println(x);
      x = x - 1;
  }
end
 */

public class Ex3a {

    public static void main(String[] args) throws IOException {
        List<VarDecl> decls = new ArrayList<>();
        // To be completed

        List<Stm> stms = new ArrayList<>();
        // To be completed

        Program program = new Program(decls, stms);

        program.compile();
        AST.write(Paths.get("Ex3a.ssma"));
    }
}
