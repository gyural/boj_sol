def solution(sequence, k):
    answer = [1, 10000000]
    
    min_size = answer[1] - answer[0]
    
    start = 0
    end = 0
    
    size = len(sequence)
    
    # 누적합 구하기
    seq_sum = [sequence[0]]
    for i in range(1, len(sequence)):
        value= sequence[i] + seq_sum[i-1]
        seq_sum.append(value)
                
    
    while (start < size and end < size):
        # 1. 구간합 계산
        if start == end: # 범위가 1일 때
            if end == 0:
                temp = seq_sum[0]
            else:
                temp = seq_sum[end] - seq_sum[end-1]
        
        else:
            if start == 0:
                temp = seq_sum[end]
            else:
                temp = seq_sum[end] - seq_sum[start-1]
        
        # print(temp)
        
        # 2. 구간합에따른 포인터 이동
        if temp == k: # 목표값 같을 때
            # 범위 크기 확인
            if (min_size > (end - start)):
                answer[0], answer[1] = start, end
                min_size = end - start
            end +=1
        
        if temp < k: # 목표값 보다 작을 때
            end +=1
        
        if temp > k : # 목표값 보다 클 때
            start +=1 
    
    return answer