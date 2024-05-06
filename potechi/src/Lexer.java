import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lexer {
    public static List<String> lexer(String source) {
        List<String> tokens = new ArrayList<>(Arrays.asList(source.split("(?<=\\(|print)|(?=;|\\))|\n|\\/\\/.*\n|(?<=,)|(?=,)")));
        tokens = tokens.stream().filter(t -> !t.isEmpty()).collect(Collectors.toList());
        return tokens;
    }
}
