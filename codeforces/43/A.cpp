#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int goals;
    cin>>goals;
    
    cin.ignore();
    
    int team1 = 0, team2 = 0;
    
    string teamName[goals];
    string s="";
    
    for(int i=0;i<goals;i++)
    {
        getline(cin,teamName[i]);
        
        if(teamName[i]==teamName[0])
        team1++;
        else
        {
            team2++;
            s = teamName[i];
        }    
    }
    
    team1>team2 ? cout<<teamName[0]:cout<<s;
    
    return 0;
}