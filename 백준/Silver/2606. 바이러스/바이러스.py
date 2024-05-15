from collections import deque

def BFS(Edge, start, NodeNum):
  res = 0
  visit = [False] * (NodeNum + 1)
  Q = deque()
  Q.appendleft(start)
  visit[start] = True
  while len(Q)>0:
    cur = Q.pop()
    for i in range(1, NodeNum+1):
      if (Edge[cur][i] == 1 and visit[i] == False):
        visit[i] = True
        Q.appendleft(i)
        res += 1
  return res

NodeNum = int(input())
EdgeNum = int(input())
Edge = [[0] * (NodeNum+1) for i in range(NodeNum + 1)]



for i in range(EdgeNum):
  a, b = map(int, input().split())
  Edge[a][b] = 1
  Edge[b][a] = 1

print(BFS(Edge, 1, NodeNum))

  