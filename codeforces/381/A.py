n = int(input())

nums = list(map(int, input().split()))
player1 = 0
player2 = 0

for i in range(len(nums)):
    x = max(nums[0],nums[len(nums)-1])
    
    if(i==0 or i%2==0):
        player1 = player1 + x
        #nums.pop()
    else:
        player2 = player2 + x
    
    if x == nums[0]:
        nums.pop(0)
    else:
        nums.pop(len(nums)-1)
    
print(player1," ",player2)
        
    
        
    
