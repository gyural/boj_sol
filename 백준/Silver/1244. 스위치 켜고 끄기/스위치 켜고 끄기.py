import sys

input = sys.stdin.readline

def turn(switch, idx):
  if(switch[idx] == 0):
    switch[idx] = 1
  else:
    switch[idx] = 0
def man_switching(card, switch):
  for i in range(card-1, len(switch), card):
    turn(switch, i)
    
def woman_switching(card, switch):
  left = card -2
  right = card
  turn(switch, card-1)
  for i in range(1, len(switch)):
    left = card - 1 - i
    right = card -1 + i
    if(left < 0 or right >= len(switch)):
      return
    if(switch[left] == switch[right]):
      turn(switch, left)
      turn(switch, right)
    else:
      return
    
num = int(input())
switch = list(map(int, input().split()))

student_num = int(input())

for i in range(student_num):
  gender, card = map(int, input().split())
  if(gender == 1):
    man_switching(card, switch)
  else:
    woman_switching(card, switch)

for idx, val in enumerate(switch):
  if(idx % 20 == 0 and idx != 0):
    print()
    
  print(val, end=" ")