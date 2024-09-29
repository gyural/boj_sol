import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

result = 0

for i in range(N):
  sum = arr[i]
  if(sum == M):
    result += 1
    continue
  for j in range(i + 1, N):
    sum += arr[j]
    if(sum >= M):
      if(sum == M):
        result += 1
      break

print(result)
