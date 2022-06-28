#입력
# 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

#출력
# 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

n = int(input())

meeting_list = [[0] * 2 for _ in range(n)]

for i  in range(n):
  start, end = map(int , input().split())
  meeting_list[i][0] = start
  meeting_list[i][1] = end

meeting_list.sort(key = lambda x: x[0])
meeting_list.sort(key = lambda x: x[1])

last = 0
result = 0
for i in range(n):
  if last <= meeting_list[i][0]:
    result += 1
    last = meeting_list[i][1]

print(result)
  
