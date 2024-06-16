import java.io.*;

public class Main {
    static int N, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            start = 0;
            end = str.length() - 1;

            while(start < end){
                if(str.charAt(start) != str.charAt(end)){
                    if(isPalindrome(str, start + 1, end) || isPalindrome(str, start, end - 1)) {
                        System.out.println(1);
                    } else{
                        System.out.println(2);
                    }
                    break;
                }
                start++;
                end--;
            }
            if(start >= end){
                System.out.println(0);
            }
        }
    }

    public static boolean isPalindrome(String str, int s1, int end1){
        while(s1 < end1){
            if(str.charAt(s1) != str.charAt(end1)){
                return false;
            }
            s1++;
            end1--;
        }
        return true;
    }
}