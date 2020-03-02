import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        String s2 = s.substring(0,1);
        System.out.println(s2.toUpperCase()+s.substring(1,s.length()));
    }
}