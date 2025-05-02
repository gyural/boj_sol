class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowSize = arr1.length;
        int columnSize = arr1[0].length;
        
        
        
        int[][] answer = new int[rowSize][columnSize];
        
        for (int i=0; i<rowSize; i++){
            for (int j=0; j< columnSize; j++) answer[i][j] = arr1[i][j] + arr2[i][j];
        }
        return answer;
    }
}