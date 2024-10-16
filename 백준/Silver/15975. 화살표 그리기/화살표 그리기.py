import sys
input = sys.stdin.readline

N = int(input().rstrip())
# N개의 색 종류



arr = []

for i in range(N):
  a, b = map(int, input().split())
  arr.append((a,b))


arr.sort(key=lambda x: x[0])
arr.sort(key=lambda x: x[1])

# print(arr)

result = 0
if(N > 1 and arr[0][1] == arr[1][1]):
  result += abs(arr[1][0] - arr[0][0])

if(N > 1 and arr[N-2][1] == arr[N-1][1]):
  result += abs(arr[N-1][0] - arr[N-2][0])

for i in range(1, N-1):
  val, color = arr[i]
  
  left, right = False, False
  if(color == arr[i+1][1]):
    left = True
    candi1 = abs(arr[i+1][0] - val)
  if(color == arr[i-1][1]):
    right = True
    candi2 = abs(val - arr[i-1][0])


  if(left == True and right == True):
    result += min(candi1, candi2)
  elif(left == True and right == False):
    result += candi1
  elif(left == False and right == True):
    result += candi2
     

print(result)
  
  