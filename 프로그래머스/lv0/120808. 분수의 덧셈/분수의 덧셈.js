const minimize = (numer1, denom1) =>{
    //작은수를 target으로 해주기
    let res1 = numer1;
    let res2 = denom1;
    const target = Math.min(numer1, denom1)
    
    if (target === 1){
        return [res1, res2]
    }
    for (divi = 2; divi <= target; divi++){
        if (numer1 % divi === 0 &&  denom1 % divi === 0){
            //minimize 가능할 때
            return minimize(numer1 / divi, denom1 / divi)
        }
    }
    return [res1, res2]
    
    
}
function solution(numer1, denom1, numer2, denom2) {
    var answer = [];
    
    answer = [...minimize(numer1 * denom2 + numer2 * denom1, denom1 * denom2)]
    return answer;
}