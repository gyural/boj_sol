import sys

input = sys.stdin.readline


leftStack = list(input().rstrip())
rightStack = []

T = int(input().rstrip())

for i in range(T):
  cmd_string = input().rstrip()
  cmd_list = cmd_string.split(" ")
  cmd = cmd_list[0]
  if(cmd == 'L'):
    if(len(leftStack) > 0):
      rightStack.append(leftStack.pop())
  elif cmd == 'D':
    if(len(rightStack) > 0):
      leftStack.append(rightStack.pop())
  elif cmd == 'B':
    if(len(leftStack)>0):
      leftStack.pop()
  elif cmd == 'P':
    leftStack.append(cmd_list[1])

rightStack.reverse()
print(''.join(leftStack)+''.join(list(rightStack)))

# abc
# 9
# L
# L
# L
# L
# L
# P x
# L
# B
# P y
  