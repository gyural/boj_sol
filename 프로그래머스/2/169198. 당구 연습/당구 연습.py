# 기울기 구하기
def getA(startP, endP):
    if (startP[1] - endP[1]) == 0:
        return None
    else:
        return 1.0 * (startP[0] - endP[0])/(startP[1] - endP[1])
def isLine(startP, midP, endP):
    # 1. 기울기가 같아야함
    
    if getA(startP, midP) == getA(midP, endP):
        # 증가 하거나 감소해야함
        if (sum(startP) > sum(midP) and sum(midP) > sum(endP)):
            return True
        elif (sum(endP) > sum(midP) and sum(midP) > sum(startP)):
            return True
        else:
            return False
    else:
        return False
    
    

def solution(m, n, startX, startY, balls):
    answer = []
    
    """벽을 4개에 각 두점의 수선의 발을 내리고 해당 범위에서 for문으로 해보면 될듯
        0 부터 m,n까지 인덱싱 가능
    """
    
    # Islnine 테스트
    
#     p1 = [3,3]
#     p2 = [3,7]
#     p3 = [3,15]
    
#     rs = isLine(p1,p2,p3)
#     print(f"result :{rs}")
    
    
    # 1. Y좌표 위에서 아래로 세기 
    startY = n - startY
    balls = [[n-b[1], b[0]] for b in balls]

    for bY, bX in balls:
        tempAnswer = 2100000000
        # 2. 4가지 벽에다가 대칭을해서 삼각형을 만들고 빗변의 길이 구하기
        # 이 때 같은 선상에 놓여져있는 벽에 경우는 벽과 현재지점 사이에 목표지점이 없는지 확인
        # 2-1 Left
        reflectY = bY
        reflectX = -bX
        flag = isLine([startY, startX], [bY, bX], [reflectY, reflectX])
        if (flag == False):
            tempAnswer = min(tempAnswer, (reflectY-startY)**2 + (reflectX-startX)**2)
        
        # 2-2 Right
        reflectY = bY
        reflectX = m + (m-bX)
        flag = isLine([startY, startX], [bY, bX], [reflectY, reflectX])
        if (flag == False):
            tempAnswer = min(tempAnswer, (reflectY-startY)**2 + (reflectX-startX)**2)
            
        # 2-3 Upper
        reflectY = -bY
        reflectX = bX
        flag = isLine([startY, startX], [bY, bX], [reflectY, reflectX])
        if (flag == False):
            tempAnswer = min(tempAnswer, (reflectY-startY)**2 + (reflectX-startX)**2)
            
        # 2-4 Down
        reflectY = n + (n-bY)
        reflectX = bX
        flag = isLine([startY, startX], [bY, bX], [reflectY, reflectX])
        if (flag == False):
            tempAnswer = min(tempAnswer, (reflectY-startY)**2 + (reflectX-startX)**2)
        
        # 3-1 0,0 대칭
        
        # 3-2 0, 10 대칭
        
        # 3-3 10, 0 대칭
        
        # 3-4 10, 10 대칭
        
        answer.append(tempAnswer)
    return answer