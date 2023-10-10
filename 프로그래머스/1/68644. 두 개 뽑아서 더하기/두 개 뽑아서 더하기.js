function solution(numbers) {
    var answer = [];
    
    for (let i = 0; i < numbers.length ;i++){
        const num1 = numbers[i]
        for (let j = 0; j < numbers.length ;j++){
            if(i !== j){
                const num2 = numbers[j]
                const sum = num1 + num2
                !answer.includes(sum) && answer.push(sum)
            }
        }
    }
    answer.sort(function(a, b)  {
        return a - b;
    });
    
    return answer;
}