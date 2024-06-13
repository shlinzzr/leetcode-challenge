// https://leetcode.com/problems/video-stitching

class Solution {
    public int videoStitching(int[][] clips, int time) {
        int len = clips.length;
        
        Arrays.sort(clips, (a,b)-> a[0]-b[0]); 
        
        for(int[] c: clips){
            System.out.print( "[" +c[0] +"," + c[1] + "], ");
        }
        System.out.println();
        
        int cnt = 0;
             
        int covered = 0;
        
        for(int i=0; i<len; i++){
            int max = covered;
            
            int[] a = clips[i];
            
            if(a[1]-a[0] > time)
                return 1;
            
            while(a[0]<=covered){
                max = Math.max(max, a[1]);
                i++;
                if(i>=len)
                    break;
                a=clips[i];
                
                if(a[0]>covered)
                    i--;
            }
            
            
            cnt++;
            covered=max;
            System.out.println(cnt + " " + covered+" "+i);
        }
        
        return covered < time? -1 : cnt;
        
    }
}