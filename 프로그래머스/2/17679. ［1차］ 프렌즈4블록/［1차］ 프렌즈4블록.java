import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] newBoard = new char[m][n];
        
        for (int k=0; k<board.length; k++){
            for (int i=0; i<board[k].length(); i++){
                newBoard[k][i] = board[k].charAt(i);
            }
        }
        
        while (true) {
            // 현재 board에서 2x2가 가능한 좌표 저장
            List<List<Pos>> deletedPosList= new ArrayList<>();
            // 1) 2x2 sliding window로 스캐닝
            for (int i=0; i<m-1; i++){
                for (int j=0; j<n-1; j++){
                    if (IsSquareOk(newBoard, i,j)){
                        List<Pos> el = new ArrayList<>();
                        el.add(new Pos(i,j));
                        el.add(new Pos(i+1,j));
                        el.add(new Pos(i,j+1));
                        el.add(new Pos(i+1,j+1));
                        
                        deletedPosList.add(el);
                        
                    }
                    
                }
                

            }
            
            printBoard(newBoard);
            
            System.out.println(deletedPosList);
            
            if (deletedPosList.size() == 0){
                break;
            }
            answer += getValidTiles(deletedPosList);
            
            // 2. List에 담긴 대로 제거하면서 2칸 위에거 땡겨오기
            for (List<Pos> el :deletedPosList){
                for (Pos p : el){
                    int y = p.y;
                    int x = p.x;
                    // 1. 위에 거를 댕길 수 있는 경우
                    if (y-2 >= 0){
                        newBoard[y][x] = 'X';
                        // newBoard[y-2][x] = 'X';
                    // 2. 위에 거를 못 댕기는 경우
                    } else{ 
                        newBoard[y][x] = 'X';
                    }
                    
                }
            }
            deletedPosList.clear();
            spaceDwon(newBoard, m, n);
            
            
            
        }
            
        
        
        return answer;
    }
    
    public class Pos{
        int y;
        int x;
        
        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
        
        @Override
        public String toString(){
            return "Pos={" + y + ", " + x + "}";
        }
        
        public boolean equals(Pos p){
            return y==p.y && x==p.x;
        }
            
            
    }
    
    public void printBoard(char[][] board){
        int m = board.length;
        int n = board[0].length;
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
    public void spaceDwon(char[][] board, int m, int n){
        for (int i = m-1; i>=1; i--){
            for (int j=0; j<n; j++){
                if (board[i][j] == 'X'){
                    Pos tile = findTileByUp(board, i,j);
                    board[i][j] = board[tile.y][tile.x];
                    board[tile.y][tile.x]= 'X';
                }
            }
        }
    }
    
    public Pos findTileByUp(char[][] board, int y, int x){
        
        for (int i=y; i>=0; i--){
            if (board[i][x] != 'X'){
                return new Pos(i,x);
            }
        }
        
        return new Pos(y,x);
    }
    
    public int getValidTiles(List<List<Pos>> posList){
        List<Pos> fianlList = new ArrayList<>();
        
        for (List<Pos> el :posList){
            for (Pos p : el ){
                boolean isIn = false;
                
                // 저장되어있는 것에서 확인
                for(Pos savedPos : fianlList){
                    if (savedPos.equals(p)){
                        isIn = true;
                        break;
                    }
                }
                // 포함되어있지 않다면 추가
                if (isIn == false){
                    fianlList.add(p);
                }
                
            }
            
        }
        
        return fianlList.size();
    }
    
    
    public boolean IsSquareOk(char[][] board, int startY, int startX){
        char startValue = board[startY][startX];
        if (startValue == 'X') return false; 
        
        if (board[startY][startX+1] != startValue){
            return false;   
        }
        if (board[startY+1][startX+1] != startValue){
            return false;   
        }
        if (board[startY+1][startX] != startValue){
            return false;   
        }
        
        return true;
        
    }    
}