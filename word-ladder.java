public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<String> q=new LinkedList<String>();
        HashSet<String> h=new HashSet<String>();
        int num=1,len=1;
        q.add(start);
        h.add(start);
        while(!q.isEmpty()) {
            int j=num;
            num=0;
            while(j-->0) {
                String w=q.remove();
                //h.add(w);
                for(int m=0;m<w.length();m++) {
                    char[] c=w.toCharArray();
                    for(int i=0;i<26;i++) {
                        c[m]=(char)('a'+i);
                        String n=new String(c);
                        if(n.equals(end)) 
                            return len+1;
                        if(!h.contains(n)&&dict.contains(n)) {
                            q.add(n);
                            h.add(n); // will prevent same level add same words again
                            num++;
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }
}

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {{}
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<Stack<String>> q=new LinkedList<Stack<String>>();
        HashSet<String> h=new HashSet<String>();
        ArrayList<ArrayList<String>> r=new ArrayList<ArrayList<String>>();
        int num=1;
        Stack<String> st=new Stack<String>();
        st.push(start);
        q.add(st);
        h.add(start);
        boolean found=false;
        while(!q.isEmpty()) {
            int j=num;
            num=0;
            while(j-->0) {
                Stack<String> f=q.remove();
                String w=f.peek();
                h.add(w); // just prevent previous levels same words, otherwise will lost 
                            // some solutions which have common intermidate word on same level
                for(int m=0;m<w.length();m++) {
                    char[] c=w.toCharArray();
                    for(int i=0;i<26;i++) {
                        c[m]=(char)('a'+i);
                        String n=new String(c);
                        if(n.equals(w)) continue;
                        if(n.equals(end)) {
                            ArrayList<String> s=new ArrayList<String>();
                            s.add(n);
                            while(!f.isEmpty()) {
                                s.add(f.pop());
                            }
                            Collections.reverse(s);
                            r.add(s);
                            found=true;
                        }
                        else if(!h.contains(n)&&dict.contains(n)) {
                            Stack<String> s2=(Stack<String>)f.clone();
                            s2.push(n);
                            q.add(s2);
                            num++;
                        }
                    }
                }
            }
            if(found) break;
        }
        return r;
    }
}
