/**
 * changes expression to negative.
 */
public class Neg extends UnaryExpression implements Expression {
    /**
     * changes expression to negative.
     */
    private Expression num;

    /**
     * constructor.
     * @param number to change
     */
    public Neg(Expression number) {
        super(number);
        this.num = number;
    }
    /**
     * constructor.
     * @param x variable to change
     */
    public Neg(String x) {
        super(new Var(x));
        this.num = new Var(x);

    }
    /**
     * constructor.
     * @param num1 number to change
     */
    public Neg(double num1) {
        super(new Num(num1));
        this.num = new Num(num1);

    }
    /**
     * @param one returns new neg of current exp.
     * @return new neg of current exp
     */
    public Expression type(Expression one) {
        return new Neg(one);
    }

    /**
     * calculates neg of numbers.
     * @throws Exception if there is variable in exp
     * @return result
     */
    public double evaluate() throws Exception {
        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }
        return -this.num.evaluate();
    }
    /**
     *
     * @return string of minus sign.
     */
    public String getSign() {
        return "-";

    }
    /**
     * @param var to differentiate by.
     * @return result of differentiation
     */
    public Expression differentiate(String var) {
        return new Neg(this.num.differentiate(var));
    }

    /**.
     * @return simplified expression,
     * more clear gets rid of unnecessary characters
     *
     */
    public Expression simplify() {
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
            return this;
        }
    }
}
