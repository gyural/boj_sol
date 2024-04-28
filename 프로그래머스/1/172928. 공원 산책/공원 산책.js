const getStart = (park)=>{
    let X = 0
    let Y = 0
    for (str of park){
        X = str.indexOf("S")
        if (X >= 0){
            return[Y,X]
        }
        Y = Y +1
    }
}
const isInner = (park, Y, X) =>{
    if(park.length > Y && Y >= 0 && X >=0 && X < park[0].length){
        
        return true
    }
    return false
}
const isPossible = (park, movement, current) =>{
    let nxtY = current[0]
    let nxtX = current[1]
    const vector = {"E":[0,1], "S": [1,0], "W":[0,-1], "N":[-1,0]}
    
    for (i=0; i< Number(movement[1]); i++){
        nxtY = nxtY + vector[movement[0]][0]
        nxtX = nxtX + vector[movement[0]][1]
        console.log(nxtY, nxtX)
        if(isInner(park, nxtY, nxtX)){
            if (park[nxtY][nxtX] === "X"){
                return false
            }
        }
        else{
            console.log("밖")
            return false
        }
    }
    
    return true
}
function solution(park, routes) {
    const vector = {"E":[0,1], "S": [1,0], "W":[0,-1], "N":[-1,0]}
    let answer = [0,0]
    let [startY,startX] = getStart(park)
    answer[0] = startY
    answer[1] = startX
    console.log(startY, startX)
    routes.forEach((cmd)=>{
        const movement = cmd.split(" ")
        if (isPossible(park, movement, answer) === true){
                answer[0] += vector[cmd[0]][0] * Number(movement[1])
                answer[1] += vector[cmd[0]][1] * Number(movement[1])
            }
        console.log(answer)
    })
    
    return answer;
}