public class Solution {
    ArrayList<String> r;
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<String>();
        combine("",digits);
        return r;
    }
    public String[] letter(char d) {
        switch(d) {
            case '2': return new String[]{"a","b","c"};
            case '3': return new String[]{"d","e","f"};
            case '4': return new String[]{"g","h","i"};
            case '5': return new String[]{"j","k","l"};
            case '6': return new String[]{"m","n","o"};
            case '7': return new String[]{"p","q","r","s"};
            case '8': return new String[]{"t","u","v"};
            case '9': return new String[]{"w","x","y","z"};
        }
        return new String[1];
    }
    public void combine(String current,String rest) {
        if(rest.equals("")) {
            r.add(current);
            return;
        }
        String[] l=letter(rest.charAt(0));
        for(int i=0;i<l.length;i++) {
            combine(current+l[i],rest.substring(1,rest.length()));            
        }
    }
}
