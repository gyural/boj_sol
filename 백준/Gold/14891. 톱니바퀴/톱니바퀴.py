import sys
from collections import deque


gears = []
for _ in range(4):
  gears.append(deque(list(map(int, input().rstrip()))))

K = int(input().rstrip())

for i in range(K):
  a, b = map(int, input().split())
  ch = [(False, 0)] * 5
  if a == 1:
    ch[1] = (True, b)
    if gears[0][2] != gears[1][-2]:
      ch[2] = (True, -b)
      if gears[1][2] != gears[2][-2]:
        ch[3] = (True, b)
        if gears[2][2] != gears[3][-2]:
          ch[4] = (True, -b)
  elif a == 2:
    ch[2] = (True, b)
    if gears[0][2] != gears[1][-2]:
      ch[1] = (True, -b)
    if gears[1][2] != gears[2][-2]:
      ch[3] = (True, -b)
      if gears[2][2] != gears[3][-2]:
        ch[4] = (True, b) 
  elif a == 3:
    ch[3] = (True, b)
    if gears[1][2] != gears[2][-2]:
      ch[2] = (True, -b)
      if gears[0][2] != gears[1][-2]:
        ch[1] = (True, b)
    if gears[2][2] != gears[3][-2]:
      ch[4] = (True, -b)
  else:
    ch[4] = (True, b)
    if gears[2][2] != gears[3][-2]:
      ch[3] = (True, -b)
      if gears[1][2] != gears[2][-2]:
        ch[2] = (True, b)
        if gears[0][2] != gears[1][-2]:
          ch[1] = (True, -b)
  for j in range(1, 5):
    if ch[j][0] == True:
      gears[j-1].rotate(ch[j][1])
result = 0
result += gears[0][0] * 1
result += gears[1][0] * 2
result += gears[2][0] * 4
result += gears[3][0] * 8

print(result)