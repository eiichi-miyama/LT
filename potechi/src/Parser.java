import java.util.List;

public class Parser {
    public static Node parser(List<String> tokens) {
        return semi(tokens);
    }

    public static String value(List<String> tokens) {
        if(tokens.size() == 0) {
            return null;
        }
        return tokens.remove(0);
    }

    public static Node funcCall(List<String> tokens) {
        Node leftNode = null;
        String left = value(tokens);
        String op;
        if ( (op = Util.accept(tokens, "(")) != null ){
            Node rightNode = comma(tokens);
            op += Util.expect(tokens, ")");
            leftNode = new Node(left, op, rightNode);
            while ( (op = Util.accept(tokens, "(")) != null ){
                rightNode = comma(tokens);
                op += Util.expect(tokens, ")");
                leftNode = new Node(leftNode, op, rightNode);
            }
        } else {
            leftNode = new Node(left, null, leftNode);
        }
        return leftNode;
    }

    public static Node comma(List<String> tokens) {
        Node leftNode = funcCall(tokens);
        String op;
        while((op = Util.accept(tokens, ",")) != null) {
            Node rightNode = funcCall(tokens);
            if(leftNode.op == null) {
                if(rightNode.op == null){
                    leftNode = new Node(leftNode.left, op, rightNode.left);
                } else {
                    leftNode = new Node(leftNode.left, op, rightNode);
                }
            } else {
                if(rightNode.op == null){
                    leftNode = new Node(leftNode, op, rightNode.left);
                } else {
                    leftNode = new Node(leftNode, op, rightNode);
                }
            }
        }
        if(leftNode.op == null){
            return null;
        }
        return leftNode;
    }

    public static Node semi(List<String> tokens) {
        Node leftNode = funcCall(tokens);
        String op;

        while( (op = Util.accept(tokens, ";")) != null ) {
            Node rightNode = funcCall(tokens);
            if(rightNode.op == null){
                leftNode = new Node(leftNode, op, rightNode.left);
            } else {
                leftNode = new Node(leftNode, op, rightNode);
            }
        }
        return leftNode;
    }


    // 今後は汎用的なfuncCallを使用
    // public static Node callPrint(List<String> tokens) {
    //     if (tokens.size() == 0) {
    //         return null;
    //     }

    //     String left = Util.expect(tokens, "print");
    //     String op = Util.expect(tokens, "(");
    //     String right = tokens.remove(0);

    //     op += Util.expect(tokens, ")");

    //     return new Node(left, op, right);
    // }
}
