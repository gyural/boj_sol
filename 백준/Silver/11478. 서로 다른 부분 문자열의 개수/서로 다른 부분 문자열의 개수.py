import sys

input = sys.stdin.readline

str = input().rstrip()

str_arr = list(str)
subset = set()
for i in range(1, len(str_arr)+1):
  for j in range(len(str_arr)):
    if(i+j <= len(str_arr)):
      subset.add(''.join(str_arr[j:j+i]))
    else:
      continue

# print(subset)
print(len(subset))