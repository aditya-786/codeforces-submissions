s1 = input()

s2 = s1.split('WUB')

for i in range(len(s2)):
    if s2[i]!='':
        if i!=len(s2)-1:
            print(s2[i],end=' ')
        else:
            print(s2[i])