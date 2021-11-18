package com.sandeep.dp;

public class MinimumCoin {
    public int minCoinsRecur(int coins[], int n, int V) {
        if(V == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i =0; i < n ; i++) {
            if(coins[i] <= V) {
                int ret = minCoinsRecur(coins, n, V-coins[i]);
                if(ret != Integer.MAX_VALUE && min > ret +1)
                    min = ret + 1;
            }
        }
        return min;
    }

    public int minCoins(int coins[], int n, int V) {
        int T[] = new int[V+1];
        T[0] = 0;
        for(int i = 1; i <= V ; i++) {
            T[i] = Integer.MAX_VALUE;
        }
            for(int i = 0; i < n ; i++) {
                for(int j = 1; j <= V ; j++) {
                if(coins[i] <= j) {
                    int temp = T[j-coins[i]];
                    if(temp!= Integer.MAX_VALUE && temp+1 < T[j]) {
                        T[j] = temp+1;
                    }
                }
            }
        }
        return T[V];
    }

    public static void main(String args[])
    {
        int coins[] =  {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "+ new MinimumCoin().minCoinsRecur(coins, m, V) );
        System.out.println("Minimum coins required is "+ new MinimumCoin().minCoins(coins, m, V) );
    }
}
