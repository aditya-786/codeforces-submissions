#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    char arr[] = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l',';','z','x','c','v','b','n','m',',','.','/'};
    
    string s1,s2;
    getline(cin,s1);
    
    getline(cin,s2);
    
    if(s1=="R")
    {
        for(int i=0;i<s2.length();i++)
        {
            int dis = distance(arr,find(arr,arr+(sizeof(arr)/sizeof(arr[0])),s2[i]));
            
            cout<<arr[dis-1];
        }
    }
    else
    {
        for(int i=0;i<s2.length();i++)
        {
            int distanc = distance(arr,find(arr,arr+(sizeof(arr)/sizeof(arr[0])),s2[i]));
            
            cout<<arr[distanc+1];
        }
    }
    
    return 0;
}