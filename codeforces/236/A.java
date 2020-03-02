import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String username = sc.nextLine();
        
        char[] c = username.toCharArray();
        
        int [] arr = new int[256];
        
        int count = 0;
        
        for(char c1 : c){
            arr[(int)c1]++;
            
            if(arr[(int)c1] == 1){
                count++;
            }
        }
        
        if(count%2 == 0){
            System.out.println("CHAT WITH HER!");
        }else{
            System.out.println("IGNORE HIM!");
        }
    }
}
//wjmzbmr
//xiaodao
