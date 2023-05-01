import sys

def cmp(a, b):
  if a[0] > b[0]:
    return True
  elif a[0] == b[0]:
    if a[1] > b[1]:
      return True
    elif a[1] == b[1]:
      if a[2] > b[2]:
        return True
  return False
input = sys.stdin.readline
N, K = map(int, input().split())
nation = [0] * (N+1)
for _ in range(N):
  tmp = list(map(int, input().split()))
  nation[tmp[0]] = tmp[1:]
nation = nation[1:]

target = nation[K-1]
result = 1
for i in range(N):
  if cmp(nation[i], target) == True:
    result += 1

print(result)
