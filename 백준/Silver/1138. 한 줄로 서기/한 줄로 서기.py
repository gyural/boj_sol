import sys
import itertools
input = sys.stdin.readline

N = (int(input().rstrip()))
memor = list(map(int, input().split()))

result = [0] * N
for i in range(1, N+1):
  left = memor[i-1]
  count = 0
  for j in range(N):
    #처음 위치에 들어가는 경우
    if left == count:
      if result[j] == 0:
        result[j] = i
        break
      else:
        continue  
    if result[j] == 0:
      count+=1
for r in result:
  print(r, end = ' ')