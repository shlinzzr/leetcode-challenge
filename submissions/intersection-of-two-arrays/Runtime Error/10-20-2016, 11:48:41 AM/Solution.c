// https://leetcode.com/problems/intersection-of-two-arrays

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    
    int n = (nums1Size > nums2Size) ? nums1Size : nums2Size ;
    //int *arr = (int *)malloc((n+1) * sizeof(int));
    int arr[10];
    int cnt=0;
    
    printf("n=%d,n1=%d,n2=%d",n,nums1Size, nums2Size);
    for(int i=0;i<nums1Size;i++)
    {
        for(int j=0;j<nums2Size;j++)
        {
            if(nums1[i] == nums2[j])
            {
                //arr[cnt]=nums1[i];
                //cnt++;
                //printf("%d %d", nums1[i], arr[cnt]);
                bool inarr = false;
                for(int k=0;k<cnt;k++)
                {
                    if(nums1[i] == arr[k])
                    inarr =true;
                }
                
                if(!inarr) {
                   
                    arr[cnt]=nums1[i];
                    //printf("%d",arr[0]);
                    cnt++;
                }
                    
                
            }
            
        }
    }
    return arr;
}