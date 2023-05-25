import sys

input = sys.stdin.readline
N, H = map(int, input().split())
upper = [0 for _ in range(H)]
under = [0 for _ in range(H)]

for i in range(N):
  tmp = int(input().rstrip())
  if (i % 2 == 0):
    under[H-tmp] += 1
  else:
    upper[tmp-1]  += 1


#누적합 해주기
for i in range(0, H-1):
  under[i+1] += under[i]
for i in range(H-2, -1, -1):
  upper[i] += upper[i+1]
cnt = 0
result = [N, cnt]
#최솟값 계산해주기
for i in range(H):
  wall = under[i] + upper[i]
  if result[0] > wall:
    result[0] = wall
    result[1] = 1
  elif result[0] == wall:
      result[1] += 1

print(result[0], result[1])


