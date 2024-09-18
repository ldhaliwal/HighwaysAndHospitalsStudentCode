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

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Make a map (array) of size n +1 to store all root/node connections (starting at index 1, not 0 for clarity)
        int[] root = new int[n + 1];

        // Easy check for if hospitals are cheaper than highways, build at hospital in each city
        if (hospitalCost <= highwayCost){
            return ((long) hospitalCost * n);
        }

        // for each pair of nodes:
        for (int i = 0; i< cities.length; i++){
            int parentRoot = findRoot(cities[i][0], root);
            int childRoot = findRoot(cities[i][1], root);

            if (childRoot != parentRoot){
                root[childRoot] = parentRoot;
            }
        }

        int numClusters = 0;
        for (int i = 0; i< root.length; i++){
            if(root[i] == 0 && i !=0 ){
                numClusters++;
            }
        }

        return (((long) numClusters * hospitalCost) + ((long) (n - numClusters) *highwayCost));

    }

    public static int findRoot(int i, int[] root){
        if (root[i] == 0) {
            return i;
        }
        root[i] = findRoot(root[i], root); // Path compression
        return root[i];
    }
}
