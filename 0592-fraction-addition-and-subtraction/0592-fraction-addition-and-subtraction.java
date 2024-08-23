class Solution {
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public String fractionAddition(String expression) {
        List<String> fractions = new ArrayList<>();
        int i = 0;
        int n = expression.length();
        
        while(i < n){
            int start = i;
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-') i++;
            while(i < n && expression.charAt(i) != '+' && expression.charAt(i) != '-') i++;
            fractions.add(expression.substring(start, i));
        }
        
        String[] firstFraction = fractions.get(0).split("/");
        int totalNumerator = Integer.parseInt(firstFraction[0]);
        int totalDenominator = Integer.parseInt(firstFraction[1]);
        
        for(int j=1; j<fractions.size(); j++){
            String[] parts = fractions.get(j).split("/");
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            
            totalNumerator = totalNumerator * denominator + numerator * totalDenominator;
            totalDenominator = totalDenominator * denominator;
            
            int commonDivisor = gcd(Math.abs(totalNumerator), totalDenominator);
            totalNumerator /= commonDivisor;
            totalDenominator /= commonDivisor;
        }
        
        return totalNumerator + "/" + totalDenominator;
    }
}