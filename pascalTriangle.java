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
            int previous=result.get(0);
            for(int column=1;column<row;column++) {
                int current=result.get(column);
                result.set(column,previous+current);
                previous=current;
            }
        }
        return result;
    }
}

