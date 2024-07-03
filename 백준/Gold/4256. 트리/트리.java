import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[] preOrder, inOrder, postOrder;
    static StringTokenizer st;
    static StringBuilder sb;

    static class Node {
        int now;
        Node left, right;

        Node(int now) {
            this.now = now;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            preOrder = new int[N];
            inOrder = new int[N];
            postOrder = new int[N];
            sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                preOrder[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inOrder[j] = Integer.parseInt(st.nextToken());
            }

            Node root = new Node(preOrder[0]);
            makeTree(root, preOrder, inOrder);
            postOrder(root);
            System.out.println(sb);
        }
    }

    public static void makeTree(Node node, int[] pre, int[] in) {
        int idx = 0;

        for(int i = 0; i < in.length; i++) {
            if(in[i] == node.now) {
                idx = i;
                break;
            }
        }

        if(idx > 0) {
            node.left = new Node(pre[1]);
            makeTree(node.left, Arrays.copyOfRange(pre, 1, idx + 1), Arrays.copyOfRange(in, 0, idx));
        }

        if(idx < pre.length - 1) {
            node.right = new Node(pre[idx + 1]);
            makeTree(node.right, Arrays.copyOfRange(pre, idx + 1, pre.length), Arrays.copyOfRange(in, idx + 1, in.length));
        }
    }

    public static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        sb.append(node.now).append(" ");
    }
}