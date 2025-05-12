class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int row = arr1.length;
        int column = arr2[0].length;
        
        int[][] answer = new int[row][column];
        
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                int sum = 0;
                for (int k=0; k < arr2.length; k++){
                    for (int l=0; l < arr1[0].length; l++){
                        if (l == k) sum += arr1[i][l] * arr2[k][j];
                    }
                    
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}

// 1 4     3 3
// 3 2     3 3
// 4 1    

// 2 3 2   5 4 3
// 4 2 4   2 4 1
// 3 1 4   3 1 1