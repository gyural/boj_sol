def getMinutes(time_string):
    h, m = time_string.split(":")
    return int(h) * 60 + int(m)

def solution(book_time):
    answer = 0
    
    # 1. 전처리 
    # 1. 분으로 합쳐줌
    for idx, time in enumerate(book_time):
        s, e = time
        book_time[idx] = [getMinutes(s), getMinutes(e) + 10]
        
    
    book_time.sort()
    print(book_time)
    
    # 순회 시작 EndTime
    STime, ETime = book_time[0][0], book_time[-1][1]
    
    print(STime, ETime)
    # 청소시간만큼 더하기
    
    
    
    # 00 00 ~ 23 59 까지 겹치는 시간 최대개수가 answer가 됨
    # exit Time 이 targetTime보다 크기만 하면 사용중임
    # exitTime > targetTime 
    # exitTime == targetTime과 같은경우는 신경안씀-> 이미 나가고 청소도 완료함
    
    for target_T in range(STime, ETime+1):
        temp_count = 0
        for time_range in book_time:
            s, e = time_range
            
            if  s <= target_T < e:
                temp_count +=1
        answer = max(temp_count, answer)
    
    return answer

    