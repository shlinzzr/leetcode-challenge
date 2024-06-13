// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {
    public boolean equationsPossible(String[] eq) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<26; i++){
            map.put(i, i);
        }

        for(String s : eq){

            int a = s.charAt(0)-'a';
            int b = s.charAt(3)-'a';
            
            if(s.charAt(1)=='='){
                // union(a, b);

                if(a<b){
                    map.put(b, a);
                }else{
                    map.put(a, b);
                }

            }else{

                if(find(a, map)==find(b, map)){
                    return false;
                }

            }
        }

        for(String s : eq){
            int a = s.charAt(0)-'a';
            int b = s.charAt(3)-'a';
            if(s.charAt(1)=='!' && find(a, map)==find(b, map)){
                return false;
            }
         }

        return true;

        
    }

    private int find(int x, HashMap<Integer, Integer> map){
        if(map.get(x)!=x) map.put(x, find(map.get(x), map));

        return map.get(x);
    }
}