package handbuilt;

import compile.ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Source code:
begin
  int x;

  x = 3;
  while (x)
  {
      println(x);
      x = x - 1;
  }
  while (x < 3)
  {
      println(x);
      x = x + 1;
  }
end
 */

public class Ex3b {

    public static void main(String[] args) throws IOException {
        List<VarDecl> decls = new ArrayList<>();
        // To be completed

        List<Stm> stms = new ArrayList<>();
        // To be completed

        Program program = new Program(decls, stms);

        program.compile();
        AST.write(Paths.get("Ex3b.ssma"));
    }
}
