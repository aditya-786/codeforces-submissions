import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        sc.nextLine();
        
        String s = sc.nextLine();
        
        char[] directions = s.toCharArray();
        
        int count = 0;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        
        for(int i=0;i<directions.length-1;i++)
        {
            if(directions[i]=='R' && directions[i+1]=='L')
            {
                indexes.add(i);
                indexes.add(i+1);
                count = 1;
            }
        }
        
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++)
        {
            coordinates.add(sc.nextInt());
        }
        
        ArrayList<Integer> al_for_min = new ArrayList<Integer>();
        
        if(count==1)
        {
            //System.out.println((coordinates.get(y)-coordinates.get(x))/2);
            
            for(int i=0;i<indexes.size();i=i+2)
            {
                al_for_min.add(  (coordinates.get(indexes.get(i+1)) - coordinates.get(indexes.get(i)))/2  );
            }
            
            System.out.println(Collections.min(al_for_min));
        }
        else
        System.out.println(-1);
    }
}