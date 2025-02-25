def solution(diffs, times, limit):
    answer = 0
    max_answer = 100000
    min_answer = 1
    
    
    # 이분탐색을 이용
    while True:
        if max_answer < min_answer:
            break
        mid = (max_answer + min_answer) // 2
        
        # 1. 최종 소요시간 계산
        spend_time = times[0]
        
        for i in range(1, len(times)):
            #실패횟수
            falure_num = max(0, diffs[i] - mid)
            
            #이번횟수 spend_time
            failure_cost = falure_num * (times[i] + times[i-1])
            success_cost = times[i]
            
            spend_time += (failure_cost + success_cost)
        
        #최종 계산 완료 후
        if spend_time <= limit:
            #Max 조절
            max_answer = mid-1
            answer = mid
        else:
            min_answer = mid+1
                
    
    return answer