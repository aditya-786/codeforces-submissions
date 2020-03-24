#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin>>n;
    
    int temp = n;
    
    cin.ignore();
    
    string s;
    getline(cin,s);
    
    transform(s.begin(),s.end(),s.begin(),::tolower);
    
    int arr[256] = {0};
    int k = 0;
    
    while(temp--)
    {
        arr[(int)s[k]] = 1;
        k++;
    }
    
    k = 0;
    temp = 0;
    
    for(temp=97;temp<=122;temp++)
    {
        if(arr[temp] == 0)
        {
            cout<<"NO";
            break;
        }
    }
    
    if(temp==123)
    cout<<"YES";
    
    return 0;
}