from collections import deque

def DFS(s, graph, visit, res):
  res.append(s)
  for nxt in graph[s]:
    if(visit[nxt] == False):
      visit[nxt] = True
      DFS(nxt, graph, visit, res)
  return
  
def BFS(s, graph):
  visit = [False for _ in range(len(graph))]
  
  result = [s]
  Q = deque()
  Q.appendleft(s)
  visit[s] = True
  while(len(Q)>0):
    cur = Q.pop()
    for nxt in graph[cur]:
      if(visit[nxt] == False):
        Q.appendleft(nxt)
        visit[nxt] = True
        result.append(nxt)
  return result
  
#### MAIN ####        
V, E, S = map(int, input().split())

graph = [[] for _ in range(V+1)]

for _ in range(E):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

for g in graph:
  g.sort()

# BFS
route1 = []
visit = [False for _ in range(V+1)]
visit[S] = True
DFS(S, graph, visit, route1)

# DFS
route2 = BFS(S, graph)

for v in route1:
  print(v , end= " ")
print()
for v in route2:
  print(v, end= " ")