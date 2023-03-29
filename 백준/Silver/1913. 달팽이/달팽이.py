import sys

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]
N = int(input())
target = int(input())

curY, curX = 1, 1
matrix = [[0] * (N+2) for _ in range(N+2)]
#외벽 쌓기
for i in range(N+2):
  matrix[0][i] = -1
  matrix[i][0] = -1
  matrix[N+1][i] = -1
  matrix[i][N+1] = -1
  
matrix[curY][curX] = N**2
result = (1,1)
dir = 0
for i in range(N**2-1, 0, -1):
  newY = curY + dy[dir]
  newX = curX + dx[dir]

  if matrix[newY][newX] == 0:
    matrix[newY][newX] = i
    curY, curX = newY, newX
    if i == target:
      result = (curY, curX)
    
  else:
    dir += 1
    if dir > 3:
      dir = 0
    curY = curY + dy[dir]
    curX = curX + dx[dir]
    matrix[curY][curX] = i
    if i == target:
      result = (curY, curX)
  
for i in range(1, N+1):
  for j in range(1, N+1):
    print(matrix[i][j], end = ' ')
  print()

print(result[0], result[1])
  
    