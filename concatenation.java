public class Solution {
    ArrayList<Integer> r;
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<Integer>();
        int l1=S.length(),l2=L.length;
        if(l1==0||l2==0) return r;
        int w=L[0].length();
        HashMap<String,Integer> h=new HashMap<String,Integer>(),h2;
        for(int i=0;i<l2;i++) {
            if(!h.containsKey(L[i])) h.put(L[i],0);
            h.put(L[i],h.get(L[i])+1);
        }
        for(int i=0;i<=l1-w;i++) {
            h2=new HashMap<String,Integer>(h);
            int c=0;
            for(int j=i;j<=Math.min(i+w*l2-w,l1-w);) {
                String s=S.substring(j,j+w);
                if(h2.containsKey(s)&&h2.get(s)!=0) {
                    h2.put(s,h2.get(s)-1);
                    c++;
                    if(c==l2) {
                        r.add(i);
                        break;
                    }
                }
                else break;
                j+=w;
            }
        }
        return r;
    }
}
