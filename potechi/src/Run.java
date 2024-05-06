public class Run {
    public static String run(Node ast) {
        if(ast == null) {
            return "";
        } else if(ast.op.equals(",")) {
            return run(ast.left, ast.right, ast);
        } else if(ast.op.equals(";")) {
            run(ast.leftNode);
            run(ast.rightNode);
        } else if(ast.op.equals("()")) {
            String func = ast.left;
            if (func.equals("print")) {
                String msg = run(ast.rightNode);
                System.out.println(msg);
            } else {
                try {
                    throw new Exception("未実装の関数呼び出し func=" + func);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                throw new Exception("未実装の演算子 op=" + ast.op);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String run(String str) {
        if(str == null) {
            return "";
        }
        if(str.matches("\".*")) {
            str = str.substring(1, str.length()-1);
        }
        return str;
    }

    public static String run(String str1, String str2) {
        return run(str1) + run(str2);
    }

    public static String run(String left, String right, Node ast) {
        return run(ast.leftNode) + run(left) + run(right);
    }
}
