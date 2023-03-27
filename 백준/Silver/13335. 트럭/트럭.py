import sys
from collections import deque

input = sys.stdin.readline
n, w, L = map(int, input().split())
truck = list(map(int, input().split()))
Q = deque()
for t in truck:
  Q.append(t)

bridge = [0] * w
weight = 0
result = 0
count = 0
while count < n:
  #move_bridge
  #마지막 위치 먼저 빼주기
  if bridge[w-1] > 0:
    count += 1
    weight -= bridge[w-1]
  #모든 다리위 이동시켜주기
  for i in range(w-1, 0 , -1):
    bridge[i] = bridge[i-1]

  #트럭을 더 올릴 수 있다면
  if not Q:
    bridge[0] = 0
  elif weight + Q[0] <= L:
    nxt = Q.popleft()
    weight += nxt
    bridge[0] = nxt
  else:
    bridge[0] = 0

  result += 1
  # print(bridge, weight)
print(result)
