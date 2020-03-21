import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int wires = sc.nextInt();
        
        int[] noOfBirds = new int[wires+1];
        noOfBirds[0] = 0;
        
        for(int i=1;i<=wires;i++)
        {
            noOfBirds[i] = (sc.nextInt());
        }
        
        int testcases = sc.nextInt();
        
        while(testcases-- > 0)
        {
            int wireNo = sc.nextInt();
            int shootedBirdNo = sc.nextInt();
            
            if(wireNo > 1 && wireNo<wires)
            {
                noOfBirds[(wireNo-1)] = noOfBirds[(wireNo-1)] + Math.abs(1 - shootedBirdNo);
                noOfBirds[(wireNo+1)] = noOfBirds[(wireNo+1)] + Math.abs(noOfBirds[(wireNo)] - shootedBirdNo );
                noOfBirds[(wireNo)] = 0;
            }
            
            else if(wireNo == 1 && wires == 1)
            {
                noOfBirds[(wireNo)] = 0;
            }
            
            else if(wireNo == 1)
            {
                noOfBirds[(wireNo+1)] = noOfBirds[(wireNo+1)] + Math.abs(noOfBirds[(wireNo)] - shootedBirdNo );
                noOfBirds[(wireNo)] = 0;
            }
            
            else if(wireNo == wires)
            {
                noOfBirds[(wireNo-1)] = noOfBirds[(wireNo-1)] + Math.abs(1 - shootedBirdNo);
                noOfBirds[(wireNo)] = 0;
            }
        }
        
        for(int i=1;i<=wires;i++)
        {
            System.out.println(noOfBirds[i]);
        }
    }
}