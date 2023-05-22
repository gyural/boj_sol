function contain(num){
    num = String(num)
    if(num.includes('3')){
        return true
    }
    else{
        return false
    }
}
function next(num){
    //num보다 큰 수중 제일 가까운 수중에 3의 배수가 아닌수를 리턴
    while(true){
        num += 1
        if (num % 3 != 0 && contain(num) == false){
            return num
        }
    }
}

function solution(n) {
    var answer = 0;
    answer = 1
    for (i = 1; i < n; i++){
        answer = next(answer)
    }
    return answer;
}