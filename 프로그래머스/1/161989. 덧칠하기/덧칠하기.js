function painting(start, wall, m){
    let end = start + m -1
    end = Math.min(end, wall.length)
    for(let i = start; i <=end; i++){
        wall[i] = 1
    }
    return wall
}
function solution(n, m, section) {
    var answer = 1;
//  벽 상태 반영해주기
    let curWall = Array(n+1).fill(1)
    section.forEach((item)=>{
        curWall[item] = 0
    })
    
//  그리디로 해결
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