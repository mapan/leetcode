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
