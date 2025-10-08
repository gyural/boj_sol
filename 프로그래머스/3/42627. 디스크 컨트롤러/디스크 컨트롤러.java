import java.util.*;

// 1시 39분 시작
// 우선 순위 1)소요시간 Min 2)요청시각 Min 3)작업번호 Min 순임 
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int size = jobs.length;
        int completeCount = 0;
        
        PriorityQueue<Job> readyQueue = new PriorityQueue<>((a,b) -> {
            if (a.cost == b.cost && a.requestTime == b.requestTime){
                return a.id - b.id;
            } else if(a.cost == b.cost){
                return a.requestTime - b.requestTime;
            } else{
                return a.cost - b.cost;
            }
        });
        
        PriorityQueue<Job> jobHeap = new PriorityQueue<>((a,b) -> a.requestTime - b.requestTime);
        
        for (int i=0; i<size; i++){
            int[] job = jobs[i];
            Job jobEntity = new Job(i, job[0], job[1]);
            jobHeap.add(jobEntity);
        }
        
        
        

        while(completeCount < size){
            // 1. time에 요청이온 값들 대기큐로 넣기
            while (jobHeap.size() > 0){
                Job requestJob  = jobHeap.poll();
                if (requestJob.requestTime > time){
                    jobHeap.add(requestJob);
                    break;
                } else{
                    readyQueue.add(requestJob);
                }
            }
            
            // 2. 대기큐에서 doingJob 수행완료까지
            if (readyQueue.size() > 0){
                Job doingJob = readyQueue.poll();
                time += doingJob.cost;
                
                answer += time - doingJob.requestTime;
                
                completeCount++;
                continue;
            }
            
            // 3. 1초 증가
            time++;
        }
        
        return answer / size;
    }
    
    
    public class Job{
        int id;
        int requestTime;
        int cost;
        
        public Job(int id, int requestTime, int cost){
            this.id = id;
            this.requestTime = requestTime;
            this.cost = cost;
        }
        
        @Override
        public String toString(){
            return 
                "id=" + id +
                "requestTime=" + requestTime +
                "cost=" + cost;
        }
    }
}