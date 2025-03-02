from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def solution(board):
    answer = 2100000000
    
    """
    KEY : visit 배열에 방문했을 때 이동방향도 저장하기..!!
    """
    
    """
    visit = [cost, [y,x], direction] 
    """
    sizeY = len(board)
    sizeX = len(board[0])
    
    visit = []
    Q = deque()
    
    # 1. start point
    start = None
    for i in range(len(board)):
        if start != None:
            break
        for j in range(len(board[0])):
            if board[i][j] == "R":
                start = [i,j]
    
    
    """
    visit = [[y,x], direction]
    Q = [cost, [y,x]]
    """
    Q.appendleft([0, [start[0], start[1]]])
    
    # 2. start BFS
    
    
    while len(Q) > 0:
        #다음 탐색 지점
        curCost, curPos = Q.pop()
        # print(f"curCost:{curCost} curPos:{curPos}")
        # 2-1 4방향에 대해 탐색
        for i in range(4):
            nxtCost = curCost + 1
            
            #2-1-1 Object가 있을 때 까지 이동 후 다음 위치 계산
            nxtPos = None
            
            nxtY = curPos[0] 
            nxtX = curPos[1]
            while True:
                
                nxtY = dy[i] + nxtY 
                nxtX = dx[i] + nxtX
                # print(f"nxtY: {nxtY} nxtX: {nxtX}")
                
                # 2-1-1 맵을 벗어 나는지 확인
                if 0 <= nxtY < sizeY and 0 <= nxtX < sizeX:
                    # 2-1-1-2 D에 막혔는지 확인
                    if board[nxtY][nxtX] == "D":
                        # 이전포지션으로 nxtPos
                        nxtPos = [nxtY-dy[i], nxtX-dx[i]]
                        break
                # 2-1 맵을 벗어난다면 가장자리에 막혔는지 확인
                else:
                    # 이전포지션으로 nxtPos
                    nxtPos = [nxtY-dy[i], nxtX-dx[i]]
                    break
                
                        
            
            # 2-1-2 이동이 가능한 경우 큐에 추가 가능
            if nxtPos != None:
                # 목표지점이라면
                if board[nxtPos[0]][nxtPos[1]] == "G":
                    return curCost + 1 
                
                # 2-1-3 visit이력 있는지 확인
                """
                visit = [[y,x], direction]
                Q = [cost, [y,x]]
                """
                if [[nxtPos[0], nxtPos[1]], i] not in visit:
                    visit.append([[nxtPos[0], nxtPos[1]], i])
                    Q.appendleft([curCost+1, [nxtPos[0], nxtPos[1]]])
                    # print(f"append {nxtPos} d : {i}")
                    
                
                
    if answer == 2100000000:
        answer = -1
    
    return answer