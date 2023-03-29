S = list(input())
T = list(input())

k = len(T) - len(S)

for i in range(k):
  if T[-1] == 'A':
    T.pop()
  else:
    T.pop()
    T = T[::-1]

if S == T:
  print(1)
else:
  print(0)