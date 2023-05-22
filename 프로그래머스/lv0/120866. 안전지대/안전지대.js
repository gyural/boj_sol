function solution(board) {
    var answer = 0;
    dy = [-1, -1, -1, 0, 0, 1, 1, 1]
    dx = [-1, 0, 1, -1, 1, -1, 0, 1]
    n = board[0].length
    //위험 지역 표시하기
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (board[i][j] == 1){
                for (d = 0; d < 8; d++){
                    newY = i + dy[d]
                    newX = j + dx[d]
                    if(newY >= 0 && newY < n && newX >= 0 && newX < n ){
                        if (board[newY][newX] != 1){
                            board[newY][newX] = 2  
                        }
                    }
                }
            }
        }
    }
    for(i = 0; i < n; i++){
            console.log(board[i])
            }
    //위험지역 count해주기
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            if (board[i][j] == 0){
                answer += 1
            }
        }
    }
    
    return answer;
}