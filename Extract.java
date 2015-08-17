public boolean canExtract(String s, List<String> l) {
  if (s == null || l == null) return false;
  // assume s will not be empty, otherwise iterate the list l to see if
  // it contains an empty string.
}
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
