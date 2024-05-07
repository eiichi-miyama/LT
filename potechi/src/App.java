import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "./potechi/src/source.potechi";        
        String source = Util.readAll(path);

        List<String> tokens = Lexer.lexer(source);
        System.out.println(tokens);
        Node ast = Parser.parser(tokens);
        System.out.println(ast);
        Run.run(ast);
    }
}
