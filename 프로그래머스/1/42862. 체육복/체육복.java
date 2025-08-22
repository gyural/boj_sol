import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int startArr[] = new int[n];
        Arrays.fill(startArr, 1);
        
        for (int l : lost){
            startArr[l-1]--;
        }
        for (int r : reserve){
            startArr[r-1]++;
        }

        List<int[]> visit = new ArrayList<>();
        // 탐색
        Deque<QItem> Q = new ArrayDeque<>();
        Q.add(new QItem(startArr, countStudent(startArr)));
        visit.add(startArr);
        while(Q.size()>0){
            QItem curQItem = Q.poll();
            int students = curQItem.maxValue;
            int[] curArr = curQItem.curArr;
            
            answer = Math.max(students, answer);
            
            // System.out.println("현재 item");
            // System.out.println(Arrays.toString(curArr));
            // System.out.println(students);
            // System.out.println("----------------------------");
            
            
            for (int i=0; i<n; i++){
                // 왼쪽에 줬을 때
                boolean isLeftAble = i > 0 && curArr[i] == 2 && curArr[i-1] == 0;
                boolean isRightAble = i < n-1 && curArr[i] == 2 && curArr[i+1] == 0;
                if (isLeftAble){
                    int[] nxt = getArrGiveLeft(curArr, i);
                    if (!isVisit(visit, nxt)){
                        Q.add(new QItem(nxt, countStudent(nxt)));
                        visit.add(nxt);
                    }
                }
                if (isRightAble){
                    int[] nxt = getArrGiveRight(curArr, i);
                    if (!isVisit(visit, nxt)){
                        Q.add(new QItem(nxt, countStudent(nxt)));
                        visit.add(nxt);
                    }
                }
            }
        }
        
        
        
        
        
        
        
        
        return answer;
    }
    
    public boolean isVisit(List<int[]> list, int[] arr){
        for (int i=0; i<list.size(); i++){
            if(Arrays.equals(list.get(i), arr)){
                return true;
            }
        }
        return false;
        
    }
    
    public int countStudent(int[] arr){
        int result =0;
        for (int el: arr){
            if (el >0){
                result++;
            }
        }
        return result;
    }
    
    public int[] getArrGiveLeft(int[] arr, int idx){
        int[] result = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            result[i] = arr[i];
        }
        result[idx]--;
        result[idx-1]++;
        return result;
    }
    
    public int[] getArrGiveRight(int[] arr, int idx){
        int[] result = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            result[i] = arr[i];
        }
        result[idx]--;
        result[idx+1]++;
        return result;
    }
    
    class QItem {
        int[] curArr;
        int maxValue;
        
        public QItem(int[] curArr, int maxValue){
            this.curArr = curArr;
            this.maxValue = maxValue;
        }
        
        @Override
        public String toString(){
            return "QItem={"+Arrays.toString(curArr)+"}";
        }
        
        
    }
}

/*


*/