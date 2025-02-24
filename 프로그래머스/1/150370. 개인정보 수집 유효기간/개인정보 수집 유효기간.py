def yy_mm_dd2yymmdd(localtime):
    yyyy, mm, dd = localtime.split(".")
    
    return int(f"{int(yyyy):04d}{int(mm):02d}{int(dd):02d}")

def plusMonth(startDate, m):
    
    yyyy, mm, dd = startDate.split(".")
    
    yyyy_int = int(yyyy)
    mm_int = int(mm)
    
    plusYear = m // 12
    plusMonth = m % 12
    
    
    
    after_year = yyyy_int + plusYear
    after_month = mm_int + plusMonth
    
    if after_month > 12:
        after_month %= 12
        after_year += 1
    
    # yyyy_mm_dd = str(after_year) + str(after_month) + dd
    yyyy_mm_dd = f"{after_year:04d}{after_month:02d}{int(dd):02d}"

    return int(yyyy_mm_dd)
        
def solution(today, terms, privacies):
    answer = []
    
    # 객체로 만들어주기
    type2months = {}
    for t in terms:
        type, months = t.split(" ")
        type2months[type] = int(months)
    
    # 필터링
    for index, p in enumerate(privacies):
        startDate, type = p.split(" ")
        
        print(plusMonth(startDate, type2months[type]))
        if plusMonth(startDate, type2months[type]) <= yy_mm_dd2yymmdd(today):
            answer.append(index+1)
    # print(str(num) + "123412")
        
    return answer