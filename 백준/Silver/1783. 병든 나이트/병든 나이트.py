N, M = map(int , input().split())

if N >= 3:
  if M >= 8:
    result = M-8+1+5
  elif M == 7:
    result = 5
  elif M >= 4:
    result = 4
  else:
    result = M
else:
  if N == 2:
    if M < 3:
      result = 1
    else:
      if M // 2 == 0:
        result = (M-2) // 2 + 1
      else:
        result = (M-1) // 2 + 1
    if result > 4:
      result = 4
  else:
    result = 1
print(result)