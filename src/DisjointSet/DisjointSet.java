package DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent, rank, size;

    public DisjointSet(int n) {
        parent = new ArrayList<>(n + 1);
        rank = new ArrayList<>(n + 1);
        size = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
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

    //Use either, not both
    public void unionBySize(int u, int v) {
        int ultParU = findUltimateParent(u);
        int ultParV = findUltimateParent(v);
        if (ultParU == ultParV) return;
        if (size.get(ultParU) > size.get(ultParV)) {
            parent.set(ultParV, ultParU);
            size.set(ultParU, size.get(ultParU) + size.get(ultParV));
        } else {
            parent.set(ultParU, ultParV);
            size.set(ultParV, size.get(ultParU) + size.get(ultParV));
        }
    }

    public boolean areConnected(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }

//    public static void main(String[] args) {
//        DisjointSet ds = new DisjointSet(7);
//        ds.unionBySize(1, 2);
//        ds.unionBySize(2, 3);
//        ds.unionBySize(4, 5);
//        ds.unionBySize(6, 7);
//        ds.unionBySize(5, 6);
//        System.out.println(ds.areConnected(3, 7));
//        ds.unionBySize(3, 7);
//        System.out.println(ds.areConnected(3, 7));
//    }
}
