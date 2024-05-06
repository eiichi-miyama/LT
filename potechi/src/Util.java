import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static String readAll(String path) throws IOException {
        StringBuilder builder = new StringBuilder();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String string = reader.readLine();
            while (string != null){
                builder.append(string + System.getProperty("line.separator"));
                string = reader.readLine();
            }
        }
    
        return builder.toString();
    }

    public static String accept(List<String> tokens, String... cs_list) {
        List<String> cs = Arrays.asList(cs_list);
        if (tokens.size() != 0 && cs.contains(tokens.get(0))) {
            return tokens.remove(0);
        }
        return null;
    }

    public static String expect(List<String> tokens, String... cs_list) {
        String t = accept(tokens, cs_list);
        if (t == null) {
            try {
                throw new Exception("error in expect()");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
