class Solution {
    private List<Integer> numbers;
    private List<Character> operators;
    private List<Integer>[][] dp;
    
    private int calculate(int a, int b, char op){
        if(op == '+') return a + b;
        if(op == '-') return a - b;
        return a * b;
    }
    
    private void parseExpression(String expression){
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
        int num = 0;
        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)) num = num * 10 + (ch - '0');
            else {
                numbers.add(num);
                operators.add(ch);
                num = 0;
            }
        }
        numbers.add(num);
    }
    
    private List<Integer> compute(int left, int right){
        if(dp[left][right] != null) return dp[left][right];
        
        List<Integer> result = new ArrayList<>();
        if(left == right) result.add(numbers.get(left));
        else {
            for(int i=left; i<right; i++){
                List<Integer> leftPart = compute(left, i);
                List<Integer> rightPart = compute(i + 1, right);
                char op = operators.get(i);
                
                for(int l : leftPart){
                    for(int r : rightPart){
                        result.add(calculate(l, r, op));
                    }
                }
            }
        }
        dp[left][right] = result;
        return result;
    }
    
    public List<Integer> diffWaysToCompute(String expression) {
        parseExpression(expression);
        int n = numbers.size();
        dp = new ArrayList[n][n];
        return compute(0, n - 1);
    }
}