public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder sum=new StringBuilder();
        add(a,b,sum,0);
        return sum.reverse().toString();
    }
    public void add(String a,String b,StringBuilder sum,int carry) {
        if(a.equals("")||b.equals("")) {
            while(!a.equals("")) {
                int j=a.charAt(a.length()-1)-'0';
                int r=j+carry;
                carry=r>=2?1:0;
                sum.append(r%2);
                a=a.substring(0,a.length()-1);
            }
            while(!b.equals("")) {
                int j=b.charAt(b.length()-1)-'0';
                int r=j+carry;
                carry=r>=2?1:0;
                sum.append(r%2);
                b=b.substring(0,b.length()-1);
            }
            if(carry==1) sum.append(1);
            return;
        }
        int i=a.charAt(a.length()-1)-'0';
        int j=b.charAt(b.length()-1)-'0';
        int r=i+j+carry;
        carry=r>=2?1:0;
        sum.append(r%2);
        add(a.substring(0,a.length()-1),b.substring(0,b.length()-1),sum,carry);
    }
}
