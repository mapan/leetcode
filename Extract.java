public boolean canExtract(String s, List<String> l) {
  if (s == null || l == null) return false;
  // assume s will not be empty, otherwise iterate the list l to see if
  // it contains an empty string.
  return canExtract(s, l, new HashSet<Integer>());
}
// Version 1
private boolean canExtract(String s, List<String> l, HashSet<Integer> usedIndexes) {
  if (s.isEmpty()) return true;
  for (int i = 0; i < l.size(); i++) {
    if (usedIndexes.contains(i)) continue;
    String a = l.get(i);
    if (a.equals(s.substring(0, a.length())) {
      usedIndexes.add(i);
      if (canExtract(s.substring(a.length()), l, usedIndexes)) return true;
      usedIndexes.remove(i); // backtrack
    }
  }
  return false;
}
/**
 * Time complexity:
 * Worst Case: s = "111111112", l = {"1", "1", "11", "111", "1111"....},
 * basically we will find the match String for every prefix of s in l, but actually there is no right extraction at all,
 * then we will call canExtract() on the same suffix of s repeatedly.
 * That is, we basically are segmenting s at each possible position to see if there is a correct extraction from l.
 * Let's say s's length is N, then there are N - 1 possible positions where you can segment s
 * ("abc" has 2 (denoted by comma): "a,b,c"), each position has two cases: segment or not, so in total there are
 * 2^(N-1) possible ways to segment s (i.e. the number of times we call canExtract).
 * So it is O(2^N).
 **/

// To improve it, we found that we've looking at the the same suffix repeatedly, so we can use the memorization.
// Version 2
HashSet<String> canNotExtracted; // member variable
private boolean canExtract(String s, List<String> l, HashSet<Integer> usedIndexes) {
  if (s.isEmpty()) return true;
  if (canNotExtracted.contains(s)) return false;
  for (int i = 0; i < l.size(); i++) {
    if (usedIndexes.contains(i)) continue;
    String a = l.get(i);
    if (a.equals(s.substring(0, a.length())) {
      usedIndexes.add(i);
      if (canExtract(s.substring(a.length()), l, usedIndexes)) return true;
      usedIndexes.remove(i); // backtrack
    }
  }
  canNotExtracted.add(s);
  return false;
}
// Time: Basically, we will only call canExtract on the unique suffix of s.
// Since there are only N - 1 unique suffix, and the last suffix (the shortest one) will be called N times, the second last
// will be called N - 1 times and so on. So total time is O(N^2)
