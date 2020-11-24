from collections import Counter
import math

def fre_count(mylist):
    return Counter(mylist)


def primeFactors(n):
    li = []
    while n % 2 == 0:
        li.append(2)
        n = n / 2

    for i in range(3, int(math.sqrt(n)) + 1, 2):

        while n % i == 0:
            li.append(i)
            n = n / i

    if n > 2:
        li.append(n)

    return li


for _ in range(int(input())):
    n = int(input())

    li = primeFactors(n)

    myList = fre_count(li)

    maxVal = 1

    element = None

    for ele in myList:
        if myList[ele] > maxVal:
            maxVal = myList[ele]
            element = ele

    if element == None:
        print(1)
        print(n)
        continue

    finalAns = []

    for i in range(myList[element] - 1):
        finalAns.append(element)
        n //= element

    finalAns.append(n)

    print(len(finalAns))

    for i in range(len(finalAns)):
        print(finalAns[i], end=" ")
    print()