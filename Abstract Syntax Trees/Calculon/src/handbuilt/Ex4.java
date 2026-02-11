package handbuilt;

import compile.ast.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Source code:
begin
  int x;

  x = 20;
  if (x == 20) {
      x = x - 7;
      if (x < 13)
          println(x);
      else
          println(88);
  } else {}
end
 */

public class Ex4 {

    public static void main(String[] args) throws IOException {
        List<VarDecl> decls = new ArrayList<>();
        // To be completed

        List<Stm> stms = new ArrayList<>();
        // To be completed

        Program program = new Program(decls, stms);

        program.compile();
        AST.write(Paths.get("Ex4.ssma"));
    }
}
