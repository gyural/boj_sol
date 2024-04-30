function solution(name, yearning, photo) {
    var answer = [];
    const scoreMapping = {}
//  Mapping해주기
    for (i=0; i < name.length; i++){
        scoreMapping[name[i]] = yearning[i]
    }
    console.log(scoreMapping)
// 추억 카운팅
    photo.forEach((nameList)=>{
        let count = 0
        nameList.forEach((name)=>{
            if(scoreMapping[name]){
                count = count + scoreMapping[name]
            }
        })
        answer.push(count)
    })
    return answer;
}