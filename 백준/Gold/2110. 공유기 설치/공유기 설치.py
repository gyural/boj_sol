import sys
input = sys.stdin.readline
N, C = map(int, input().split()) 
home = []
for _ in range(N):
  home.append(int(input().rstrip()))
#집 리스트 정렬
home.sort()
#이분 탐색으로 결괏값 도출하기
start = 1
end = home[N-1]- home[0]
result = 1
while start <= end:
  #종료 코드
  if start > end:
    break
  mid = (start + end) // 2
  #mid를 최소거리로 해서 설치할 수 있는 최대 공유기개수 count해주기
  bef = home[0]
  count = 1
  for k in home[1:]:
    if k - bef >= mid:
      count += 1
      bef = k
  if count >= C:
    start = mid+1
    result = mid
  else:
    end = mid-1
      
print(result)