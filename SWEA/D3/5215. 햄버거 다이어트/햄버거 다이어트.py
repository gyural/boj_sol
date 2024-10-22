#0001
def DFS(value, depth, score):
    if depth >= N:
        return
    sum_ingre = value + taste_arr[depth][1]
    sum_score = score + taste_arr[depth][0]
    
    if sum_ingre <= max_kcal:
        result.append((sum_ingre, sum_score))
        DFS(sum_ingre, depth+1, sum_score)
    
    DFS(value, depth+1, score)

T = int(input())

for t in range(T):
    N, max_kcal = map(int, input().split())
    taste_arr =[]
    for i in range(N):
    	taste, kcal = map(int, input().split())
    	taste_arr.append((taste, kcal))
    
    result = []
    DFS(0, 0, 0)
    #print(result)
    if(len(result) == 0):
        print(f"#{t+1} 0")
    else:
    	fiinal_result = [val[1] for val in result]
    	print(f"#{t+1}", max(fiinal_result))