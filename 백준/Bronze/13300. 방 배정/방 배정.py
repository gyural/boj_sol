import sys

input = sys.stdin.readline
N, k = map(int, input().split())
#각 인덱스 번호는 학년을 의미
#student[학년][여자 0 남자 1 ]
student = [[0,0] for _ in range(7)]

for _ in range(N):
  a, b = map(int, input().split())
  student[b][a] += 1

result = 0
for i in range(1, 7):
  for j in range(2):
    if student[i][j] != 0:
      if student[i][j] % k != 0:
        result += student[i][j] // k + 1
      else:
        result += student[i][j] // k
print(result)
