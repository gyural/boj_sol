N, K = map(int, input().split())

arr = list(map(int, input().split()))

diff = []
for i in range(N-1):
  diff.append(arr[i+1]- arr[i])

diff.sort(reverse = True)
result = sum(diff)
for i in range(K-1):
  result -= diff[i]

print(result)