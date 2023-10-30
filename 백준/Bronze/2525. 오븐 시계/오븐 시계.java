import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int cookingTime = sc.nextInt();
        if (minute + cookingTime >= 60){
            hour += (minute + cookingTime) / 60;
            }
            minute = (minute + cookingTime) % 60;
        if(hour >= 24){
            hour -= 24;
        }
        System.out.println(hour + " " + minute);
    }
}