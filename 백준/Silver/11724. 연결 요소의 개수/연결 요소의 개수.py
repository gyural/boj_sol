import sys
input = sys.stdin.readline
def find_parent(parent, x):
  # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
  if parent[x] != x:
      return find_parent(parent, parent[x])
  return x

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
      parent[b] = a
  else:
      parent[a] = b

### MAIN
N, M = map(int ,input().split())

parent = [i for i in range(N+1)]
for _ in range(M):
  a, b = map(int ,input().split())
  union_parent(parent, a, b)

for i in range(1, N+1):
  parent[i] = find_parent(parent, i)

print(len(set(parent[1:])))

# a, b =map(int ,input().split())
# print(a, b)