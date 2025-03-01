def solution(picks, minerals):
    answer = 0
    
    """
    1.광물 리스트에서 5개 묶음으로 구간합을 구한다.
    2.해당 구간합 집합중 큰거일 수록 좋은 곡갱이를 배치한다.
    """
    
    mineral2cost = {
        "diamond" : [1, 5, 25],
        "iron" : [1, 1, 5],
        "stone" : [1, 1, 1]
    }
    
    # 1. 광물 배열 3개 숫자 원소 여러개 있는 2차원 배열로 만들기
    for i in range(len(minerals)):
        m = minerals[i]
        minerals[i]  = mineral2cost[m]
    # 2. 부분합 배열 만들기 3개의 원소가 여러개 있는 2차원 배열
    partSum = []
    idx = 0
    while idx < len(minerals):
        lastIdx = min(idx+4, len(minerals)-1)
        partSum.append([sum([x[2] for x in minerals[idx: lastIdx+1]]),(idx, lastIdx)])
        idx = lastIdx + 1
    
    
    
    toolNum = sum(picks)
    if toolNum < len(partSum):
        partSum = partSum[:toolNum]
    
    print(partSum)
    partSum.sort(key = lambda x:-x[0])
    
    print(partSum)
    
    # 총 곡갱이 수
    
    
    
    # 3. 채광하기
    # 3-1 무작위 배열 만들기
    # 3-1-1 최상위 곡갱이 가져오기
#     bestTools = []
#     for i in range(len(partSum)):
#         if picks[0] > 0: #다이아 곡갱이로 채광 가능
#             selectedPick = 0
#         elif picks[1] > 0:
#             selectedPick = 1
#         elif picks[2] > 0:
#             selectedPick = 2
            
#         bestTools.append(selectedPick)
#         picks[selectedPick] -= 1
    
#     # print(bestTools)
    
    for c, (start, end) in partSum:
        
        if picks[0] > 0: #다이아 곡갱이로 채광 가능
            selectedPick = 0
        elif picks[1] > 0:
            selectedPick = 1
        elif picks[2] > 0:
            selectedPick = 2
        else:
            break
        tempCost = sum([m[selectedPick] for m in minerals[start: end+1]])
        print(f"start{start} end{end} cost{tempCost}")
        
        answer += tempCost
        picks[selectedPick] -=1
    
    
    return answer