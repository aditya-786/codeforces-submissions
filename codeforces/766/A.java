import java.util.Scanner;

public class Codeforces{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        if(s2.equals(s1)==true)
        System.out.println(-1);
        else
        System.out.println(Math.max(s1.length(),s2.length()));
    }
}