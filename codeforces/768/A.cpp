#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin>>n;
    
    int arr[n];
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    
    int max = *max_element(arr,arr+n);
    int min = *min_element(arr,arr+n);
    
    int count = 0;
    
    for(int i=0;i<n;i++)
    {
        if(arr[i]<max && arr[i]>min)
        count++;
    }
    
    cout<<count;
    
    return 0;
}