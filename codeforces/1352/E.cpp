#include<bits/stdc++.h>
#define ll long long int
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    ll t;
    cin>>t;
    while(t--){
        ll n;
        cin>>n;
        vector<ll> v(n);
        for(ll i=0;i<n;i++) cin>>v[i];
        unordered_map<ll,ll>mp;
        for(ll i=0;i<n;i++) mp[v[i]]++;
        ll count = 0;
        for(ll i=0;i<n;i++){
            ll sum = 0;
            for(ll j=i;j<n;j++){
                sum+=v[j];
                if(i==j) continue;
                if(sum<=n){
                    count+=mp[sum];
                    mp[sum] = 0;
                }
                else break;
            }
        }
        
        cout<<count;
        cout<<"\n";
        
    }
    
    return 0;
}