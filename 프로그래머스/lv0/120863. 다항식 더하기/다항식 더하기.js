function solution(polynomial) {
    var answer = '';
    //계수를 저장해주는 변수 rank
    let rank = 0
    let constant = 0
    let arr = polynomial.split(' + ')
    console.log(arr)
    for (el of arr){
        if(el.includes('x') == false){
            constant += parseInt(el)
        }
        else{
            if (el[0] == 'x'){
                rank += 1
            }
            else{
                rank += parseInt(el)
            }
        }
        
    }
    if (rank != 0){
        if (rank != 1){
            answer += String(rank)    
            }
        answer += 'x'
        
    }
    if (constant != 0){
        if(rank != 0){
            answer += ' + '
            answer += String(constant) 
        }
        else{
            answer += String(constant)
        }
        
    }
    
    return answer;
}