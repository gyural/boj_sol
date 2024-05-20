from collections import deque

vector = [[0,1], [0,-1], [1,0], [-1,0]]
def BFS(y, x, visit, matrix):
  size = len(matrix)
  count = 1
  
  Q = deque()
  Q.appendleft([y,x])
  visit[y][x] = True
  
  while(len(Q) > 0):
    cur = Q.pop()
    for i in range(4):
      nxt = [cur[0]+vector[i][0], cur[1]+vector[i][1]]
      if(0<=nxt[0]<size and 0<=nxt[1]<size):

        if(visit[nxt[0]][nxt[1]] == False and matrix[nxt[0]][nxt[1]] == 1):

          Q.appendleft([nxt[0], nxt[1]])
          visit[nxt[0]][nxt[1]] = True
          count += 1
  
  return count
          
    
  
matrix = []
size = int(input())
visit = [[False] * size for _ in range(size)]
res = []
for _ in range(size):
  matrix.append(list(input()))

for i in range(size):
  for j in range(size):
    matrix[i][j] = int(matrix[i][j])

# search
for i in range(size):
  for j in range(size):
    if matrix[i][j] == 1 and visit[i][j] == False:
      res.append(BFS(i, j, visit, matrix))

res.sort()
print(len(res))
for n in res:
  print(n)




