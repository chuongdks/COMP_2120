public class Sorting {
   
    public boolean inOrder (int [] nums) 
    {
       /* Type your code here. */    
       for (int i = 0; i < nums.length-1; i++)
       {
          if (nums[i+1] < nums[i])
          {
             return false;
          }
       }
       return true;
    }
    
    public static void main(String[] args) {
        Sorting s = new Sorting();

        // Test out-of-order example.
        int [] nums1 = {5, 6, 7, 8, 3};

        if(s.inOrder(nums1))
        {
            System.out.println("In order");
        } 
        else 
        {
            System.out.println("Not in order");
        }

        // Test in-order example.
        int [] nums2 = {5, 6, 7, 8, 10};

        if(s.inOrder(nums2))
        {
            System.out.println("In order");
        }
        else
        {
            System.out.println("Not in order");
        }
    }
}
 