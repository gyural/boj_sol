def solution(wallet, bill):
    answer = 0
    
#     max_wallet = max(wallet)
#     min_wallet = min(wallet)
    
#     max_bill = max(bill)
#     min_bill = min(bill)
    
    wallet.sort(reverse=True)
    bill.sort(reverse=True)
    
    while True:
        if not (bill[1] > wallet[1] or bill[0] > wallet[0]):
            break
        bill[0] = bill[0] // 2
        bill.sort(reverse=True)
        answer += 1
        
    
    return answer