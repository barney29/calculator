public class CustomeStack {
    private int _max_size;
    private char[] _stack;
    private String _input;
    private int _top;
    public CustomeStack(String s){
        _input = s;
        _max_size = _input.length();
        _stack = new char[_max_size];
        _top = -1;
    }

    public void push(char value){
        _stack[++_top] = value;
    }
    public char pop(){
        return _stack[_top--];
    }

    public char peek(){
        return _stack[_top];
    }

    public boolean isEmpty(){
        return (_top == -1);
    }
    public boolean isFull(){
        return (_top == _max_size);
    }
}
