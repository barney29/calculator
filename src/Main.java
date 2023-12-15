import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner getstr = new Scanner(System.in);
        String input, output;
        while(true) {
            System.out.print("Enter expression: ");
            input = getstr.nextLine();
            if (input.equals(""))
                break;

            Conversion postfix_expr = new Conversion(input);
            output = postfix_expr.toPostFix();
            String expression = "";
            //idk why it return null before every postfix
            //to remove the null value
            for (int j = 4; j < output.length(); j++)
                expression += output.charAt(j);
            ComputeExpression computeExpression = new ComputeExpression(expression);
            int result = computeExpression.compute();
            System.out.println(result);
            System.out.println(expression);
        }
    }
}