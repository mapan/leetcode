public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(numRows==0) return result;
        ArrayList<Integer> single=new ArrayList<Integer>();
        single.add(1);
        result.add(single);
        for(int row=1;row<numRows;row++) {
            single=new ArrayList<Integer>();
            single.add(1);
            for(int column=1;column<row;column++) {
                single.add(result.get(row-1).get(column-1)+result.get(row-1).get(column));
            }
            single.add(1);
            result.add(single);
        }
        return result;
    }
}

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result=new ArrayList<Integer>();
        for (int i = 0; i < rowIndex+1; i++) {
            result.add(1);
        }
        for(int row=1;row<=rowIndex;row++) {
            for(int column=1;column<row;column++) {
                int a=column,result.get(column-1);
                result.set(+result.get(column));
            }
        }
        return result;
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
