import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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

    // 外部コマンドを実行・結果を返す
    public static String exec(String cmd) {
        try {
            // Run script
            Process process = Runtime.getRuntime().exec("/tmp/myscript.sh");

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            System.out.println(output.toString());
            return output.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(String fileName, String data) {
        try{
            File file = new File(fileName);
            FileWriter filewriter = new FileWriter(file);
            filewriter.write(data);
            filewriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
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
