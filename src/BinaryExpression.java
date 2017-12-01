import java.util.Arrays;
import java.util.Map;

/**
 * class that implements functions for binary math expressions.
 */
public abstract class BinaryExpression extends BaseExpression {
    /**
     * first exp.
     */
    private Expression num1;
    /**
     * second exp.
     */
    private Expression num2;


    /**
     * constroctor.
     * @param one first expression
     * @param two second expression
     *
     */
    public BinaryExpression(Expression one, Expression two) {
            this.num1 = one;
            this.num2 =  two;

    }
    /**
     * @param one first expression.
     * @param two second expression
     * gets new exp using specific type
     * @return new exp of same type with exps
     *
     */
    protected abstract Expression type(Expression one, Expression two);
    /**
     * @throws Exception if cannot evaluate this type.
     * calculates a binary expression
     * @return result
     */
    protected abstract double evaluate() throws Exception;
    /**
     *  gets the sign of specific expression.
     *   @return string with sign
     */
    public abstract String getSign();

    /**
     * @param assignment map to set values of variables by.
     * plugs variables values into expression
     * @return evaluated expression
     * @throws Exception if val in map is not in the assignment
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double number;
        int count = 0;
        String str;
        for (Map.Entry<String, Double> pair : assignment.entrySet()) {
            number = pair.getValue();
            str = pair.getKey();


            if (this.num1.getVariables().contains(str)) {
                this.num1 = this.num1.assign(str, new Num(number));
            }
            if (this.num2.getVariables().contains(str)) {
                this.num2 = this.num2.assign(str, new Num(number));
            }

            /*for (int i = 0; i < this.type(this.num1, this.num2).getVariables().size(); i++) {
                if (!pair.getKey().equals(this.type(this.num1, this.num2).getVariables().get(i))) {
                    count++;
                }
            }

        }
        if (count == this.type(this.num1, this.num2).getVariables().size()) {
            throw new Exception("val not in assignment");
        }*/
        }

        return this.type(this.num1, this.num2).evaluate();

    }
    /**
     * @param var variable to assign.
     * @param expression to place in var.
     * @return places an expression inside a variable
     */
    public Expression assign(String var, Expression expression) {

        Expression first = this.num1;
        Expression second = this.num2;

        if (this.num1.getVariables().contains(var)) {
            first = this.num1.assign(var, expression);
        }
        if (this.num2.getVariables().contains(var)) {
            second = this.num2.assign(var, expression);
        }


        return this.type(first, second);
    }

    /**
     * represents the binary expression in a string.
     * @return the string.
     */
    public String toString() {
        return "(" + this.num1.toString() + this.getSign() + this.num2.toString() + ")";

    }
    /**
     * checks if the expressions hold the same equivalent expression.
     * @return if they do
     */
    public boolean checkSame() {
        char[] str1 = this.num1.toString().toCharArray();
        char[] str2 = this.num2.toString().toCharArray();
        char temp;
        if (num1.getVariables().containsAll(num2.getVariables())
                && num2.getVariables().containsAll(num1.getVariables())
                && this.num1.getSign().equals(this.num2.getSign())
                && !this.num1.getSign().equals(" - ")) {
            Arrays.sort(str1);
            Arrays.sort(str2);

            for (int i = 0; i < str1.length - 1; i++) {
                if (str1[i] != str2[i]) {
                    return false;
                }
            }
            return true;
        }

            return false;
    }

    /**
     * @return num 1 of binary.
     *
     */
    public Expression getNum1() {
        return this.num1;
    }
    /**
     * @return num 2 of binary.
     *
     */
    public Expression getNum2() {
        return this.num2;
    }




}
      /*int count = 0;

            //if (this.num1.getSign().equals("log") || this.num1.getSign().equals("sin")
              //      || this.num1.getSign().equals("cos")) {

                if (this.num1.getSign().equals("log")) {
                    count++;
                }

                for (int i = 0; i < this.num1.toString().length() && i < this.num2.toString().length(); i++) {
                    if (this.num1.toString().charAt(i) <= 57 && this.num1.toString().charAt(i) >= 48) {
                        check1++;
                    }
                    if (this.num2.toString().charAt(i) <= 57 && this.num2.toString().charAt(i) >= 48) {
                        check2++;
                    }
                    if (this.num1.toString().charAt(i) != this.num2.toString().charAt(i)
                            || this.num1.toString().charAt(i) == '-') {
                        count++;
                    }
                }
                if (check1 != check2) {
                    return false;
                }
                count -= check1*2;

                if (count > this.num1.getVariables().size() + (check1 / 2)) {
                    return false;
                }
            //}
            return true;
        }
        return false;*/