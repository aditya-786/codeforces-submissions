#include<bits/stdc++.h>
using namespace std;
 
#define ll long long
#define pb push_back
#define endl '\n'

int  main()
{
    int t; cin>>t;
    while(t--){
    int n; cin>>n;
    int a[n];
    for(int i=0;i<n;i++) cin>>a[i];
    map<int,int>m;

    for(int i=0;i<n;i++)m[a[i]]++;
    int count=0;
    for(auto x:m){
        if(x.second==1){
            count=x.first;
            break;
        }
    }
    if(count==0) cout<<-1<<endl;

    for(int i=0;i<n;i++){
        if(a[i]==count)
        cout<<i+1<<endl;
    }
    }
}