package com.rizwanmushtaq.unionFindProblem;

public class UnionFindQuickUnion {
  private int[] parent; // parent[i] = parent of i
  private int count;    // number of components

  // Create an empty union find data structure with N isolated components 0 through N-1
  public UnionFindQuickUnion(int N) {
    count = N;
    parent = new int[N];
    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }
  }

  // Return the number of components
  public int count() {
    return count;
  }

  // Are elements p and q in the same component?
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  // Return the component identifier for the component containing p
  public int find(int p) {
    validate(p);
    while (p != parent[p]) {
      p = parent[p];
    }
    return p;
  }

  // Merge components containing p and q
  public void union(int p, int q) {
    validate(p);
    validate(q);
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) return;

    parent[rootP] = rootQ;
    count--;
  }

  // Validate that p is a valid index
  private void validate(int p) {
    int n = parent.length;
    if (p < 0 || p >= n) {
      throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
    }
  }
}
