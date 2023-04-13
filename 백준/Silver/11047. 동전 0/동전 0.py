import sys

input = sys.stdin.readline

N, target = map(int, input().split())
coins = []
for _ in range(N):
  coins.append(int(input().rstrip()))


result = 0
for coin in coins[::-1]:
  if target <= 0:
    break
  if coin <= target:
    result += target // coin
    target = target % coin

print(result)