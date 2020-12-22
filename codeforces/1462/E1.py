import io, os, time, sys
from sys import stdin

def print(s):
    sys.stdout.write(str(s)+"\n") 

def ncr(n):
    return (n * (n - 1) * (n - 2)) // 6

for  _ in range(int(stdin.readline())):
    
    n =int(stdin.readline())
    l = list(map(int, stdin.readline().split()))
    ma = max(l)
    hash = [0]*(n+2)
    for i in l:
        hash[i]+=1
        
    res = ncr(hash[1])
    for i in range(2, n+1):
        res+=(ncr(hash[i] + hash[i - 1] + hash[i - 2]) - ncr(hash[i - 1] + hash[i - 2]))
    print(res)
