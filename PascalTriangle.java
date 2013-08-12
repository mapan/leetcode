import java.util.*;
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> tri=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row;
        for(int i=0;i<numRows;i++) {
            row=new ArrayList<Integer>(i+1);
            row.add(0,1);
            //if(i!=0) row.add(i,1); //make the size 1 out of bounds will add twice
			//Shifts the element currently at that position (if any) 
			//and any subsequent elements to the right (adds one to their indices).
			// the list is empty and you cannot access a list position that doesn't exist..
            for(int j=1;j<=i-1;j++) {
                int val=tri.get(i-1).get(j-1)+tri.get(i-1).get(j);
                row.add(j,val);
            }
            if(i!=0) row.add(i,1);
            tri.add(row);
        }
        return tri;
    }
	public static void main(String []args) {
		generate(4);
	}
}

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> tri=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row=new ArrayList<Integer>();
        if(rowIndex==0) {
            row.add(1);
            return row;
        }
        row.add(0,1);
        for(int i=0;i<=rowIndex;i++) {
            int previous=0;
            for(int j=1;j<=i-1;j++) {
                int val=0;
                if(j==1) {
                    val=tri.get(i-1).get(j-1)+tri.get(i-1).get(j);
                    previous=val-1;
                }
                else {
                    val=previous+tri.get(i-1).get(j);
                    previous=val-previous;
                }
                row.set(j,val);
            }
            if(i!=0) row.add(i,1);
            tri.add(row);
        }
        return tri.get(rowIndex);
    }
}