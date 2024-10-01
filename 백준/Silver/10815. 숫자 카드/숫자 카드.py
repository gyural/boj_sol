import sys
from bisect import bisect_left
input = sys.stdin.readline


N = int(input())
arr1 = set(map(int, input().split()))

M = int(input())
arr2 = list(map(int, input().split()))

for val in arr2:
  if val in arr1:
    print(1, end=" ")
  else:
    print(0, end=" ")

