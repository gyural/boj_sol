import sys
input = sys.stdin.readline
# 산술평균 : N개의 수들의 합을 N으로 나눈 값
# 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
# 최빈값 : N개의 수들 중 가장 많이 나타나는 값
# 범위 : N개의 수들 중 최댓값과 최솟값의 차이
        
N = int(input())
arr = []

for i in range(N):
  arr.append(int(input()))
arr.sort()

print(int(round(sum(arr)/N,0)))
print(arr[N//2])
# 최빈값 리스트들
sum_arr = [1] * N
sum_arr[0] = 1
for i in range(1, N):
  if(arr[i] == arr[i-1]):
    sum_arr[i] = sum_arr[i-1] + 1

max_count = max(sum_arr)
counting = 0
for idx, val in enumerate(sum_arr):
  if val == max_count:
    if(counting == 1):
      max_exist_value = arr[idx]
      break
    counting += 1
    max_exist_value = arr[idx]

print(max_exist_value)
print(max(arr) - min(arr))


