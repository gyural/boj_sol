import sys
from collections import deque
input = sys.stdin.readline

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
N, M, K = map(int, input().split())
result = 0
matrix = [[0]*(M+2) for _ in range(N+2)]
visit = [[0]*(M+2) for _ in range(N+2)]
#외벽쌓아두기
for i in range(N+2):
  matrix[i][M+1] = -1
  matrix[i][0] = -1
for j in range(M+2):
  matrix[0][j] = -1
  matrix[N+1][j] = -1
for _ in range(K):
  r, c = map(int, input().split())
  matrix[r][c] = 1
for i in range(1, N+1):
  for j in range(1, M+1):
    # 음식물 쓰레기 발견시 BFS탐색 시작
    if matrix[i][j] == 1 and visit[i][j] == 0:
      Q = deque()
      Q.append((i, j))
      visit[i][j] = 1
      count = 1
      while Q:
        curY, curX = Q.popleft()
        for d in range(4):
          newY = curY + dy[d]
          newX = curX + dx[d]
          # 음식물 쓰레기라면
          if newY > 0 and newY <= N and newX > 0 and newX <= M:
            if matrix[newY][newX] == 1 and visit[newY][newX] == 0:
              count += 1
              # print(newY, newX, '방문!!!')
              visit[newY][newX] = 1
              Q.append((newY, newX))
      # 탐색 종료후 result값 갱신
      result = max(result, count)

print(result)