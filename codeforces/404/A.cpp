#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int lines;
    cin>>lines;
    
    cin.ignore();
    
    string s[lines];
    
    for(int i=0;i<lines;i++)
    {
        getline(cin,s[i]);
    }

    char alpha1 = s[0][0];
    char alpha2 = s[lines/2][0];
    
    if(alpha1==alpha2)
    {
        cout<<"NO";
        exit(0);
    }

    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    
    for(int i=0;i<lines;i++)
    {
        for(int j=0;j<lines;j++)
        {
            if(s[i][j]!=alpha1 && s[i][j]!=alpha2)
            {
                count1 = 1;
                break;
            }    
            
            else if (j!=i && j!=abs(lines-i-1))
            {
                if(s[i][j]!=alpha2)
                {
                    cout<<"NO";
                    exit(0);
                }
            }
        }
        
        if(s[i][i]==alpha1 && s[i][abs(lines-i-1)]==alpha1)
        count2++;
        
        if(count1==1)
        break;
    }
    
    if(count1==1)
    cout<<"NO";
    else
    {
        if(count2==lines)
        cout<<"YES";
        else
        cout<<"NO";
    }

    return 0;
}