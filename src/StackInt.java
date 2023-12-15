import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackInt {
    private List<Integer> _stack;
    public StackInt(){
        _stack = new ArrayList<>();
    }
    public void push(int value){
        _stack.add(value);
    }
    public int pop(){
        if(_stack.isEmpty()){
            throw new EmptyStackException();
        }
        return _stack.remove(_stack.size() - 1);
    }

    public boolean isEmpty(){
        return _stack.isEmpty();
    }
}
