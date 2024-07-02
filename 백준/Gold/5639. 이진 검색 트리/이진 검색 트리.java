import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> preOrder = new ArrayList<>();
    static class Node {
        int now;
        Node left;
        Node right;

        public Node(int now) {
            this.now = now;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            preOrder.add(Integer.parseInt(input));
        }

        Node root = new Node(preOrder.get(0));
        for (int i = 1; i < preOrder.size(); i++) {
            makeTree(root, preOrder.get(i));
        }

        postOrder(root);
    }

    public static void makeTree(Node node, int now) {
        if (node.now > now) {
            if (node.left == null)
                node.left = new Node(now);
            else makeTree(node.left, now);
        } else {
            if (node.right == null)
                node.right = new Node(now);
            else makeTree(node.right, now);
        }
    }

    public static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        System.out.println(node.now);
    }
}