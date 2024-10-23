T = int(input())

for t in range(T):
    N = int(input())
    if(N == 1):
        farm = int(input())
        print(f"#{t+1}", farm)
        continue
    middle = N // 2
    farm = []
    for i in range(N):
        line_str = input()
        line = list(line_str)
        line = [int(val) for val in line]
        farm.append(line)
    result = 0
    #위로 삼각형
    for i in range(middle):
        result += farm[i][middle]
        #좌우로 i수만큼 더하기
        for j in range(1, i+1):
            result += farm[i][middle+j]
            result += farm[i][middle-j]
    #아래로 삼각형
    for i in range(middle):
        index = N - 1 - i
        result += farm[index][middle]
        #좌우로 i수만큼 더하기
        for j in range(1, i+1):
            result += farm[index][middle+j]
            result += farm[index][middle-j]
    #가운데 구하기
    result += sum(farm[middle])
    print(f"#{t+1}", result)