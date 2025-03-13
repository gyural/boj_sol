from collections import deque

def solution(numbers):
    answer = [-1] * len(numbers)
    
    # 1. 첫 원소를 스택에 삽입
    S = deque()
    S.append((numbers[0],0))
    
    # 스택안의 수가 현재 수보다 작다면 다 비우기 때문에
    # 스택아래일 수록 무조건 큰수가 저장된다.
    
    # 2. numbers순회
    for idx in range(1, len(numbers)):
        # print(S)
        # 스택이 비었다면
        while len(S) > 0:
            topValue, topIdx = S[-1]
            if topValue < numbers[idx]:
                answer[topIdx] = numbers[idx]
                S.pop()
            else:
                break
        S.append((numbers[idx], idx))
    

    
    
    return answer