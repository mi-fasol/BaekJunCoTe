import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'P') {
                stack.push('P');
            } else {
                if(stack.size() >= 2 && i!= str.length() -1 && str.charAt(i+1) == 'P') {
                    stack.pop();
                    stack.pop();
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }
        if(stack.size() == 1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}