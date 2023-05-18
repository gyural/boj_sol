function solution(numbers) {
    var answer = 0;
    let result = ""
    const numarr = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    i = 0
    while(i < numbers.length){
        for(k = 0; k < numarr.length; k++){
            num = numarr[k]
            //num과 입력 배열의 선형비교
            let flag = true
            for (j = 0; j < num.length; j++){
                if(numbers[i+j] != num[j]){
                    flag = false
                }
            }
            if (flag == true){
                result += k.toString()
                i += num.length
                break
            }
        }
    }
    console.log(result)
    answer = parseInt(result)
    return answer;
}
    
    
    
    
    
