#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    long n;
    cin>>n;
    
    if(n==0)
    cout<<"1";
    else
    {
        int arr[] = {8,4,2,6};
        
        cout<<arr[(n-1)%4];
    }
    
    return 0;
}