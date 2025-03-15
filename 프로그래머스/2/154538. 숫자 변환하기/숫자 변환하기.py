from collections import deque

def solution(x, y, n):
    answer = []
    
    visit = set()
    visit.add(x)
    
    Q = deque()
    Q.append((x,0)) # value 0 
    
    while len(Q) > 0:
        curValue, curDepth = Q.popleft()
        
        # print(curValue, curDepth)
        
        if y == curValue:
            return curDepth
        
        
        # 1. n 더하기
        nxtValue = curValue + n
        
        
        if nxtValue <= y and nxtValue not in visit:
            visit.add(nxtValue)
            Q.append((nxtValue, curDepth+1))
            
        # 2. 2 곱하기
        nxtValue = curValue * 2
        
        if nxtValue <= y and nxtValue not in visit:
            visit.add(nxtValue)
            Q.append((nxtValue, curDepth+1))
            
        # 3. 3 곱하기
        nxtValue = curValue * 3
        
        if nxtValue <= y and nxtValue not in visit:
            visit.add(nxtValue)
            Q.append((nxtValue, curDepth+1))
    
    
    return -1