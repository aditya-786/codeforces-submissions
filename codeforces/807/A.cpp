#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin>>n;
    
    int beforeRating[n];
    int afterRating[n];
    
    int initialzer = 0;
    
    for(int i=0;i<n;i++)
    {
        cin>>beforeRating[i]>>afterRating[i];
        
        if (beforeRating[i]!=afterRating[i])
        initialzer = 1;
    }
    
    if (initialzer == 1)
    cout<<"rated";
    else
    {
       if(is_sorted(beforeRating,beforeRating+n,greater<int>())==1)
       cout<<"maybe";
       else
       cout<<"unrated";
    }
    
    return 0;
    
}