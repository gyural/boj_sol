from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def solution(maps):
    answer = -1
    
    S = None
    E = None
    L = None
    
    YSize = len(maps)
    XSize = len(maps[0])
    
    # 1. find Start and End and Leaver
    for i in range(len(maps)):
        if S == E == L != None:
            break
        for j in range(len(maps[0])):
            if maps[i][j] == "S":
                S = (i,j)
            if maps[i][j] == "L":
                L = (i,j) 
            if maps[i][j] == "E":
                E = (i,j)
                
    # print(S, E, L)
    
    # 1. To leaver cost  (Y, X, cost, isLeaver)
    Q = deque()
    Q.append((S[0],S[1], 0))
    visit = set()
    visit.add((S[0],S[1]))
    # print(visit)
    cost_L = 10000000
    while len(Q) > 0:
        curY, curX, curCost = Q.popleft()
        # print(curY, curX, curCost, curL)
        for i in range(4):
            # 4방향 탐색
            nxtY = curY + dy[i]
            nxtX = curX + dx[i]
            
            # 1. 맵밖으로 나가는지 확인
            if (0 <= nxtY < YSize and 0 <= nxtX < XSize):
                nxtObject = maps[nxtY][nxtX]
                if nxtObject != "X":
                    if nxtObject == "L":
                        cost_L = min(cost_L, curCost +1)
                    if nxtObject == "O":
                        if (nxtY, nxtX) not in visit:
                            Q.append((nxtY, nxtX, curCost+1))
                            visit.add((nxtY, nxtX))
                    if nxtObject == "E":
                        if (nxtY, nxtX) not in visit:
                            Q.append((nxtY, nxtX, curCost+1))
                            visit.add((nxtY, nxtX))
    print(cost_L)
    if cost_L == 10000000:
        return -1
    
    # 2. 목적지까지 가보기
    Q2 = deque()
    Q2.append((L[0],L[1], 0))
    visit2 = set()
    visit2.add((L[0],L[1]))
    # print(visit)
    cost_E = 10000000
    
    while len(Q2) > 0:
        curY, curX, curCost = Q2.popleft()
        # print(curY, curX, curCost, curL)
        for i in range(4):
            # 4방향 탐색
            nxtY = curY + dy[i]
            nxtX = curX + dx[i]
            
            # 1. 맵밖으로 나가는지 확인
            if (0<= nxtY < YSize and 0 <= nxtX < XSize):
                nxtObject = maps[nxtY][nxtX]
                if nxtObject != "X":
                    if nxtObject == "O":
                        if (nxtY, nxtX) not in visit2:
                            Q2.append((nxtY, nxtX, curCost+1))
                            visit2.add((nxtY, nxtX))
                    if nxtObject == "S":
                        if (nxtY, nxtX) not in visit2:
                            Q2.append((nxtY, nxtX, curCost+1))
                            visit2.add((nxtY, nxtX))
                    if nxtObject == "E":
                        cost_E = min(cost_E, curCost +1)
    
    if cost_E == 10000000:
        return -1
    
    return cost_E + cost_L