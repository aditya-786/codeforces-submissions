import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        ArrayList <Integer> list = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        
        int player1 = 0;
        int player2 = 0;
        
        for(int i=0;i<n;i++){
            
            int max = Math.max(list.get(0),list.get(list.size()-1));
            
            if (i==0 || i%2==0){
                player1 = player1 + max;
            }else{
                player2 = player2 + max;
            }
            
            if(max == list.get(0)){
                list.remove(0);
            }else{
                list.remove(list.size()-1);
            }
        }
        
        System.out.println(player1+" "+player2);
    }
}