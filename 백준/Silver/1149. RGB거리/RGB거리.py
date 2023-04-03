import sys

N = int(sys.stdin.readline().rstrip())

color = list()


for i in range(N):
  color.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * 3 for _ in range(N)]
dp[0][0] = color[0][0]
dp[0][1] = color[0][1]
dp[0][2] = color[0][2]

#바텀업 방식으로 dp채우기

for i in range(1, N):
  
  dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + color[i][0]
  dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + color[i][1]
  dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + color[i][2]
  


print(min(dp[N-1]))