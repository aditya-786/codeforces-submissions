#include<bits/stdc++.h>
 
using namespace std;
 
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    long long int n,m,a;
    
    cin>>n>>m>>a;
    
    if (a == 1)
    {
        cout<<n*m;
    }
    
    else
    {
    long long int count1 = a;
    long long int count2 = a;
    long long int c1 = 1;
    long long int c2 = 1;
    
    while(count1<n)
    {
        count1 = count1 + a;
        
        if( (count1-a)<n)
        c1++;
    }
    
    while(count2<m)
    {
        count2 = count2 + a;
        
        if(count2-a<m)
        c2++;
    }
    
    cout<<c1*c2;
    }
    
    return 0;
}