#include<bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int row,col;
    cin>>row>>col;
    
    char arr[row][col];
    
    int c = 0;
    
    for(int i=0;i<row;i++)
    {
        for(int j=0;j<col;j++)
        {
            cin>>arr[i][j];
            
            if(arr[i][j] =='C' || arr[i][j]=='M' || arr[i][j]=='Y')
            c = 1;
        }
    }
    
    c == 0 ? cout<<"#Black&White" : cout<<"#Color";
    
    return 0;
}