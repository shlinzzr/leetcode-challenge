// https://leetcode.com/problems/reverse-string

/*
// O(n)
char* reverseString(char* s) {
    
    int len=strlen(s);
    
   // printf(len);
    
    char arr[len];
    int i ;
    for(i=0;i<len;i++){
        arr[len-i-1] = *(s+i);
    }
    arr[i]='\0';  // ""  => "@�\x1f!�" 
    strcpy(s,arr);
    return s;
}


*/

// O(n/2)
char* reverseString(char* s)
{
    int i, n = strlen(s);
    char temp;
    for (i = 0; i < n/2 ;i++)
    {
        temp = s[i];
        s[i] = s[n - i - 1];
        s[n - i - 1] = temp;
    }
    return s;
}



