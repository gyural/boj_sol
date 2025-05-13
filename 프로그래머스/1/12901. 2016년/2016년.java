import java.util.*;

class Solution {
    public String solution(int a, int b) {
        
        Map<Integer, Integer> month2days = new HashMap<Integer, Integer>();
        month2days.put(1, 31);
        month2days.put(2, 29);
        month2days.put(3, 31);
        month2days.put(4, 30);
        month2days.put(5, 31);
        month2days.put(6, 30);
        month2days.put(7, 31);
        month2days.put(8, 31);
        month2days.put(9, 30);
        month2days.put(10, 31);
        month2days.put(11, 30);
        month2days.put(12, 31);
        
        Map<Integer, String> days2date = new HashMap<Integer, String>();
        days2date.put(0, "FRI");
        days2date.put(1, "SAT");
        days2date.put(2, "SUN");
        days2date.put(3, "MON");
        days2date.put(4, "TUE");
        days2date.put(5, "WED");
        days2date.put(6, "THU");
        
        int sumDays = b;
        for (int i=1; i<=a-1; i++){
            sumDays += month2days.get(i);
        }
        int dateNum = (sumDays-1) % 7;
        
        String answer = days2date.get(dateNum);
        return answer;
    }
}