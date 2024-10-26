for _ in range(1, 11):
    t= int(input())
    arr = list(map(int, input().split()))
    
    index = 0
    while True:
        for i in range(1,5+1):
            head = arr[0] - i
            if head <= 0:
                head = 0
                arr = arr[1:] + [head]
                break
            arr = arr[1:] + [head]
        if 0 in arr:
            break
        
    
    #출력
    print(f"#{t}", end=" ")
    for val in arr:
        print(val, end=" ")
    print()
    