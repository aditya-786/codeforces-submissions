#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    // -1+2-3+4-5+6-7+8-9 ---------->>>>>>>>> 
    
    long long int n;
    cin>>n;
    
    if (n%2 == 0)
    cout<<n/2;
    else
    cout<<-((n/2)+1);
    
    return 0;
}