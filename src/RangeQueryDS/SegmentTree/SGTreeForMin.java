package RangeQueryDS.SegmentTree;

class SGTreeForMin {
    final int[] seg;

    /**
     * @param n initializes the segment tree array with a size 4 * n + 1, for an array of size n
     */
    SGTreeForMin(int n) {
        seg = new int[4 * n + 1];
    }

    /**
     * <p>Creates a segment tree from the given array</p>
     * <p>Time Complexity -> O(n)</p>
     * <p>This particular segment tree is for the minimum value within the given range</p>
     *
     * @param ind  index in the segment tree array
     * @param low  lower bound of input array index
     * @param high upper bound of input array index
     * @param arr  array whose segment tree is being created
     */

    void build(int ind, int low, int high, int[] arr) {
        //Single element
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) >> 1;
        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    /**
     * <p>Query the segment tree for the range [l, r] inclusive</p>
     * <p>Time Complexity -> O(log n)</p>
     * <p>This particular segment tree gives the minimum value within [l, r]</p>
     *
     * @param ind  index in the segment tree array
     * @param low  lower bound of input array index
     * @param high upper bound of input array index
     * @param l    lower bound of the range we are querying for
     * @param r    upper bound of the range we are querying for
     * @return returns the minimum value between indexes [l, r]
     */

    int query(int ind, int low, int high, int l, int r) {
        //No overlap
        // [low high] {l r} OR {l r} [low high]
        if (l > high || r < low) return Integer.MAX_VALUE;
        //Complete overlap
        // {l [low high] r}
        if (l <= low && r >= high) return seg[ind];
        //Partial overlap
        // [low {l high] r} OR {l [low r} high]
        int mid = (low + high) >> 1;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return Math.min(left, right);
    }

    /**
     * <p>Update the segment tree value after change in array value</p>
     * <p>Time Complexity -> O(log n)</p>
     *
     * @param ind    index in the segment tree array
     * @param low    lower bound of input array index
     * @param high   upper bound of input array index
     * @param updInd index in the array (whose tree is built), that needs to be updated
     * @param updVal value that has to be assigned at updInd
     */

    void update(int ind, int low, int high, int updInd, int updVal) {
        if (low == high) {
            seg[ind] = updVal;
            return;
        }
        int mid = (low + high) >> 1;
        if (updInd <= mid) update(2 * ind + 1, low, mid, updInd, updVal);
        else update(2 * ind + 2, mid + 1, high, updInd, updVal);
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

}