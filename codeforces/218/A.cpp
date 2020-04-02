#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n,k;
    cin>>n>>k;
    
    int calc = 2*n + 1;
    
    int arr[calc+1];
    int count = 0;
    
    for(int i=1;i<=calc;i++)
    {
        cin>>arr[i];
    }
    
    for(int i=1;i<=calc;i++)
    {
        if(i%2==0 && count<k && arr[i]>arr[i-1] + 1 && arr[i]>arr[i+1] + 1)
        {
            arr[i] = arr[i] - 1;
            count++;
        }
        
        cout<<arr[i]<<" ";
    }
    
    return 0;
}