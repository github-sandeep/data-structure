package com.sandeep.dp;

public class CoinChangeTotal {
    public int countRecur(int coins[], int n, int V) {
        if(V == 0)
            return 1;
        if (V < 0)
            return 0;

        if(n <= 0 && V > 0)
            return 0;
        return countRecur(coins, n-1, V) + countRecur(coins, n, V- coins[n-1]);
    }

    public int count(int coins[], int n, int V) {
        int T[] = new int[V+1];
        T[0] = 1;
        for(int  i=1; i <= V; i++) {
            T[i] = 0;
        }

        for(int  i=0; i < n; i++) {
            for(int j = 1; j <= V; j++) {
                if(coins[i] <= j)
                    T[j] = T[j] + T[j-coins[i]];
            }
        }
        return T[V];
    }

    public static void  main(String args[])
    {
        int coins[] = { 1, 2, 3 };
        int m = coins.length;
        System.out.println(new CoinChangeTotal().countRecur(coins, m, 4));
        System.out.println(new CoinChangeTotal().count(coins, m, 4));
    }
}
