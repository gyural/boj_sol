function solution(s, skip, index) {
    var answer = '';
    let skippedList = []
    //skippedList 완성
    for(let letter = 'a'; letter <= 'z'; letter = String.fromCharCode(letter.charCodeAt(0) + 1)){
        if (!skip.includes(letter)){
            skippedList.push(letter)
        }
    }
    [...s].forEach((el)=>{
        let afterIndex = 0
        const befIndex = skippedList.indexOf(el)
        
        if(befIndex + index >= skippedList.length){
            afterIndex = (befIndex + index) % skippedList.length
        }else{
            afterIndex = befIndex + index
        }
        answer += skippedList[afterIndex]
    })
    return answer;
}