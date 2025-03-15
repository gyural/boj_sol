# 짝궁이 가능한 무게 리턴
def findCoupleNum(w):
    result = []
    for i in [2,3,4]:
        for j in [2,3,4]:
            tempValue = w * i / j
            if w * i % j == 0 and tempValue != w and tempValue not in result:
                result.append(int(tempValue))
    return result

def solution(weights):
    
    answer = 0
    weights.sort()
    # 무게당 개수 배열 100 ~ 1000
    weight_sum = [0] * 901
    
    for w in weights:
        weight_sum[w-100] += 1
    
    # Counting
    for w in weights:
        coupleList = findCoupleNum(w)
        for cW in coupleList:
            if 100 <= cW <= 1000 and cW != w:
                # print(w, cW)
                answer += weight_sum[cW-100]
    
    answer /= 2
    for s in weight_sum:
        if s > 1:
            answer += s * (s-1) // 2
    
    
    return answer