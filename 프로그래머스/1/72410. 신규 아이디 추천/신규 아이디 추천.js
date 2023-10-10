function solution(new_id) {
    let answer = '';
    const smallChar = []
    const largeChar = []
    for (let i = 0; i <= 25; i++ ){
        smallChar.push(String.fromCharCode(97+i))
        largeChar.push(String.fromCharCode(65+i))
    }
    //유효 문자
    const validChar = [...smallChar, '-', '_', '.', '0','1'
                      ,'2','3','4','5','6','7','8','9']
    
    //1단계 대문자 => 소문자
    for(let i = 0; i < new_id.length; i++){
        if (largeChar.includes(new_id[i])){
            const idx = largeChar.indexOf(new_id[i])
            // new_id[i] = smallChar[idx]
            answer += smallChar[idx]
        }else{
            answer += new_id[i]
        } 
    }
    new_id = answer
    answer = ''
    //2단계 유효문자 제외 제거
    const delteIdx = []
    for(let i = 0; i < new_id.length; i++){
        if (validChar.includes(new_id[i])){
            answer += new_id[i]
        }
    }
    new_id = answer
    answer = ''
    // 3단계 '.' 두번이상시 제거
    for(let i = 0; i < new_id.length-1; i++){
        if (new_id[i] === '.' && new_id[i+1] === '.'){
            //None
        }else{
            answer += new_id[i]
        }
    }
    answer += new_id[new_id.length-1]
    console.log(new_id[new_id.length-1])
    new_id = answer
    answer = ''
    //4단계 처음이나 마지막에 .이 위치하면 제거
    for(let i = 0; i < new_id.length; i++){
        if (new_id[i] === '.' && (i === 0 || i === new_id.length-1)){
            //None
        }
        else{
            answer += new_id[i]
        }
    }
    new_id = answer
    answer = ''
    //5단계 빈문자열 a대입
    if (new_id === ''){
        new_id = 'a'
    }
    answer = new_id
    //6단계
    if(answer.length > 15){
        answer = answer.substring(0,15)
    }
    
    //7단계
    console.log(answer)
    if(answer.length <= 2){
        let pluschar = answer[answer.length-1]
        for (let i = 0; i < 3- answer.length; i++){
            answer += pluschar
        }
    }
    return answer;
}