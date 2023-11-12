import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        StringBuilder sentence = new StringBuilder(br.readLine());
        StringBuilder bomb = new StringBuilder(br.readLine());
        for(int i=0; i<sentence.length(); i++) {
            stack.push(sentence.charAt(i));
            
            if(stack.size()>= bomb.length()) {
                boolean isBomb = true;

               
                for(int j=0; j<bomb.length(); j++) {
                    if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if(isBomb) {
                    for(int j=0; j<bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }

        bw.write(sb.length() == 0 ? "FRULA" : sb.toString());

        br.close();
        bw.close();
    }
}
