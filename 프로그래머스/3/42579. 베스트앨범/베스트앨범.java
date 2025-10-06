import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int size = plays.length;
        
        Map<String, PriorityQueue<Song>> geners2SongsMap = new HashMap<>();
        Map<String, Integer> geners2TotalPlays = new HashMap<>();
        PriorityQueue<Genres> generHeap = new PriorityQueue<>((a,b) -> b.plays - a.plays);
        
        for (int i=0 ; i < size; i++){
            String g = genres[i];
            int curPlays = plays[i];
            
            Song curSong = new Song(i, plays[i]);
            if (geners2SongsMap.get(g) == null){
                geners2SongsMap.put(g,
                                   new PriorityQueue<Song>((a,b) ->
                                                           {
                                                               if (a.plays == b.plays){
                                                                   return a.id - b.id;
                                                               } else{
                                                                   return b.plays - a.plays;
                                                               }
                                                           }
                                    
                                       
                                   )
                                   );
                geners2SongsMap.get(g).add(curSong);
                
                geners2TotalPlays.put(g, curPlays);
            } else{
                // 1. 총 조회수 합하기
                geners2TotalPlays.put(g, geners2TotalPlays.get(g) + curPlays);
                
                // 2. heap 푸쉬
                PriorityQueue<Song> curHeap =  geners2SongsMap.get(g);
                curHeap.add(curSong);
                
                }
                
            }
            
            for (String k  : geners2TotalPlays.keySet()) {
                generHeap.add(new Genres(k, geners2TotalPlays.get(k)));
            }
            
        
        // 마지막 answer넣기
        List<Integer> answerList = new ArrayList<>();
        
        while (generHeap.size() > 0){
            Genres curG =  generHeap.poll();
            String curGName = curG.name;
            PriorityQueue<Song> curSongHeap = geners2SongsMap.get(curGName);
            
            for (int i=0 ; i<2; i++){
                if (curSongHeap.size() <= 0){
                    break;
                }
                Song curSong =  curSongHeap.poll();
                
                answerList.add(curSong.id);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        
        return answer;
    }
    public class Genres {
        String name;
        int plays;
        
         public Genres(String name, int plays){

            this.name = name;
            this.plays = plays;
        }
        
        @Override
        public String toString(){
            return "name=" + name + ", plays=" + plays;
        }
            
    }
    
    public class Song {

        int id;
        int plays;
        
        public Song(int id, int plays){

            this.id = id;
            this.plays = plays;
        }
        
        @Override
        public String toString(){
            return "id=" + id + ", plays=" + plays;
        }
    }
}