import java.util.*;
public class Profit {
    public static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(prices.length==0) return 0;
        int low = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++) {
            int p = prices[i];
            int pro = p-low;
            max = pro>max ? pro:max;
            low = p<low ? p:low;
        }
        return max;
    }
	public class Solution {
	    public int maxProfit(int[] prices) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(prices.length==0) return 0;
	        int low = prices[0];
	        int max = 0,m = 0;
	        for(int i=1;i<prices.length;i++) {
	            int p = prices[i];
	            int pro = p-low;
	            m = pro>m ? pro:m;
				// change the low when it's lower than previous one next to it
				//6 1 3 4 2 5 7
	            if(p<prices[i-1]) {
	                low = p;
	                max += m;
	                m = 0;
	            }
	            if(i==prices.length-1)
	                max += m;
	        }
	        return max;
		/*
			int p = 0;
			        for(int i = 1; i < prices.size() ; ++i) {
			            int delta = prices[i] - prices[i-1];
			            if(delta > 0 ) {
			                p += delta;
			            }
			        }
			        return p;
		*/
	    }
	}
	public int maxProfit(int[] prices) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int len = prices.length;
	        if(len==0) return 0;
	        int low = prices[0];
	        int high = prices[len-1],max2 = 0;
	
			//!!!!!!!!!!!! int[] a = new int[len];!!!!!!!!!!!!!!!!!!!!!!
	        int[] before = new int[len];
	        int[] after = new int[len];
	
	        before[0] = 0;
	        after[len-1] = 0;
	        for(int i=0;i<len;i++) {
	            if(i>0)
	                before[i] = max(before[i-1],prices[i]-low);
	            low = min(low,prices[i]);
	        }
	        for(int i=len-1;i>=0;i--) {
	            if(i<len-1)
	                after[i] = max(after[i+1],high-prices[i]);
	            high = max(high,prices[i]);
	            max2 = max(max2,before[i]+after[i]);
	        }
	        return max2;
	    }
	    public int max(int a, int b) {
	        return a>b ? a:b;
	    }
	    public int min(int a,int b) {
	        return a<b ? a:b;
	    }
		public static void main(String[] args) {
			Profit p = new Profit();int[] a = {1,2};
			p.maxProfit(a);
		}
}
