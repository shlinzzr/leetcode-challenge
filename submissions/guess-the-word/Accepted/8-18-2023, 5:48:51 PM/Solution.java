// https://leetcode.com/problems/guess-the-word

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */

class Solution{
	public void findSecretWord(String[] words, Master master){
        int last = words.length-1;
        while(true){
            int count = master.guess(words[0]);
            if(count==6) return;
            int i = 1;
            while(i <= last){
                int c = 0;
                for(int j = 0; j < 6; j++) if(words[i].charAt(j)==words[0].charAt(j)) c++;
                if(c!=count) words[i]=words[last--];
                else i++;
            }
            words[0]=words[last--];
        }
    }
}



// class Solution {
//     public void findSecretWord(String[] words, Master master) {
        
//         for (int k = 0; k < 30; k++) {
            
//             int[][] count = new int[6][26]; // digit 1~6 , char a~z
//             int best = 0;
//             for(String word: words){
//                 for(int i=0; i<6; i++){ //
//                     count[i][word.charAt(i)-'a']++;
//                 }
//             }
            
//             String guess = words[0];
//             for(String word : words){
//                 int score = 0;
//                 for(int i=0; i<6; i++){
//                     score += count[i][word.charAt(i)-'a'];
//                 }
//                 if(score > best){  //從最多重複的char 來猜
//                     guess = word;
//                     best = score;
//                 }
//             }
            
//             int similarity = master.guess(guess);
//             List<String> temp = new ArrayList<>();
//             for(String word : words){
//                 if( match(guess, word)==similarity ){
//                     temp.add(word);
//                 }
//             }
            
//             words = temp.toArray(new String[0]);
            
//         }
//     }
    
//     private int match(String word1, String word2) {
        
//         int cnt = 0;
//         for (int i = 0; i < word1.length(); i++) {
//             if (word1.charAt(i) == word2.charAt(i)) {
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
// }