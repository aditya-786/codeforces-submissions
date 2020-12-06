for i in range(int(input())):
    
    n = int(input())
    st = input()
    
    count = 0
    
    for j in st:
        if j!='t':
            print(j,end="")
        else:
            count+=1 
            
    for j in range(count):
        print("t",end="")
        
    print()