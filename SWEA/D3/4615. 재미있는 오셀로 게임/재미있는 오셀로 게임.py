dy = [-1, -1, -1, 0, 0, 1, 1, 1 ]
dx = [-1, 0, 1, -1, 1, -1, 0, 1]

def countBlackNWhite(matrix, N):
    blackNum = 0
    whiteNum = 0
    for i in range(N):
        for j in range(N):
            if(matrix[i][j] == 1):
                blackNum += 1
            elif(matrix[i][j] == 2):
                whiteNum += 1
    return (blackNum, whiteNum)

def findSameColorPlage(current, d, matrix, currentColor, N): #뒤집을 곳의 마지막 위치를 찾아주는 함수
    curY, curX = current
    visit = []

    while(True):
        nxtY, nxtX =  curY+dy[d], curX+dx[d]
        if not (0<= nxtY < N and 0<= nxtX < N): #범위 확인
            return

        nxtColor = matrix[nxtY][nxtX]

        if(nxtColor != -1 and nxtColor == currentColor):
            for y, x in visit:
                matrix[y][x] = currentColor
            return
        elif(nxtColor != -1 and nxtColor != currentColor): #뒤집기
            visit.append((nxtY, nxtX)) #뒤집기 후보에 올림
            curY, curX = nxtY, nxtX
        else:
            return





T = int(input())


for t in range(T):
    #방향은 현재 기준 상 중 하 8개임

    black = 1
    white = 2
    N, M = map(int ,input().split())

    matrix = [[-1] * N for _ in range(N)] 

    start = N//2  #초기 돌 넣기 오른쪽 아래 부터
    matrix[start][start] = white
    matrix[start-1][start-1] = white
    matrix[start][start-1] = black
    matrix[start-1][start] = black

    for _ in range(M):
        x, y, currentColor = map(int, input().split())
        x, y = x-1, y -1 # 인덱싱 전처리
        matrix[y][x] = currentColor
        
        for d in range(8):
            nxtY, nxtX = y+dy[d], x+dx[d]
            if(0<= nxtY < N and 0<= nxtX < N): #범위 확인
                nxtColor = matrix[nxtY][nxtX]
                if(nxtColor != -1 and nxtColor != currentColor): #뒤집을 수 있음
                    findSameColorPlage((y,x), d, matrix, currentColor, N)
        
        # print()
        # for i in range(N):
        #     for j in range(N):
        #         print(f"{matrix[i][j]:2d} ", end="")
        #     print()
    blackNum, whiteNum = countBlackNWhite(matrix, N)


    print(f"#{t+1} {blackNum} {whiteNum}")