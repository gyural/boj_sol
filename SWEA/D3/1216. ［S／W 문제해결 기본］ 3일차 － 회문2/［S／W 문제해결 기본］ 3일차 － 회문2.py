for _ in range(1, 11):
    t = int(input())
    arr =[]
    
    for _ in range(100):
        line = list(input())
        arr.append(line)
    
    result = -1
	
    for target in range(100, 0, -1):#100부터 1까지
        if (result > -1):
            break
        for i in range(100):#행으로 보기 i번째 행
            for j in range(0, 100-target+1):
                if arr[i][j] == arr[i][target + j -1]: #첫글자와 마지막글자가 같다면 깊은 판별시작
                    targetArray = arr[i][j:j+target]
                    if (targetArray == targetArray[::-1]):
                        result = target
                        break
            if(result > -1):
                break
        for i in range(100):#열으로 보기 i번째 열
            for j in range(0, 100-target+1):
                if arr[j][i] == arr[target + j -1][i]: #첫글자와 마지막글자가 같다면 깊은 판별시작
                    targetArray = [arr[k][i] for k in range(j, j+target)]
                    if (targetArray == targetArray[::-1]):
                        result = target
                        break
            if(result > -1):
                break
    print(f"#{t} {result}")
    