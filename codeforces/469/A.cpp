#include<bits/stdc++.h>
 
using namespace std;
 
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
 
    int maxLevel;
    cin>>maxLevel;
    
    int arr[maxLevel+1]={0};
    
    int x;
    cin>>x;
    
    int arr1[x+1];
    for(int i=1;i<=x;i++)
    {
        cin>>arr1[i];
        
        arr[arr1[i]] = 1;
    }
    
    int y;
    cin>>y;
    
    int arr2[y+1];
    for(int i=1;i<=y;i++)
    {
        cin>>arr2[i];
        
        arr[arr2[i]] = 1;
    }
    
    for(int i=1;i<=maxLevel;i++)
    {
        if(arr[i]!=1)
        {
            cout<<"Oh, my keyboard!";
            break;
        }
        
        else if(i==maxLevel)
        {
            cout<<"I become the guy.";
        }
    }
    
    return 0;
}