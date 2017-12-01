/**
 * calculate cos of expression.
 */
public class Cos extends UnaryExpression implements Expression {
    /**
     * calculate cos of expression.
     */
    private Expression num;


    /**
     * constructor.
     * @param number to calculate
     */
    public Cos(Expression number) {
        super(number);
        this.num = number;
    }
    /**
     * constructor.
     * @param x variable calculate
     */
    public Cos(String x) {
        super(new Var(x));
        this.num = new Var(x);

    }
    /**
     * constructor.
     * @param num1 number to calculate
     */
    public Cos(double num1) {
        super(new Num(num1));
        this.num = new Num(num1);

    }
    /**
     * @param one returns new cos of current exp.
     * @return new cos of current exp.
     */
    public Expression type(Expression one) {
        return new Cos(one);

    }
    /**
     * calculates cos of numbers.
     * @throws Exception if there is variable in exp
     * @return result
     */
    public double evaluate() throws Exception {
        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }
        return Math.cos(Math.toRadians(this.num.evaluate()));
    }
    /**
     * @return string of cos.
     */
    public String getSign() {
        return "cos";

    }
    /**
     * @param var to differentiate by.
     * @return result of differentiation
     */
    public Expression differentiate(String var) {

        return new Neg(new Mult(new Sin(this.num), this.num.differentiate(var)));
    }
    /**
     * @return simplified expression.
     * more clear gets rid of unnecessary characters
     *
     */
    public Expression simplify() {
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
            return new Cos(this.num.simplify());
        }
    }

}
