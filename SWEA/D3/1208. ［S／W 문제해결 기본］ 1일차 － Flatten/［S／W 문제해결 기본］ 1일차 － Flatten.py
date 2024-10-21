for t in range(10):
    num = int(input())
    land = list(map(int, input().split()))
    for _ in range(num):
        land.sort()
        if (land[-1] - land[0]) <= 1:
            break
        land[0] += 1
        land[-1] -= 1
    land.sort()   
    print(f"#{t+1}", land[-1] - land[0])