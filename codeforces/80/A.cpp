#include<bits/stdc++.h>
using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int prime,nextPrime;
    cin>>prime>>nextPrime;
    
    if((nextPrime!=3 && nextPrime!=5 && nextPrime!=7) && ( nextPrime%2== 0 || nextPrime%3==0 || nextPrime%5==0 || nextPrime%7==0))
    cout<<"NO";
    
    else{
    
    int i;
    
    for(i=prime+1;i<=nextPrime;i++)
    {
        if(i==3 || i==5 || i==7)
        {
            i++;
            break;
        }
        
        else if(i%2== 0 || i%3==0 || i%5==0 || i%7==0)
        continue;
        else
        {
            i++;
            break;
        }
    }
    
    //cout<<i<<"\n";
    i==nextPrime+1 ? cout<<"YES":cout<<"NO";
    }
    return 0;
}