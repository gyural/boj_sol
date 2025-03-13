from collections import deque

N = int(input())
seq = list(map(int, input().split()))
answer = [-1] * len(seq)

S = deque()
S.append((seq[0], 0))

for idx in range(1, len(seq)):
  curValue = seq[idx]
  while len(S) > 0:
    topValue, topIdx = S[-1]

    if topValue < curValue:
      answer[topIdx] = curValue
      S.pop()
    else:
      break

  S.append((curValue, idx))

for v in answer:
  print(f"{v} ", end="")