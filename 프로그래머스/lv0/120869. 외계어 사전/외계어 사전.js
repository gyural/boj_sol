function solution(spell, dic) {
    var answer = 0;
    let spellCheck = Array(spell.length).fill(0)
    
    for (word of dic){
        
        
        for(i = 0; i < spell.length; i++){
            for(w of word){
                if (spell[i] == w){
                    spellCheck[i] += 1
                }
            }
        }
        //spell check 배열의 값이 모두 1인지 확인
        console.log(spellCheck)
        answer += 1;
        for(s of spellCheck){
            if (s != 1){
                answer -=1;
                
                break;
            }
        }
        spellCheck.fill(0)
    }
    if (answer > 0){return 1}
    else{return 2}
}