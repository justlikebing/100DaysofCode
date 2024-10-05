class Day1{
    public static void main(String[] args){
    }
    public int maxProfit(int[] prices){
        int minprize = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length ; i++){
            if(prices[i] < minprize){
                minprize = prices[i];
            }
            else if(prices[i] - minprize > maxProfit){
                maxProfit = prices[i] - minprize;    
            }
        }
        return maxProfit;
    }
}
