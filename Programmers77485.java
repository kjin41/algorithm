class Solution {
// Programmers 행렬 테두리 회전하기
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr=new int[rows][columns];
        int k=1;
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                arr[i][j]=k++;
            }
        }
        
        for (int i=0; i<queries.length; i++){
            answer[i]=rotate(arr, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
        
        return answer;
    }
    
    public int rotate(int[][] arr, int x1, int y1, int x2, int y2){
        int temp=arr[x1][y1];
        int min=temp;
        int r=x1, c=y1;
        for (r=x1; r<x2; r++){
            arr[r][c]=arr[r+1][c];
            min=Math.min(min, arr[r][c]);
        }
        for (c=y1; c<y2; c++){
            arr[r][c]=arr[r][c+1];
            min=Math.min(min, arr[r][c]);
        }
        for (r=x2; r>x1; r--){
            arr[r][c]=arr[r-1][c];
            min=Math.min(min, arr[r][c]);
        }
        for (c=y2; c>y1+1; c--){
            arr[r][c]=arr[r][c-1];
            min=Math.min(min, arr[r][c]);
        }
        
        arr[r][c]=temp;
        min=Math.min(min, arr[r][c]);
        
        return min;
    }
    
}