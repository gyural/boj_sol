T = int(input())
for t in range(T):
    N, M, K = map(int, input().split())
    mouth = list(map(int, input().split()))
    mouth.sort()
    
    complete = [0] * (mouth[-1] +1)
    #최대시간까지 붕어빵 구워주기
    for i in range(1, len(complete)):
        complete[i] = complete[i-1]
        if(i % M == 0):
            complete[i] += K
            
    #손님이 가져가기
    flag = 'Possible'
    for idx, val in enumerate(mouth):
        if complete[val] < (idx+1):
            flag = 'Impossible'
        
    print(f"#{t+1}", flag)
        
            