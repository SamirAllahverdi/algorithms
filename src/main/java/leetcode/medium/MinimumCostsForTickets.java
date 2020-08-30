package leetcode.medium;

public class MinimumCostsForTickets {

    /**
     * https://leetcode.com/problems/minimum-cost-for-tickets/solution/
     */


    public static void main(String[] args) {

        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        System.out.println(mincostTickets(days, costs));
    }


    static int[] days, costs;
    static Integer[] memo;
    static int[] durations = new int[]{1, 7, 30};


    public static int mincostTickets(int[] days, int[] costs) {
        MinimumCostsForTickets.days = days;
        MinimumCostsForTickets.costs = costs;
        memo = new Integer[days.length];

        return dp(0);
    }

    public static int dp(int i) {
        System.out.println("I " + i);
        if (i >= days.length)
            return 0;
        if (memo[i] != null)
            return memo[i];
        int ans = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j++;
            }
            ans = Math.min(ans, dp(j) + costs[k]);
        }
        
        memo[i] = ans;
        return ans;
    }

}
