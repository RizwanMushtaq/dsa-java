package com.rizwanmushtaq.ch1sec5;

public class UnionFindQuickFind {
  private int[] id; // id[i] = component identifier of i
  private int count; // number of components

  // Create an empty union find data structure with N isolated components 0 through N-1
  public UnionFindQuickFind(int N) {
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  // Return the number of components
  public int count() {
    return count;
  }

  // Are elements p and q in the same component?
  public boolean connected(int p, int q) {
    validate(p);
    validate(q);
    return id[p] == id[q];
  }

  // Return the component identifier for the component containing p
  public int find(int p) {
    validate(p);
    return id[p];
  }

  // Merge components containing p and q
  public void union(int p, int q) {
    validate(p);
    validate(q);
    int pID = find(p); // component identifier for p
    int qID = find(q); // component identifier for q

    // If p and q are already in the same component, do nothing
    if (pID == qID) return;

    // Rename p's component to q's name
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pID) {
        id[i] = qID;
      }
    }
    count--;
  }

  // Validate that p is a valid index
  private void validate(int p) {
    int n = id.length;
    if (p < 0 || p >= n) {
      throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
    }
  }
}
