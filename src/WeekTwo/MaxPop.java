package WeekTwo;

public class MaxPop{
	    public static void main(String[] args) {
	         
	        int k = 11;
	        // initializing stack as array where 1st element represents the latest element
	        int stka[] = {4, 3, 6, 7, 9};
	        int stkb[] = {1, 2, 9, 5};
	        
	        MaxPop st_obj = new MaxPop();
	         
	        int max_count = st_obj.popCount(k, stka, stkb);
	        System.out.println("Result: " + max_count);
	        
	    }
	     
	    public int popCount(int k, int[] stka, int[] stkb) {
	 
	        int stka_index = 0;
	        int stkb_index = 0;
	        int count = 0;
	        int sum = 0;
	        
	        // traversing all elements of a stack
	        // go through elements until all elements are traversed or sum exceeds k 
	        while (stkb_index < stkb.length && sum + stkb[stkb_index] < k) {
	            sum += stkb[stkb_index];
	            stkb_index++;
	        }
	        // decreasing value of the latest index of a stack
	        stkb_index--;
	        count = stkb_index + 1;
	        
	        // going through elements of another stack
	        while (stka_index < stka.length && stkb_index < stkb.length) {
	            sum += stka[stka_index];
	            
	            if (sum >= k) {
	                // decreasing all the added value from previous stack, if the sum exceeds k
	                while (stkb_index >= 0) {
	                    sum -= stkb[stkb_index];
	                    stkb_index--;
	                    if (sum < k) {
	                        break;
	                    }
	                }
	                // even after decreasing all values from previous stack and sum exceeds k,
	                // exclude the present index of a stack
	                if (sum >= k && stkb_index < 0) {
	                    stka_index--;
	                    break;
	                }
	            }
	            // finding maximum popped count            
	            count = Math.max(stka_index + stkb_index + 2, count);
	            stka_index++;
	        }
	 
	        return count;
	    }
}
	 
	 

