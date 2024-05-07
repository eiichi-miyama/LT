import java.util.ArrayList;
import java.util.List;

public class ParserComp {
    public static void parser(List<String> tokens) {
        callPrint(tokens);
    }

    public static void callPrint(List<String> tokens) {
        if(tokens.size() == 0) return;

        Util.expect(tokens, "print");
        Util.expect(tokens, "(");
        String msg = tokens.remove(0);
        List<String> codes = new ArrayList<>();
        
        codes.add("\n#intel表記を使う");
        codes.add(".intel_syntax noprefix");

        codes.add("\n#エントリポイント");
        codes.add(".global _start");
        codes.add("_start:");

        codes.add("lea rdi,[.s1]");
        codes.add("call printf");

        codes.add("\n#exit(0)で終了");
        codes.add("end:");
        codes.add("mov rdi,0");
        codes.add("call exit");
        codes.add("\n#文字列リテラル.s連番で定義");

        //.s連番: .string "文字列"
        codes.add(".s1: .string "+ msg);

        //最後に改行がないと、asが文句言う。
        var asm = String.join("\n", codes) + "\n";

        Util.write("source.s", asm);

        Util.expect(tokens, ")");


    }
}
