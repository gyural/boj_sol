import sys
import heapq

input = sys.stdin.readline

arr_count = [0] * 10001
# heapq.heappush(heap, 50)
# heapq.heappush(heap, 10)
# heapq.heappush(heap, 20)

N = int(input())
for i in range(N):
  val = int(input())
  arr_count[val] += 1


for idx, cnt in enumerate(arr_count[1:]):
  if cnt > 0:
    for i in range(cnt):
      print(idx+1)