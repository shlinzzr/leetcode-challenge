// https://leetcode.com/problems/parse-lisp-expression

class Solution {
    public int evaluate(String expression) {
        return helper(expression, new HashMap<>());
    }

    private int helper(String exp, Map<String, Integer> map){
        if(isNumberic(exp))
            return Integer.valueOf(exp);
        else if(isVariable(exp))
            return map.get(exp);
        

        int res = 0;

        List<String> list = parse(exp);
        if("add".equals(list.get(0))){
            res =  helper(list.get(1), map) + helper(list.get(2), map);

        }else if("mult".equals(list.get(0))){
            res = helper(list.get(1), map) * helper(list.get(2), map);
        
        }else{
            Map<String, Integer> newMap = new HashMap<>(map);
            for(int i=1; i<list.size()-1; i+=2){
                newMap.put(list.get(i) , helper(list.get(i+1), newMap));
            }

            res = helper(list.get(list.size()-1), newMap);
        }

        return res;
    }

    private boolean isNumberic(String exp){
        char ch = exp.charAt(0);
        if((ch>='0' &&ch<='9' )|| ch=='-') 
            return true;
        return false;
    }

    private boolean isVariable(String exp){
        char ch = exp.charAt(0);
        if(ch>='a' && ch<='z')
            return true;
        return false;
    }

    private List<String> parse(String exp){
        List<String> res = new ArrayList<>();
        exp = exp.substring(1, exp.length()-1);
        int startIndex=0;

        while(startIndex<exp.length()){
            int endIndex = next(exp, startIndex);
            res.add(exp.substring(startIndex, endIndex));
            startIndex = endIndex+1;
        }
        return res;
    }

    private int next(String exp, int startIndex){
        int idx = startIndex;
        if(exp.charAt(idx)=='('){
            int cnt=1;
            idx++;
            while(idx<exp.length() && cnt>0){
                if(exp.charAt(idx)=='('){
                    cnt++;

                } else if(exp.charAt(idx)==')'){
                    cnt--;
                }
                idx++;
            }
        }else{
            while(idx<exp.length() && exp.charAt(idx)!=' '){
                idx++;
            }
        }

        return idx;

            

    }

        

}