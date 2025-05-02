class Solution {
    public long solution(int price, long money, int count) {
        long answer = -1;
        long totalPrice = 0;
        for (int i =1; i<=count; i++){
            totalPrice += i * price;
        }
        
        long leftMoney = money - totalPrice;
        
        
        return leftMoney >=0 ? 0 : -leftMoney;
    }
}