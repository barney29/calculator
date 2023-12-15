import org.w3c.dom.ls.LSOutput;

public class ComputeExpression {
    private StackInt _stack;
    private String _input;
    public ComputeExpression(String input){
        _input = input;
        _stack = new StackInt();
    }

    public int compute(){
        char ch;
        int j, num1, num2, ans = 0;

        for(j = 0; j < _input.length(); j++){
            ch = _input.charAt(j);

            if(ch >= '0' && ch <= '9'){
                _stack.push((int) ch);
                System.out.println("ch pushed "+ ch);
            }

            else
            {
                num2 = _stack.pop();
                num1 = _stack.pop();
                //it return 53 and 52 idk why
                System.out.println("num2 "+ num2 + " num1 "+ num1);

                switch (ch){
                    case '+':
                        ans = num1 + num2;
                        break;
                    case '-':
                        ans = num1 - num2;
                        break;
                    case '*':
                        ans = num1 * num2;
                        break;
                    case '/':
                        ans = num1 / num2;
                        break;
                    default:
                        ans = 0;
                }
                _stack.push(ans);
                System.out.println("Answer pushed "+ans);
            }


        }
        ans = _stack.pop();
        System.out.println("Answer popped "+ ans);
        return ans;
    }
}
