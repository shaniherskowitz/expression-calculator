
import java.util.Map;

/**
 * class that implements functions for unary math expressions.
 */

public abstract class UnaryExpression extends BaseExpression {
    /**
     * number for calculation.
     */
    private Expression num;

    /**
     * @param one num to calculate.
     */
    public UnaryExpression(Expression one) {
        this.num = one;

    }


    /**
     * @param one returns new exp of same type with var.
     * @return new exp of same type with var
     */
    protected abstract Expression type(Expression one);
    /**
     * @throws Exception if cannot evaluate this type.
     * calculates a unary expression
     * @return result
     */
    protected abstract double evaluate() throws Exception;
    /**
     *  gets the sign of specific expression.
     *  @return string with sign
     */
    public abstract String getSign();

    /**.
     * @param assignment map to set values of variables by
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


            if (this.num.getVariables().contains(str)) {
                this.num = this.num.assign(str, new Num(number));
            }
            /*for (int i = 0; i < this.type(this.num).getVariables().size(); i++) {
                if (!pair.getKey().equals(this.type(this.num).getVariables().get(i))) {
                    count++;
                }
            }

        }
        if (count == this.type(this.num).getVariables().size()) {
            throw new Exception("val not in assignment");*/
        }
        return this.type(this.num).evaluate();

    }
    /**
     * @param var variable to assign.
     * @param expression to place in var.
     * @return places an expression inside a variable
     */
    public Expression assign(String var, Expression expression) {

        Expression first = this.num;

        if (this.num.getVariables().contains(var)) {
            first = this.num.assign(var, expression);
        }
        return this.type(first);
    }
    /**
     * represents the unary expression in a string.
     * @return the string.
     */
    public String toString() {
        return this.getSign() + "(" + this.num.toString() + ")";

    }

}
