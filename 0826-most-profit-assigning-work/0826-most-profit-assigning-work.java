class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] pairs=new int[profit.length][2];
        for(int i=0; i<profit.length; i++){
            pairs[i][0]=difficulty[i];
            pairs[i][1]=profit[i];
        }
        
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(worker);
        int p=0, bestProfit=0, totalProfit=0;
        for(int w:worker){
            while(p<pairs.length && w>=pairs[p][0]){
                bestProfit=Math.max(bestProfit,pairs[p++][1]);
            }
            totalProfit+=bestProfit;
        }
        return totalProfit;
    }
}