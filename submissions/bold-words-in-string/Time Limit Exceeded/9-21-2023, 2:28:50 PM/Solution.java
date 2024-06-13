// https://leetcode.com/problems/bold-words-in-string

class Solution {
    public String boldWords(String[] words, String s) {
        int len = s.length();
        boolean[] bold = new boolean[len];


        int idx = 0;
        for(String w: words){
            while(s.indexOf(w, idx)>=0){

                for(int i=s.indexOf(w); i<s.indexOf(w)+w.length(); i++){
                    bold[i]=true;
                }

                idx = s.indexOf(w)+1;
            }
        }

        String open = "<b>";
        String close = "</b>";

        StringBuilder sb = new StringBuilder();

        boolean isBold = false;

        for(int i=0; i<len; i++){

            if(bold[i] && (i==0 || !bold[i-1])){
                sb.append(open);
                isBold = true;
            }

            sb.append(s.charAt(i));
   
            if (bold[i] && (i == len - 1 || !bold[i + 1])) { // i是bold, i+1是!bold的時候 + closetag
                sb.append(close);
            }
                
        }

        return sb.toString();

    }
}