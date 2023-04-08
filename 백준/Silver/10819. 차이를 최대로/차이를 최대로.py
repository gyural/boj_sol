from itertools import permutations

N = int(input())
arr = list(map(int, input().split()))

result = -1

for case in permutations(arr, N):
  tmp = 0
  for j in range(N-1):
    tmp += abs(case[j] - case[j+1])
  
  result = max(result, tmp)
print(result)