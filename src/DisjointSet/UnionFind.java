package DisjointSet;

import java.util.ArrayList;
import java.util.List;

class UnionFind {
    List<Integer> parent, rank;

    public UnionFind(int n) {
        parent = new ArrayList<>(n + 1);
        rank = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) return node;
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    //Use either, not both
    public void unionByRank(int u, int v) {
        int ultParU = findUltimateParent(u);
        int ultParV = findUltimateParent(v);
        if (ultParU == ultParV) return;
        if (rank.get(ultParU) > rank.get(ultParV)) {
            parent.set(ultParV, ultParU);
        } else if (rank.get(ultParV) > rank.get(ultParU)) {
            parent.set(ultParU, ultParV);
        } else {
            parent.set(ultParV, ultParU);
            rank.set(ultParU, rank.get(ultParU) + 1);
        }
    }

    public boolean areConnected(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }
}
