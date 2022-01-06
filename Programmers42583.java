class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int N=truck_weights.length;
		int W=bridge_length;
		int L=weight;
		int[] truck=new int[N+1];
		int[] bridge=new int[W];
		int count=0;
		
		for (int i=1; i<=N; i++) {
			truck[i]=truck_weights[i-1];
		}
		
		int w=0;
		int index=1;
		while(index<=N) {
			w-=truck[bridge[W-1]];
			for (int i=W-2; i>=0; i--) {
				bridge[i+1]=bridge[i];
			}
			
			if (w+truck[index]<=L) {
				bridge[0]=index;
				w+=truck[index++];
			} else {
				bridge[0]=0;
			}
			count++;
		}
		count+=W;
        return count;
    }
}