
/**
 * number to dived with another number.
 */
public class Div extends BinaryExpression implements Expression {
    /**
     * first number to divide.
     */
    private Expression num1;
    /**
     * second the amount to divide.
     */
    private Expression num2;

    /**
     * constroctor.
     * @param one first experssion in div
     * @param two second experssion in div
     *
     */
    public Div(Expression one, Expression two) {
        super(one, two);
        this.num1 = one;
        this.num2 = two;
    }
    /**
     * constroctor.
     * @param x first value in div
     * @param num second number in div
     *
     */
    public Div(String x, double num) {
        super(new Var(x), new Num(num));
        this.num1 = new Var(x);
        this.num2 = new Num(num);
    }
    /**
     * constroctor.
     * @param x first value in div
     * @param y second value in div
     *
     */
    public Div(String x, String y) {
        super(new Var(x), new Var(y));
        this.num1 = new Var(x);
        this.num2 = new Var(y);
    }
    /**
     * constroctor.
     * @param num first number in div
     * @param num3 second number in div
     *
     */
    public Div(double num, double num3) {
        super(new Num(num), new Num(num3));
        this.num1 = new Num(num);
        this.num2 = new Num(num3);
    }
    /**
     * constroctor.
     * @param num first number in div
     * @param x second value in div
     *
     */
    public Div(double num, String x) {
        super(new Num(num), new Var(x));
        this.num2 = new Var(x);
        this.num1 = new Num(num);
    }
    /**
     * constroctor.
     * @param y first value in div
     * @param x second Expression in div
     *
     */
    public Div(String y, Expression x) {
        this(new Var(y), x);

    }
    /**
     * constroctor.
     * @param x first Expression in div
     * @param num second value in div
     *
     */
    public Div(Expression x, double num) {
        this(x, new Num(num));

    }
    /**
     * constroctor.
     * @param x first Expression in div
     * @param y second value in div
     *
     */
    public Div(Expression x, String y) {
        this(x, new Var(y));

    }
    /**
     * constroctor.
     * @param num first number in div
     * @param x second value in div
     *
     */
    public Div(double num, Expression x) {
        this(new Num(num), x);

    }

    /**
     *.
     * @throws Exception if evaluate has a variable or if second number is 0
     * calculates the div and returns answer
     * @return result of calculation
     *
     */
    public double evaluate() throws Exception {

        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }
        if (this.num2.evaluate() == 0) {
            throw new Exception("cannot divide by zero");
        }

        return (this.num1.evaluate() / this.num2.evaluate());

    }

    /**.
     * @return sign of the calculation
     */
    public String getSign() {
        return " / ";
    }

    /**.
     * @param one first experssion in div
     * @param two second experssion in div
     * @return a new div with its elements
     */
    public Div type(Expression one, Expression two) {
        return new Div(one, two);

    }

    /**.
     * @param var to diffreentiate by
     * @return differentiated exspression
     *
     */
    public Expression differentiate(String var) {


        return new Div(new Minus(new Mult(this.num1.differentiate(var), this.num2),
                new Mult(this.num2.differentiate(var), this.num1)), new Pow(this.num2, new Num(2)));

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
            if (this.num2.toString().equals("1.0")) {
                return this.num1.simplify();
            }

            if (this.num1.toString().equals(this.num2.toString()) || checkSame()) {
                return new Num(1);
            }
            if (this.num1.simplify().toString().equals(this.num2.simplify().toString())) {
                return new Num(1);
            }

            return new Div(this.num1.simplify(), this.num2.simplify());
        }
    }


}
