public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double r=1,s=x;
        long p=1;
        int pw=Math.abs(n);
        while(p<=pw) {
            if((pw&p)!=0) r*=s;
            p<<=1;
            s*=s;
        }
        return n<0?1/r:r;
    }
}

public class Solution {
    public int log(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x==1) return 1;
        int c=0;
        long p=1;
        while(p<=x) {
            c++;
            p<<=1;
        }
        return c-1;
    }
}

public static void gcd(int a,int b) {
		if(b == 0) 
			System.out.println(a);
		else
			gcd(b,a%b);
	}
	http://www.proofwiki.org/wiki/GCD_with_Remainder


#include <stdio.h>

int power(int a, int b) {
	if(b==1) return a;
	int half = power(a,b/2);
	if(b%2 != 0)
		return a*half*half;
	else
		return half*half;
}

int main() {
	int a,b;
	scanf("%d %d\n",&a,&b);
	printf("%d\n",power(a,b));
}

public static void power(int a,int b) {
	int binaryBit = 1;
	int result = 1;
	int c = a;
	while(binaryBit <= b) {
		if((binaryBit&b) != 0) { 
			result *= c;
		}
		binaryBit *= 2;
		c *= c;
	}
	System.out.println(result);
}

/*int power(int a, int b) {
	int c = 1;
	int result = 1;
	int d = 1;
	while(c <= b) {
	  d *= a;
      if (c&b) {
         result *= d;
      }
	  c *= 2;
	}
	return result;*/
	
	
	#include <iostream>
#include <string>
using namespace std;
#include <algorithm>

void permute(string soFar, string rest) {
	if(rest == "") {
		cout << soFar << endl;
	}
	else {
		for(int i = 0;i < rest.length();i++) {
			bool found = false;
			for (int j = 0; j < i; j++) 
			{
			    if (rest[j] == rest[i])
				found = true;
			}
	        if(found)
	            continue;
			string next = soFar + rest[i];
			string remaining = rest.substr(0,i) + rest.substr(i+1);
			int left = count(soFar.begin(),soFar.end(),'(');
			int right = count(soFar.begin(),soFar.end(),')');
			if(right <= left)
				permute(next, remaining);
		}
	}
}

int main() {
	permute("","()()()");
}


import java.util.*;
import java.lang.*;
import java.io.*;

public class Phone {
	static char c[][] = {{'a','b','c'},{'d','e','f'},{'A','B','C'}};
	public static char getChar(int digit, int index) {
		return c[digit][index];
	}
	public static void charCombination(String soFar, int[] number, int index) {
		if(index == number.length) {
			System.out.println(soFar);
		}
		else {
			for(int i = 0;i < 3;i++) {
				String next = soFar+getChar(number[index],i);
				charCombination(next, number, index+1);
			}
		}
	}
	
	
	
	public static void replace(String s) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i < s.length();i++) {
			if(s.charAt(i) == ' ')
				builder.append("%20");
			else
				builder.append(s.charAt(i));
		}
		int[][] a = new int[2][3];
		System.out.println(a[0].length);
		System.out.println(builder.toString());
	}
	
	public static void power(int a,int b) {
		int binaryBit = 1;
		int result = 1;
		int c = a;
		while(binaryBit <= b) {
			if((binaryBit&b) != 0) { 
				result *= c;
			}
			binaryBit *= 2;
			c *= c;
		}
		System.out.println(result);
	}
	
	public static void main(String args[]) {
		int[] num = {0,1,2};
		//charCombination("",num,0);
		//gcd(15,4);
		//replace("asdfds dsfds dsfdsf");
		//power(2,7);
		//char a = 'b';a=a+1;
		String a = ""; a += (char)('c'+1);
		System.out.println(a);
	}
}


