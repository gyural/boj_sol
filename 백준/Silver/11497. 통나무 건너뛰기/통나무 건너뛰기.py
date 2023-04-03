import sys
from collections import deque
input = sys.stdin.readline
T = int(input().rstrip())

for _ in range(T):
  N = int(input().rstrip())
  arr = list(map(int, input().split()))
  result = deque([])
  arr.sort(reverse = True)

  nxt = 1
  for i in range(N):
    if nxt == 1:
      result.append(arr[i])
      nxt *= -1
    else:
      result.appendleft(arr[i])
      nxt *= -1
  max_value = abs(result[0] - result[-1])
  for i in range(N-1):
    max_value = max(max_value, abs(result[i] - result[i+1]))
  print(max_value)