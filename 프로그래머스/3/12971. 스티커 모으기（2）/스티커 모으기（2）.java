class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int N = sticker.length;
        
        if (N==1){
            return sticker[0];
        }
        
        if (N==2){
            return Math.max(sticker[0], sticker[1]);
        }

        int[] dpWithFirstValue = new int[N];
        dpWithFirstValue[0] = sticker[0];
        dpWithFirstValue[1] = sticker[0];

        int[] dpWithSecondValue = new int[N];
        dpWithSecondValue[0] = 0;
        dpWithSecondValue[1] = sticker[1];

        for (int i=2; i<N-1; i++){
            int iContainValue = dpWithFirstValue[i-2] + sticker[i];
            int iNonContainValue = dpWithFirstValue[i-1];

            dpWithFirstValue[i] = Math.max(iContainValue, iNonContainValue);
        }
        
        
        dpWithFirstValue[N-1] = dpWithFirstValue[N-1-1];
        

        for (int i=2; i<N; i++){
                int iContainValue = dpWithSecondValue[i-2] + sticker[i];
                int iNonContainValue = dpWithSecondValue[i-1];

                dpWithSecondValue[i] = Math.max(iContainValue, iNonContainValue);
            }
        



        return Math.max(dpWithFirstValue[N-1], dpWithSecondValue[N-1]);

    }
        
}
    
