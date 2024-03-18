package org.example;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,5,5,4,11};
        int[][] edges = {{0,1},{1,2},{1,3},{4,3}};

        int score = minimumScore(nums, edges);
        System.out.println("score = " + score);
    }

    public static int minimumScore(int[] nums, int[][] edges) {

        int n = edges.length;
        int xorAll = 0, xor1Downwards = 0, xor2Downwards = 0;
        int xor1 = 0, xor2 = 0, xor3 = 0;
        int[][] edgesSorted;
        int result = 1000000000;

        //Sort edges by 1st node
        java.util.Arrays.sort(edges, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        //Sort edges to set node[0] <= node[1]
        int tmp;
        for(int[] edge: edges){
            if(edge[0] > edge[1]){
                tmp = edge[0];
                edge[0] = edge[1];
                edge[1] = tmp;
            }
        }
        edgesSorted = edges;

        //XOR of all nodes
        for(int node: nums){
            xorAll ^= node;
        }

        int score = 1000000000;
        //Remove edge by edge
        for(int i = 0; i < n-1; i++){ //value of i is 1st edge to remove
            xor1Downwards = xorFromRoot(nums, edgesSorted, edgesSorted[i][1], i);
            for(int j = i + 1; j < n && j > i; j++) { //value of j is 2nd edge to remove
                xor2Downwards = xorFromRoot(nums, edgesSorted, edgesSorted[j][1], j);

                xor3 = xor2Downwards;
                xor2 = xor1Downwards ^ xor3;
                xor1 = xorAll ^ xor2;
                score = Math.max(xor1, Math.max(xor2, xor3)) - Math.min(xor1, Math.min(xor2, xor3));
                result = score < result? score : result;
            }
        }

        //int[] nums = {1,5,5,4,11};
        //int[][] edges = {{0,1},{1,2},{1,3},{3,4}};

        System.out.println("xor1 = " + xor1);
        System.out.println("xor2 = " + xor2);
        System.out.println("xor3 = " + xor3);
        System.out.println("xorAll = " + xorAll);
        System.out.println("xor2Downwards = " + xor2Downwards);
        System.out.println("xor1Downwards = " + xor1Downwards);

        return result;
    }

    //Calculate XOR from rootNode downwards
    static int xorFromRoot(int[] nums, int[][] edgesSorted, int rootIndex, int parentEdgeIndexRemoved){
        int xor = nums[rootIndex];
        for(int i = parentEdgeIndexRemoved + 1; i < edgesSorted.length; i++) {
//            if(edgesSorted[i][0] == rootIndex){
//                int x = edgesSorted[i][1];
//                int y = nums[x];
//                xor ^= y;
//            }

        }
        return xor;
    }
}
//int[] nums = {1,5,5,4,11};
//int[][] edges = {{0,1},{1,2},{1,3},{3,4}};


