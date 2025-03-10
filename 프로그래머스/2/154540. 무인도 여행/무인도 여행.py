from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def solution(maps):
    answer = []
    
    visit = set()
    YSize = len(maps)
    XSize = len(maps[0])
    
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            curPos = maps[i][j]
            if curPos != "X" and (i, j) not in visit:
                
                Q = deque()
                visit.add((i,j))
                Q.append((i,j))
                
                tmpSum = int(maps[i][j])
                
                # BFS탐색 시작
                while len(Q) > 0:
                    curY, curX = Q.popleft()
                    for k in range(4):
                        nxtY = curY + dy[k]
                        nxtX = curX + dx[k]
                        
                        # 맵밖을 벗어나는지 확인
                        if 0 <= nxtY < YSize and 0 <= nxtX < XSize:
                            if maps[nxtY][nxtX] != "X" and (nxtY, nxtX) not in visit:
                                visit.add((nxtY, nxtX))
                                Q.append((nxtY, nxtX))
                                tmpSum += int(maps[nxtY][nxtX])
                answer.append(tmpSum)
    
    if len(answer) == 0:
        answer = [-1]
    else:
        answer.sort()
    return answer