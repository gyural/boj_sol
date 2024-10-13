import sys

input = sys.stdin.readline
tree = []
myObj = dict()
size = 0
while(True):
  tree_one = input()
  tree_one = tree_one[:-1]
  if tree_one == '':
    break
  size += 1
  if tree_one in myObj.keys():
    myObj[tree_one] += 1
  else:
    myObj[tree_one] = 1
  
result_arr = []
for tree in myObj:
  result_arr.append((tree, round(myObj[tree] / size * 100, 4)))

result_arr.sort(key = lambda x: x[0])
for item in result_arr:
  print(f"{item[0]} {item[1]:.4f}")