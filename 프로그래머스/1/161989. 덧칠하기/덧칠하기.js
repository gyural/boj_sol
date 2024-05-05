
function solution(n, m, section) {
    var answer = 1;
    let start = section[0]
    
    section.forEach((item)=>{
        const diff = item - start + 1
        if(diff > m){
            start = item
            answer += 1
        }
    })
    
    return answer;
}