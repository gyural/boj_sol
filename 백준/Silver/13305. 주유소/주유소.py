# 입력
# 표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다. 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다. 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다. 

# 출력
# 표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다

result = 0
n = int(input())
min = 1000000001
min_list = [0] * n
town_list = [0] * n
distance_list = [0] * n

distance_list = list(map(int, input().split()))
town_list = list(map(int, input().split()))

#min_list구하기
for i in range(n):
  if(min > town_list[i]):
    min = town_list[i]
    min_list[i] = min
  else:
    min_list[i] = min

#result 구하기
for i in range(n-1):
  result += min_list[i] * distance_list[i]

print(result)