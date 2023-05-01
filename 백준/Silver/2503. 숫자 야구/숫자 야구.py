import sys
import itertools
import copy
input = sys.stdin.readline

arr = ['1','2','3','4','5','6','7','8','9']
candi = list(itertools.permutations(arr,3))
N = int(input().rstrip())
for _ in range(N):
  num, s, b = map(int, input().split())
  num = str(num)
  num = list(num)
  tmp = list()
  for c in candi:
    strike, ball = 0, 0
    for i in range(3):
      if c[i] == num[i]:
        strike += 1
      elif c[i] in num:
        ball += 1
    if strike == s and ball == b:
      tmp.append(c)
  candi = list()
  candi = copy.deepcopy(tmp)
      

print(len(candi))