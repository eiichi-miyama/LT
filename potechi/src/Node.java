public class Node {
    public String left;
    public String op;
    public String right;
    public Node leftNode;
    public Node rightNode;

    public Node(String left, String op, String right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public Node(Node leftNode, String op, Node rightNode) {
        this.leftNode = leftNode;
        this.op = op;
        this.rightNode = rightNode;
    }

    public Node(String left, String op, Node rightNode) {
        this.left = left;
        this.op = op;
        this.rightNode = rightNode;
    }
    
    public Node(Node leftNode, String op, String right) {
        this.leftNode = leftNode;
        this.op = op;
        this.right = right;
    }

    @Override
    public String toString() {
        String str = "{\n";
        str += "\tleft : " + left + "\n";
        str += "\top : " + op + "\n";
        str += "\tright : " + right + "\n";
        str += "\tleftNode : " + leftNode + "\n";
        str += "\trightNode : " + rightNode + "\n";
        str += "}";
        return str;
    }
}
