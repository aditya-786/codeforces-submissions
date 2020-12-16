for _ in range(int(input())):
    n = int(input())
    

    if (n>45): print(-1)
    else:
        l = list()
        for i in range(9,0, -1):
            if (n-i>=0):
                n-=i;
                l.append(i)
                            

            if (n==0): break
                        

        l.sort()
        for i in l:
            if n==0:print(i,end="")
        print()
