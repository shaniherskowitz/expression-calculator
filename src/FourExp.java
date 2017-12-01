import java.util.Map;

/**
 * bonus.
 */
public abstract class FourExp extends BaseExpression {
    /**
     * first exp.
     */
    private Expression num1;
    /**
     * second exp.
     */
    private Expression num2;
    /**
     * third exp.
     */
    private Expression num3;
    /**
     * forth exp.
     */
    private Expression num4;

    /**
     * constroctor.
     *
     * @param one   first expression
     * @param two   second expression
     * @param three third expression
     * @param four forth expression
     */
    public FourExp(Expression one, Expression two, Expression three, Expression four) {
        this.num1 = one;
        this.num2 = two;
        this.num3 = three;
        this.num4 = four;

    }

    /**
     * @param one   first expression.
     * @param two   second expression
     * @param three second expression
     * @param four forth expression
     *              gets new exp using specific type
     * @return new exp of same type with exps
     */
    protected abstract Expression type(Expression one, Expression two, Expression three, Expression four);

    /**
     * @return result
     * @throws Exception if cannot evaluate this type.
     *                   calculates a binary expression
     */
    protected abstract double evaluate() throws Exception;

    /**
     * gets the sign of specific expression.
     *
     * @return string with sign
     */
    public abstract String getSign();

    /**
     * @param assignment map to set values of variables by.
     *                   plugs variables values into expression
     * @return evaluated expression
     * @throws Exception if val in map is not in the assignment
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double number;
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
            if (this.num3.getVariables().contains(str)) {
                this.num3 = this.num3.assign(str, new Num(number));
            }

            /*for (int i = 0; i < this.type(this.num1, this.num2, this.num3, this.num4).getVariables().size(); i++) {
                if (!pair.getKey().equals(this.type(this.num1, this.num2, this.num3,
                 this.num4).getVariables().get(i)) {
                    count++;
                }
            }

        }
        if (count == this.type(this.num1, this.num2, this.num3, this.num4).getVariables().size()) {
            throw new Exception("val not in assignment");
        }*/
        }

        return this.type(this.num1, this.num2, this.num3, this.num4).evaluate();

    }

    /**
     * @param var        variable to assign.
     * @param expression to place in var.
     * @return places an expression inside a variable
     */
    public Expression assign(String var, Expression expression) {

        Expression first = this.num1;
        Expression second = this.num2;
        Expression third = this.num3;
        Expression forth = this.num4;

        if (this.num1.getVariables().contains(var)) {
            first = this.num1.assign(var, expression);
        }
        if (this.num2.getVariables().contains(var)) {
            second = this.num2.assign(var, expression);
        }
        if (this.num3.getVariables().contains(var)) {
            third = this.num3.assign(var, expression);
        }
        if (this.num4.getVariables().contains(var)) {
            forth = this.num4.assign(var, expression);
        }


        return this.type(first, second, third, forth);
    }

    /**
     * represents the four expression in a string.
     *
     * @return the string.
     */
    public String toString() {
        return "(" + this.num1.toString() + this.getSign()
                + this.num2.toString() + this.getSign() + this.num3.toString()
                + this.getSign() + this.num4.toString() + ")";

    }

    /**
     * checks if the expressions hold the same equivalent expression.
     * @param one first expression
     * @param two second expression
     * @return if they do
     */
    public boolean checkSame(Expression one, Expression two) {
        return (one.getVariables().containsAll(two.getVariables())
                && two.getVariables().containsAll(one.getVariables())
                && (two.getSign().equals(" * ")
                && one.getSign().equals(" * "))
                || one.getVariables().containsAll(two.getVariables())
                && two.getVariables().containsAll(one.getVariables())
                && ((two.toString().contains("^")
                && one.toString().contains("^"))));
    }




}


