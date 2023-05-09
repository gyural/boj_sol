import sys

input = sys.stdin.readline

N, M = map(int, input().split())
S = []
T = []

for _ in range(N):
  S.append(input().rstrip())

S.sort()
for _ in range(M):
  T.append(input().rstrip())
T.sort()

result = 0
before = 0
for i in range(M):
  key = T[i]
  #이분 탐색으로 S에서 key 찾기
  start = before
  end = N-1
  while (start <= end):
    mid = (start + end) // 2
    if S[mid] == key:
      result += 1
      before = mid
      break
    elif S[mid] < key:
      start = mid + 1
    else:
      end = mid - 1

print(result)
  