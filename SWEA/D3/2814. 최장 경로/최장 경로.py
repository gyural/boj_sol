T = int(input())
def DFS(cur):
    for nxt in (matrix[cur]):
        if nxt not in visit:
            visit.append(nxt)
            #print(visit)
            maxNum[0] = max(len(visit), maxNum[0])
            DFS(nxt)
            visit.pop()
for t in range(T):
    N, M = map(int, input().split())
    #2차원 배열
    matrix = [[] * (N+1)  for _ in range(N+1)]
    for _ in range(M):
        x, y = map(int, input().split())
        matrix[x].append(y)
        matrix[y].append(x)
    #print(matrix)
    maxNum = [1]
    for i in range(1, N+1):
        visit = [i]
        DFS(i)
    print(f"#{t+1} {maxNum[0]}")


