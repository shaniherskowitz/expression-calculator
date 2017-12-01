/**
 * calculate sin of expression.
 */
public class Sin extends UnaryExpression implements Expression {
    /**
     * calculate sin of expression.
     */
    private Expression num;

    /**
     * constructor.
     * @param number to calculate
     */
    public Sin(Expression number) {
        super(number);
        this.num = number;
    }
    /**
     * constructor.
     * @param x variable calculate
     */
    public Sin(String x) {
        super(new Var(x));
        this.num = new Var(x);

    }
    /**
     * constructor.
     * @param num1 number to calculate
     */
    public Sin(double num1) {
        super(new Num(num1));
        this.num = new Num(num1);

    }
    /**
     * @param one returns new sin of current exp.
     * @return new exp with sin type
     */
    public Expression type(Expression one) {
        return new Sin(one);
    }

    /**
     * calculates sin of numbers.
     * @throws Exception if there is variable in exp
     * @return result
     */
    public double evaluate() throws Exception {
        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }
        return Math.sin(Math.toRadians(this.num.evaluate()));
    }

    /**
     *
     * @return string of sin.
     */
    public String getSign() {
        return "sin";

    }
    /**
     * @param var to differentiate by.
     * @return result of differentiation
     */
    public Expression differentiate(String var) {

        return new Mult(new Cos(this.num), this.num.differentiate(var));
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
            return new Sin(this.num.simplify());
        }
    }
}
