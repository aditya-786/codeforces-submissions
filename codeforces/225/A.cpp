#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int noOfDice;
    cin>>noOfDice;
    
    int topOfDice;
    cin>>topOfDice;
    
    while(noOfDice--)
    {
        int face1, face2;
        cin>>face1>>face2;
        
        if (face1==topOfDice || face1==7 - topOfDice || face2==topOfDice || face2==7 - topOfDice)
        {
            cout<<"NO";
            exit(0);
        }
    }
    
    cout<<"YES";
    
    return 0;
}