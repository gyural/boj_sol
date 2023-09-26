const isGeometricSequence = (sequence) =>{
    const len = sequence.length
    if (sequence[len-2] / sequence[len-1] === sequence[len-3] / sequence[len-2]){
        return true
    }else{
        return false
    }
    
}

function solution(common) {
    const isGeo =  isGeometricSequence(common)
    var answer = 0;
    const len = common.length
    if (isGeo === true){
//         등비수열일 때
        const diff = common[len-1] / common[len-2]
        answer = common[len-1] * diff
    }else{
//         등차수열일 때
        const diff = common[len-1] - common[len-2]
        answer = common[len-1] + diff
    }
    return answer;
}