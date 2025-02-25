def solution(s):
    answer = 0
    parsedList = []
    x_index = 0
    tempString = ''
    x_count = 0
    y_count = 0
    
    for i in range(len(s)):
        tempString += s[i]
        if s[i] == s[x_index]:
            x_count +=1
        else:
            y_count +=1

        if x_count == y_count:

            parsedList.append(tempString)

            tempString = ''
            x_count = 0
            y_count = 0

            x_index = i+1
            
    
    
    answer = len(parsedList)
    if len(tempString) > 0:
        answer +=1
    
    return answer