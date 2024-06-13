// https://leetcode.com/problems/roman-to-integer

inline int c2n(char c) {  
  switch(c) {  
    case 'I': return 1;  
    case 'V': return 5;  
    case 'X': return 10;  
    case 'L': return 50;  
    case 'C': return 100;  
    case 'D': return 500;  
    case 'M': return 1000;  
        default: return 0;  
      }  
} 


int romanToInt(char* s) {
    int n = strlen(s);
    int sum=0;
    for(int i=0;i<n;i++)
    {
        sum += c2n(s[i]);
        printf("%d ", sum);
        
        
    }
    return sum;
}