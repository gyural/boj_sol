saleRate = [0.9, 0.8, 0.7, 0.6]
maxResult = [-1, -1]
def getSaleAfter(users, eArray):
    tmpResult = [0,0]
    for u in users:
        user_r = u[0]
        user_pMax = u[1]
        tmpTotal = 0
        for p, r in eArray:
            #살수 있는 할인대라면
            if r >= user_r:
                tmpTotal += p

                    
        if user_pMax > tmpTotal:
            tmpResult[1] += tmpTotal
        else:
            tmpResult[0] +=1
        
    # print(f"일단 임시 실적{tmpResult}")
    return tmpResult
            
def getAfterE(before, after, users):
    
    if len(before) == 0:
        # print(after)
        tmpResult = getSaleAfter(users, after)
        
        # 최종 max값과 비교
        if maxResult[0] < tmpResult[0]:
            maxResult[0], maxResult[1] = tmpResult[0], tmpResult[1]
        elif maxResult[0] == tmpResult[0]:
            maxResult[1] = max(tmpResult[1], maxResult[1])
        
    else:
        target = before[0]
        for r in saleRate:
            getAfterE(before[1:], after + [(round(r*target), 100-int(r*100))], users)
        
        

def solution(users, emoticons):
    answer = []
    
    
    getAfterE(emoticons, [], users)
    # 모든 할인 경우의 수를 afterEmoticons로 담아야함
    print(maxResult)
    
    """
    [(780, 40), (900, 40), (1280, 20), (2940, 40)]
    
    프리미엄 : 1번째 3번째 5번째
    매출 : 4620(2번째) 5900(4번째) 4620(6번째) 4620(7번째)
    """
    
#     print(780+900+1280+2940)
#     print(round(1300*0.6),  round(1500*0.6), round(1600*0.8), round(4900*0.6))
    
    
#     1번 사람
#     780 + 900 + 2940 =  < 2900 X
#     --> 플러스 구매
#     2번 사람
#     780 + 900 + 2940 = < 10000 O
#     --> 매출 발생
#     3번 사람
#     780 + 900 + 1280 + 2940 = 5900 > 5200 X
#     --> 플러스 구매
#     4번 사람
#     780 + 900 + 1280 + 2940 == 5900 X
#     --> 매출 발생
#     5번 사람
#     780 + 900 + 2940 = > 3100 X
#     --> 플러스 구매
#     6번 사람
#     780 + 900 + 1280 + 2940 == 5900 X 
#     --> 매출 발생
#     7번 사람
#     780 + 900 + 1280 + 2940 == 5900 X
#     --> 매출 발생
    
    return maxResult










