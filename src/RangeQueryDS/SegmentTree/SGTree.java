package RangeQueryDS.SegmentTree;

class SGTree {
    int[] seg;

    SGTree(int n) {
        seg = new int[4 * n + 1];
    }

    void build(int ind, int low, int high, int[] arr) {
        //Single element
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) >> 1;
        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);
        seg[ind] = 0; //Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    int query(int ind, int low, int high, int l, int r) {
        //No overlap
        // [low high] {l r} OR {l r} [low high]
        if (l > high || r < low) return 0; //Integer.MAX_VALUE;
        //Complete overlap
        // {l [low high] r}
        if (l <= low && r >= high) return seg[ind];
        //Partial overlap
        // [low {l high] r} OR {l [low r} high]
        int mid = (low + high) >> 1;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return 0; //Math.min(left, right);
    }

    void update(int ind, int low, int high, int updInd, int updVal) {
        if (low == high) {
            seg[ind] = updVal;
            return;
        }
        int mid = (low + high) >> 1;
        if (updInd <= mid) update(2 * ind + 1, low, mid, updInd, updVal);
        else update(2 * ind + 2, mid + 1, high, updInd, updVal);
        seg[ind] = 0; //Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

}