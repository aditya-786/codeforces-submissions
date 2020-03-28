#include<bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    
    int n;
    cin>>n;
    
    cin.ignore();
    
    long long int count = 0;
    
    while(n--)
    {
        string s;
        getline(cin,s);
        
        if (s[0]=='T')
        count = count + 4;
        
        else if(s[0]=='C')
        count = count + 6;
        
        else if(s[0]=='O')
        count = count + 8;
        
        else if(s[0]=='D')
        count = count + 12;
        
        else if(s[0]=='I')
        count = count + 20;
        
        //cout<<"----"<<count<<"\n";
    }
    
    cout<<count;
    
    return 0;
}