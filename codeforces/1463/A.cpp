#include <bits/stdc++.h>
// #include <ext/pb_ds/assoc_container.hpp>
// #include <ext/pb_ds/tree_policy.hpp>
using namespace std;
// using namespace __gnu_pbds;
// using ordered_set = tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update>;

void __dbg() { cout << endl; }
template<typename Arg, typename... Args> void __dbg(Arg A, Args... B) { cout << ' ' << A; __dbg(B...); }
#define dbg(...)  cout << "(" << #__VA_ARGS__ << "):", __dbg(__VA_ARGS__)

#define rep(i,a,b) for(int i=a;i<b;i++)
#define lprin(n) printf("%lld\n", n)
#define lpri(n) printf("%lld ", n)
#define lscn(n) scanf("%lld", &n)
#define prin(n) printf("%d\n", n)
#define pri(n) printf("%d ", n)
#define scn(n) scanf("%d", &n)
#define vi vector<int>
#define vl vector<ll>
#define ll long long
#define pb push_back
#define mp make_pair
#define F first
#define S second

const int inf  = INT_MAX;
const int ninf = INT_MIN;
const int mod  = 1e9 + 7;
const int maxN = 1e6 + 2;

void solve()
{
   ll a, b, c;
   cin >> a >> b >> c;

   ll s = a + b + c;
   ll f = s / 9;
   ll m = min({a, b, c});

   puts(s % 9 == 0 && f <= m ? "YES" : "NO");
}

int main()
{
   int t;
   scn(t);

   while(t--) {
      solve();
   }
   
   return 0;
}