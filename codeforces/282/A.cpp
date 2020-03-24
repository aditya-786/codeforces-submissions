#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int testcases;
    cin>>testcases;
    
    string s;
    int count = 0;
    
    while(testcases--)
    {
        cin>>s;
        
        if(s=="X++" || s=="++X")
        count++;
        
        else
        count--;
    }
    
    cout<<count;
    
    return 0;
}