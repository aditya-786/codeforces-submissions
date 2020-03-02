import java.util.Scanner;

public class Codeforce{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        char[] c = s.toCharArray();
        int count=0;
        //int i = 0;
        
        for(char c1 : c){
            //char c2 = c1.toUpperCase();
            if((int)c1<=91){
                count++;
            }else{
                count--;
            }
        }
        
        if(count>0){
            System.out.println(s.toUpperCase());
        }else if(count<0){
            System.out.println(s.toLowerCase());
        }else{
            System.out.println(s.toLowerCase());
        }
    }
}