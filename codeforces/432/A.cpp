#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n,k;
    cin>>n>>k;
    
    int count = 0;
    
    int arr[n];
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
        
        if(arr[i]+k <=5)
        count++;    
    }
    
    cout<<count/3;
    
    return 0;
}