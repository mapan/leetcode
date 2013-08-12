public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.equals("")) return b;
        if(b.equals("")) return a;
        int lena=a.length();
        int lenb=b.length();
        int vala=Integer.parseInt(a.substring(lena-1,lena));
        int valb=Integer.parseInt(b.substring(lenb-1,lenb));
        int carry=(vala+valb)>1?1:0;
        String result="";
        result+=(vala+valb)%2+"";
        lena--;lenb--;
        while(lena!=0&&lenb!=0) {
            vala=Integer.parseInt(a.substring(lena-1,lena));
            valb=Integer.parseInt(b.substring(lenb-1,lenb));
            result+=(vala+valb+carry)%2+"";
            carry=(vala+valb+carry)>1?1:0;
            lena--;lenb--;
        }
        while(lena!=0) {
            vala=Integer.parseInt(a.substring(lena-1,lena));
            result+=(vala+carry)%2+"";
            carry=(vala+carry)>1?1:0;
            lena--;;
        }
        while(lenb!=0) {
            valb=Integer.parseInt(b.substring(lenb-1,lenb));
            result+=(valb+carry)%2+"";
            carry=(valb+carry)>1?1:0;
            lenb--;
        }
        if(carry!=0) result+="1";
        return new StringBuffer(result).reverse().toString();
    }
}


string AddBinary(string s1, string s2) 
{
    int len1 = s1.size()-1;
    int len2 = s2.size()-1;
    string s = len1 > len2? s1 : s2;
    int len = s.size()-1;
    char carry = '0';

    while(len1 >=0 && len2 >=0)
    {
        s[len] = (s1[len1] ^ s2[len2] ^ carry);
        carry = s1[len1] & s2[len2] | carry & s1[len1] |  carry & s2[len2];

        --len, --len1, --len2;
    }
	
	while(len1 >= 0)
	{
		s[len] = (s1[len1] ^ carry) + '0';
		carry = s1[len1] & carry;
		--len, --len1;
	}
	
	while(len2 >= 0)
	{
		s[len] = (s2[len2] ^ carry) + '0';
		carry = s2[len2] & carry;
		--len, --len2;
	}
	

    if (carry ^ '0') //if carry is '1', insert carry 
        s.insert(s.begin(), carry);

    return s;
}



ListNode *AddTwoNumbers(ListNode *l1, ListNode *l2) 
{
    if (!l1) return l2;
    if (!l2) return l1;

    int val = l1->val + l2->val;
    bool carried = (val>9);
    ListNode* head = new ListNode(val%10);
    ListNode* p =head;

    l1 = l1->next;
    l2 = l2->next;

    //add up number in each node
    while(l1 && l2)
    {
        val = l1->val + l2->val + (carried? 1 : 0);
        carried = (val > 9);
        p->next = new ListNode(val%10);

        l1 = l1->next;
        l2 = l2->next;
        p = p->next;
    }

    //Add up the remain numbers with carried
    ListNode* remain = l1? l1 : l2;
    while(remain)
    {
        val = remain->val + (carried? 1 : 0);
        carried = (val > 9);
        p->next = new ListNode(val%10);

        p = p->next;
        remain=remain->nex;
    }
    
    //if there still has carried, add '1'
    if (carried)p->next = new ListNode(1);

    return head;
}