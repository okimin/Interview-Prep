import java.util.*;

public class best_time_to_buy_and_sell {
    public int maxProfit(int[] prices) {
        int buyDate = 0;
        int sellDate;

        int maxProfit = 0;
        for(sellDate = 1; sellDate < prices.length; sellDate++){
            if(prices[sellDate] <=prices[buyDate])
                buyDate = sellDate;
            else
                maxProfit = Math.max(prices[sellDate] - prices[buyDate], maxProfit);
        }
        return maxProfit;
    }
}
