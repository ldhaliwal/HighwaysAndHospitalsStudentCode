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


        // Easy check for if hospitals are cheaper than highways, build at hospital in each city
        if (hospitalCost <= highwayCost){
            return ((long) hospitalCost * n);
        }

        // Thinking about other case(s?)
        // what if hospitals and highways cost the same? does that even matter?
            // update from later: i think this can get grouped with the
            // "if hospitals are cheaper one" because it doesn't matter


        //How to approach this:
        // weighted edges?
            // find the cheapest path? BFS again but with weights??

        // cyclying through each possibility
            // ie. if hospital is placed at city 1, then recursive all possibilities of highways/hospitals being places
        // seems like it would take too long and be really inefficient, but that seems like the best idea?

        // or some sort of nested loops?
        // if currentCost < cost, cost = currentCost
            // ^^ that sort of thing to check what is the cheapest combination


        // not sure what the algorithm is supposed to look like at all





        return 0;
    }
}
