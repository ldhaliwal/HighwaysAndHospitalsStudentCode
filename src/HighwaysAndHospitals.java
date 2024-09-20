import java.sql.Array;
import java.util.ArrayList;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Liliana Dhaliwal
 *
 */

public class HighwaysAndHospitals {
    public static long cost(int n, int hospitalCost, int highwayCost, int[][] cities) {
        // Makes a map store all root/node connections (starting at index 1, not 0 for clarity)
        int[] root = new int[n + 1];

        // Checks if hospitals are cheaper than highways, and if so, builds a hospital in each city
        if (hospitalCost <= highwayCost){
            return ((long) hospitalCost * n);
        }

        // Performs union-find algorithm to store root/node connections
        for (int[] city : cities) {
            // Finds the root of the parent and child nodes
            int parentRoot = findRoot(city[0], root);
            int childRoot = findRoot(city[1], root);

            // If the roots are not the same, set the parent's root to be the child's root
            if (childRoot != parentRoot) {
                root[childRoot] = parentRoot;
            }
        }

        // Finds the number of empty roots to count the number of clusters
        int numClusters = 0;
        for (int i = 0; i< root.length; i++){
            if(root[i] == 0 && i !=0 ){
                numClusters++;
            }
        }

        // Calculates and returns the final cost
        return (((long) numClusters * hospitalCost) + ((long) (n - numClusters) *highwayCost));
    }

    // Finds the roots of the node that is passed in
    public static int findRoot(int i, int[] root){
        // Base case
        if (root[i] == 0) {
            return i;
        }

        // Recursive call
        root[i] = findRoot(root[i], root);
        return root[i];
    }
}
