import copy
T = int(input())
def get_int_by_numArray(numArray):
    num_string = "".join(map(str, numArray))
    result = int(num_string)
    return result
def find_max_by_array(numArray):
    newNumArray = copy.deepcopy(numArray)
    newNumArray = [get_int_by_numArray(val) for val in newNumArray]
    return max(newNumArray)
           
def DFS(startNum, depth, times):
	#종료 조건
    if times == depth:
        return
    possibleNum = findPossibleNum(startNum)
    for value in possibleNum:
        if (depth+1, value)  not in visit:
            visit.append((depth+1, value))
            DFS(value, depth+1, times)
        
   	
def findPossibleNum(numArray):
    result = []
    for i in range(len(numArray)-1):
         for j in range(i+1, len(numArray)):
                result.append(swapArray(numArray, i, j))
    return result
           
def swapArray(arr, i, j):
    new_arr = copy.deepcopy(arr)
    new_arr[i], new_arr[j] = new_arr[j], new_arr[i]
    return new_arr

for i in range(T):
    startNum, times = input().split()
    startNum = list(startNum)
    startNum = [int(val) for val in startNum]
    times = int(times)
    
    
    
    visit = [(0, startNum)]
    
    DFS(startNum, 0, times)
    
    #목표 depth인 것만 리스트로 만들기
    target_list = []
    for item in visit:
        if (item[0] == times):
            target_list.append(item[1])
    #print(target_list)
    print(f"#{i+1}", find_max_by_array(target_list))
