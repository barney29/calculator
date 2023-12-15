public class Conversion {
    private CustomeStack _stack;
    private String _input;
    private String _output;

    public Conversion(String input_expr){
        _input = input_expr;
        _stack = new CustomeStack(_input);
    }

    public String toPostFix(){
        for(int j = 0; j < _input.length(); j++){
            char ch = _input.charAt(j);
            switch (ch){
                case '+':
                case '-':
                    get_precedence(ch, 1);
                    break;
                case '*':
                case '/':
                    get_precedence(ch, 2);
                    break;
                case '(':
                    _stack.push(ch);
                    break;
                case ')':
                    closed_paranthesis(ch);
                    break;
                default:
                    _output = _output + ch;
                    break;
            }
        }
        while(!_stack.isEmpty()){
            _output = _output + _stack.pop();
        }
        return _output;
    }

    public void get_precedence(char current_opr, int prec){
        while(!_stack.isEmpty()){
            char opTop = _stack.pop();
            if(opTop == '('){
                _stack.push(opTop);
                break;
            } else {
                int prec2;
                if(opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if(prec2 < prec){
                    _stack.push(opTop);
                    break;
                }
                else
                    _output = _output + opTop;
            }
        }
        _stack.push(current_opr);
    }
    public void closed_paranthesis(char ch){
        while(!_stack.isEmpty()){
            char chx = _stack.pop();
            if( chx == '(')
                break;
            else
                _output = _output + chx;
        }
    }
}
