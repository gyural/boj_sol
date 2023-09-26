function solution(numlist, n) {
    var answer = [];
    
    let newList = numlist.map((el) => {
        return [Math.abs(el - n), el];
    });
    
    newList.sort((a,b) => b[1]-a[1])
    newList.sort((a,b) => a[0]-b[0])
    
    answer = newList.map((el)=>{
        return el[1]
    })
    return answer;
}