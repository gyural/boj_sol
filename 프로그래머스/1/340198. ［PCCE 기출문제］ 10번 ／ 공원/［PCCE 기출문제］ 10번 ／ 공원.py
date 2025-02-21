#방향 벡터
def isOutSide(target_point, y_size, x_size):
    if target_point[0] < 0 or target_point[0] >= y_size:
        return False
    
    if target_point[1] < 0 or target_point[1] >= x_size:
        return False
    
    return True
        

def get_mat_indexes(start_point, size):
    
    result = []
    for i in range(size):
        for j in range(size):
            result.append([start_point[0]+i, start_point[1]+j])
            
    
    if len(result) == 0:
        result.append(start_point)
    
    return result

def solution(mats, park):
    answer = -1
    
    for y in range(len(park)):
        for x in range(len(park[0])):
            
            if (park[y][x] != "-1"):
                continue
                
            for size in mats:
                target_points = get_mat_indexes([y, x], size)
                
                # print(target_points)

                count = 0
                # 비어있는지와 맵을 넘어가는지 확인 하기
                for t_point in target_points:
                    
                    
                    if (isOutSide(t_point, len(park), len(park[0])) and park[t_point[0]][t_point[1]] == "-1"):
                        count += 1
                        # print(target_points[0])
                    else:
                        break

                # 해당 사이즈의 돗자리가 가능한지 체크        
                if (count == len(target_points)):
                    print()
                    answer = max(answer, size)

                count = 0
                
        
#         print(get_mat_indexes([0,0], size))
#         print(len(get_mat_indexes([0,0], size)))
        
#         print("-------------------------------------")

        
        
    #모든 돗자리 탐색 완료 후
    
    return answer