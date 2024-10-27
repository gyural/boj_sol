T = int(input())

for t in range(T):
    N = int(input())
    arr = list(map(int, input().split()))
    
    result = -1
    for i in range(N-1):
        for j in range(i+1, N):
            targetNum = arr[i] * arr[j]
            if targetNum <= result:
                continue
            
            str_my = str(targetNum)
            arr_target = [int(char) for char in str_my]
            if(arr_target == sorted(arr_target)):
                result = targetNum
            
    print(f"#{t+1}", result)
        	
             
            