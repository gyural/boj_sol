from collections import deque


def minusMinute(leftTime, rightTime):
    leftTotalMinutes = leftTime // 100 * 60 + leftTime % 100
    rightTotalMinutes = rightTime // 100 * 60 + rightTime % 100
    
    diffMinutes = leftTotalMinutes - rightTotalMinutes
    
    
    return diffMinutes
    
    
def plusMinute(hhmm, plusTime):
    # hhmm -> mm 1130 , 45일 때 작동안함
    leftMinutes = hhmm % 100
    leftHours = hhmm // 100
    sumMinutes  = leftMinutes + plusTime
    
    AfterMinutes = sumMinutes % 60
    plusHours = sumMinutes // 60
    
    return leftHours*100 + plusHours*100 + AfterMinutes
    
def solution(plans):
    answer = []
    
    # plans 숫자 데이터로 전처리
    for idx, p in enumerate(plans):
        startHour, startMinute = p[1].split(":")
        startTime_int = int(startHour) * 100 + int(startMinute)
        
        plans[idx] = [p[0], startTime_int, int(p[2])]
        
    # 시작 순서로 sorting
    plans.sort(key = lambda x:x[1])
    print(plans)
    
    # 초기 값 세팅
    curTime = plans[0][1]
    
    pausedJob = deque()
    plans = deque(plans)
    
    
    
    while True:
        
        # 1. 수행할 Job 스케줄링
        # 1-1. 새로 수행할 작업이 있을 때
        if len(plans) > 0:
            #1-1-1. 현재 시간이 시작시간보다 이를 때
            if curTime < plans[0][1]:
    
                # pausedJob에서 스케줄링 에러 가능함!!!! -->
                if len(pausedJob) > 0:
                    curJob = pausedJob.popleft()
                else:
                    curJob = plans.popleft()
                    curTime = curJob[1]
            # 1-1-2. 현재 시간이 시작시간에 다달랐을 때
            else:
                curJob = plans.popleft()
                
        # 1-2. 새로 수행할 작업은 없고 pausedJob에 있을 때
        elif len(pausedJob) > 0:
            curJob = pausedJob.popleft()
        # 1-3 수행할 job이 없을 때
        else:
            break
        
        # 2. spendTime계산
        
        # 2-1 새로 시작할 Job이 있을 때
        if len(plans) > 0:
            nxtTime = plans[0][1]
            
            spendTime = min(curJob[2], minusMinute(nxtTime,curTime))
        
        # 2-2 새로 시작할 Job이 없을 때
        else:
            spendTime = curJob[2]
        
        print(f"curTime: {curTime} curJob: {curJob[0]} spend: {spendTime}")
        # 3. 실제 작업 수행
        
        # 3-1 현재 작업을 완료 했을 때
        if spendTime == curJob[2]:
            answer.append(curJob[0])
        
        # 3-2 현재 작업을 미완료 했을 때
        else:
            pausedJob.appendleft([curJob[0], curJob[1], curJob[2]-spendTime])
        
        # 4. 시간 증가
        curTime = plusMinute(curTime, spendTime)
        
    return answer