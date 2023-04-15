import sys

input = sys.stdin.readline

N = int(input().rstrip())

dp = [[1] * 10 for i in range(1004)]

for i in range(10):
  dp[0][i] = 0
  dp[2][i] = i+1

#N번 까지 바텀업으로 배열 채우기
for i in range(3, N+2):
  for j in range(10):
    tmp = 0
    for k in dp[i-1][:j+1]:
      tmp += k
    dp[i][j] = tmp

print(dp[N+1][9] % 10007)