#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    long long n,index;
    cin>>n>>index;
    
    long long mid;
    
    if(n%2==0)
    mid = n/2;
    else
    mid = n/2 + 1;
    
    if(index<=mid)
    cout<<(abs(index-1)*2)+1;
    else
    cout<<abs(mid-index)*2;
    
    return 0;
}