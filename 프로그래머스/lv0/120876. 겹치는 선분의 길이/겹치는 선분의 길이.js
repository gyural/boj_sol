function solution(lines) {
    var answer = 0;
    
    let st = 2100000000
    let end = -2100000000
    for (i = 0; i < 3; i++){
        for (j = 0; j < 2; j++){
            st = Math.min(st, lines[i][j])
            end = Math.max(end, lines[i][j])
        }
    }
    
    //st부터 end까지 각 1길이 단위당 겹치는지를 확인
    for(i = st; i < end; i++){
        count = 0
        for(k = 0; k < 3; k++){
            if (lines[k][0] <= i && i+1 <= lines[k][1]){
                count += 1
            }
        }
        if (count > 1){
            answer += 1
        }
    }
    
    return answer;
}