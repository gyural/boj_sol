function isPar(dot1, dot2, dot3, dot4){
    //일치하는 경우에도 true리턴
    rate1 = (dot1[1] - dot2[1]) / (dot1[0] - dot2[0])
    rate2 = (dot3[1] - dot4[1]) / (dot3[0] - dot4[0])
    
    if (rate1 == rate2){
        // console.log(`${rate1} 와 ${rate2}`)
        return true
    }
    else{
        // console.log(`${rate1} 와 ${rate2}`)
        return false
    }
}

function solution(dots) {
    var answer = 0;
    let flag = false
    let ch = [0,0,0,0]
    
    for (i = 0; i < 3; i++){
        for (j = i+1; j < 4; j++){
            ch.fill(0)
            d1 = dots[i]
            d2 = dots[j]
            ch[i] = 1
            ch[j] = 1
            flag = false
            for(k = 0; k < 4; k++){
                if (ch[k] == 0){
                    if (flag == false){
                        d3 = dots[k]
                        flag = true
                    }
                    else{
                        d4 = dots[k]
                    }
                }
            }
            // console.log(ch)
            //내개의 점에 직선 할당 완료
            if (isPar(d1, d2, d3, d4) == true){
                answer = 1
                break
            }
            
        }
    }
    return answer;
}