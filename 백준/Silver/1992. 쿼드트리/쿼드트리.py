import sys

input = sys.stdin.readline

N = int(input().rstrip())
arr = []
result = []
for i in range(1, N+1):
  tmp = input().rstrip()
  arr.append(list(map(int, tmp)))

#압축할 크기와 시작점을 알려주고 압축하

#현재 사이즈의 크기로 압축이 가능한지 확인하는 함수
def is_small(size, start):
  tmp = arr[start[0]][start[1]]
  for i in range(start[0], start[0] + size):
    for j in range(start[1], start[1]+ size):
      if arr[i][j] != tmp:
        return False

  return True
#size와 start인덱스를 바탕으로 압축하기
def DFS(size, start):
  #현재 사이즈로 압축이 가능하다면 압축
  if is_small(size, start) == True:
    result.append(arr[start[0]][start[1]])
    return
  #압축이 불가능하다면 4방향으로 나눠서 4번씩 압축
  #왼쪽 위
  result.append('(')
  new_size = size // 2
  DFS(new_size, start)
  #오른쪽 위
  new = [start[0], start[1] + new_size]
  DFS(new_size, new)
  #왼쪽 아래
  new = [start[0]+ new_size, start[1]]
  DFS(new_size, new)
  #오른쪽 아래
  new = [start[0]+ new_size, start[1] + new_size]
  DFS(new_size, new)
  result.append(')')

s = [0,0]
DFS(N, s)
result = ''.join(str(s) for s in result)
print(result)