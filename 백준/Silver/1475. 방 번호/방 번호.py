target = list(input())
target = list(map(int, target))
set = [i for i in range(0, 10)]
inventory = []
#결괏값 구해주기
for i in range(1, 8):
  for card in set:
    inventory.append(card)
  ch = []
  for j in range(len(target)):
    #없앨 숫자가 6이나 9일경우
    if target[j] == 6 or target[j] == 9:
      if 6 in inventory:
        inventory.remove(6)
        ch.append(j)
      elif 9 in inventory:
        inventory.remove(9)
        ch.append(j)
    elif target[j] != -1:
      if target[j] in inventory:
        inventory.remove(target[j])
        ch.append(j)
  
  
  for d in ch:
    target[d] = -1
  
  count_minus = 0
  for k in range(len(target)):
    if target[k] == -1:
      count_minus += 1
  if count_minus == len(target):
    result = i
    break
      
print(result)