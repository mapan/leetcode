public class Solution {
    ArrayList<String> result;
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result=new ArrayList<String>();
        build("",s,4);
        return result;
    }
    public void build(String current,String rest,int empty) {
        if(rest.length()>empty*3||rest.equals("")) return;
        if(empty==1) { 
            if(isValid(rest))
		result.add(current+rest);
            return;
        }
        for(int i=1;i<=Math.min(rest.length(),3);i++) {
            String c=current;
	    if(!isValid(rest.substring(0,i))) continue;
	    c+=rest.substring(0,i)+".";
            String r=rest.substring(i);   // do not modify func params 'current' and 'rest' cause backtracking
            build(c,r,empty-1);
        }
    }
    public boolean isValid(String s) {
        if(s.length()>1&&s.charAt(0)=='0') return false;
        int i=Integer.parseInt(s);
        if(i>=0&&i<=255) return true;
        return false;
    }
}
