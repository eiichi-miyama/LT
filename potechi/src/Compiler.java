import java.io.IOException;
import java.util.List;

public class Compiler {
    public static void main(String args[]) throws IOException {
        String path = "./potechi/src/source.potechi";        
        String source = Util.readAll(path);

        List<String> tokens = Lexer.lexer(source);
        ParserComp.callPrint(tokens);

        Util.exec("as source.s -o source.o");

        //ldコマンドで、libcを動的リンク、ローダーを指定して、実行ファイルexecにする。
        Util.exec("ld -lc --dynamic-linker /lib64/ld-linux-x86-64.so.2  -o exec source.o");

        //execコマンドを実行し、結果を表示。
        System.out.println(Util.exec("./exec"));
    }
}
