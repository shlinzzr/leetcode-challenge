// https://leetcode.com/problems/minimum-array-end

class Solution {
    public long minEnd(int n, int x) {
        
        if(n==1) return x;
        // 8421
        
        // x = 5
        // 3 : 0011 => x
        
        
        
        // 4 : 0100
        
//         0100
//         0101
        
//         0110
//         0111
            
        
            
        
        // 5 : 0101
        // 6 : 0110
        // 7 : 0111
        // 8 : 1000 => x
        
        
        String golden = Integer.toBinaryString(x);
        String g = new StringBuilder(golden).reverse().toString();
        
        Set<Integer> onepos = new HashSet<>();
        for(int i=0; i<g.length(); i++){
            if(g.charAt(i)=='1') onepos.add(i);
        }
        
        // System.out.println(onepos);
        
        int cnt =1;
        
        StringBuilder curr = new StringBuilder(g); //001
        
        
        // System.out.println("a="+curr.toString());
         // 4 : 0100 rev => 0010
        
        
        int idx= 0 ;
        while(cnt<n){ // 1<3, 2<3
            
            if(cnt*2<n){ // 1*2<3
                if(!onepos.contains(idx)){
                    cnt *=2; // 1010, 0010
                }else
                    cnt++;
                
                
                if(idx<curr.length())
                    curr.setCharAt(idx, '1'); //101
                else 
                    curr.append('1');
                idx++;
                
            }else{ //add one by one
                
                curr = addOne(curr, onepos); //101
                cnt++;
                
            }
        }
        // System.out.println("out="+curr.toString()); // 011
        
        curr = curr.reverse();
        
        long res = 0L;
        
        for(int i=0; i<curr.length(); i++){
            
            if(curr.charAt(i)=='1'){
                res = (res<<1) | 1;
            }else
                res = (res<<1);
            
            
        }
        
        return res;
        
        
        
        
    }
    
    
    private StringBuilder addOne(StringBuilder curr, Set<Integer> onepos){
        
        // System.out.println(  "addOne " + curr.toString());
        
        // 1010
        StringBuilder sb = new StringBuilder();
        int carry = 1;
        
        for(int i=0; i<curr.length(); i++){
            
            if(onepos.contains(i)){
                sb.append('1'); //011
                
            }else{
                
                char ch = curr.charAt(i);
                int d = ch-'0'; 
                int v = d + carry; 

                sb.append(v%2); // 01
                carry = v/2; //1, 0
                
            }
            // System.out.println(i + " " + sb.toString());
        }
        
        if(carry==1){
            sb.append(1);
        }
        
        curr = new StringBuilder(sb); // 0110
        return sb;
        
        
        
    }
}