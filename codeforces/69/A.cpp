#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin>>n;
    
    int arr1[n], arr2[n], arr3[n];
    
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    
    for(int i=0;i<n;i++)
    {
        cin>>arr1[i]>>arr2[i]>>arr3[i];
        
        sum1 = sum1 + arr1[i];
        sum2 = sum2 + arr2[i];
        sum3 = sum3 + arr3[i];
    }
    
    if (sum1==0 && sum2==0 && sum3==0)
    cout<<"YES";
    else
    cout<<"NO";
    
    return 0;
}