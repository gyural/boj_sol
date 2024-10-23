for _ in range(10):
    t = int(input())
    matrix = []
    for _ in range(100):
        matrix.append(list(map(int, input().split())))
    
    result_max = -2100000000
    cross_left = 0
    cross_right = 0
    for i in range(100):
        #각행의 값중 max구하기
        result_max = max(result_max, sum(matrix[i]))
        #열 배열
        col_arr = [ matrix[j][i] for j in range(100)]
        result_max = max(result_max, sum(col_arr))
        
        cross_left += matrix[i][i]
        cross_right += matrix[i][99-i]
    result_max = max(cross_left, result_max)
    result_max = max(cross_right, result_max)
    print(f"#{t}", result_max)