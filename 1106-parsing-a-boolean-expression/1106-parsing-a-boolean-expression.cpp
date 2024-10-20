class Solution {
    void evaluate(stack<char>& operators, stack<char>& operands) {
        char op = operators.top();
        operators.pop();
        
        bool ans;
        if(op == '|') {
            ans = false;
            while(operands.top() != '(') {
                ans |= (operands.top() == 't');
                operands.pop();
            }
            operands.pop();
        }
        else if(op == '&') {
            ans = true;
            while(operands.top() != '(') {
                ans &= (operands.top() == 't');
                operands.pop();
            }
            operands.pop();
        }
        else if(op == '!') {
            ans = (operands.top() == 't');
            ans = !ans;
            operands.pop();
            operands.pop();
        }
        
        if(ans) operands.push('t');
        else operands.push('f');
    }
    
public:
    bool parseBoolExpr(string expression) {
        stack<char> operators, operands;
        int index = 0;
        
        while(expression[index]) {
            if(expression[index] == '!' || expression[index] == '&' || expression[index] == '|') {
                operators.push(expression[index]);
            } 
            else if(expression[index] == 't' || expression[index] == 'f') {
                operands.push(expression[index]);
            } 
            else if(expression[index] == '(') {
                operands.push(expression[index]);
            } 
            else if(expression[index] == ')') {
                evaluate(operators, operands);
            }
            index++;
        }
        
        return operands.top() == 't';
    }
};