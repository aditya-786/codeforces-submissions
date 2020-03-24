#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin>>n;
    
    int arr[n];
    int sum = 0;
    
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
        sum = sum + arr[i];
    }
    
    sort(arr,arr+n,greater<int>());
    
    int count = 0;
    int sum_final = 0;
    
    for(int i=0;i<n;i++)
    {
        sum_final = sum_final + arr[i];
        sum = sum - arr[i];
        
        if(sum_final > sum)
        {
            count++;
            break;
        }
        
        count++;
    }
    
    cout<<count;
    
    return 0;
}