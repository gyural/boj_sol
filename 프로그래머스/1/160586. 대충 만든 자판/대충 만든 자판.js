function solution(keymap, targets) {
    var answer = [];
    const mainMap = {}
    
    keymap.forEach((key)=>{
        key.split('').forEach((alpha, idx)=>{
            if(alpha in mainMap === false){
                mainMap[alpha] = idx+1
            }
            if(idx+1 < mainMap[alpha]){
                mainMap[alpha] = idx+1
            }
        })
    })
    targets.forEach((sentence)=>{
        let tmp = 0
        for(alpha of sentence){
            if(alpha in mainMap === false){
                tmp = -1
                break
            }
            tmp += mainMap[alpha]
        }
            
        answer.push(tmp)
    })
    return answer;
}