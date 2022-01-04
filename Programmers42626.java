import java.util.*;

class Solution2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int score=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });
        
        for (int s: scoville){
            pq.add(s);
        }
        
        while(true) {
            int min=pq.poll();
            if (min>=K){
                break;
            }
            if (pq.size()==0){
                answer=-1;
                break;
            }
            score=min+pq.poll()*2;
            pq.add(score);
            answer++;
        }
        
        return answer;
    }
}