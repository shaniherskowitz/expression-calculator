/**
 * number to the power of another number.
 */
public class Pow extends BinaryExpression implements Expression {
    /**
     * the number to multiply.
     */
    private Expression num1;
    /**
     * how many times to multiply with itself.
     */
    private Expression num2;

    /**
     * constroctor.
     * @param one first experssion in pow
     * @param two second experssion in pow
     *
     */
    public Pow(Expression one, Expression two) {
        super(one, two);
        this.num1 = one;
        this.num2 = two;
    }
    /**
     * constroctor.
     * @param x first value in pow
     * @param num second number in pow
     *
     */
    public Pow(String x, double num) {
        super(new Var(x), new Num(num));
        this.num1 = new Var(x);
        this.num2 = new Num(num);
    }
    /**
     * constroctor.
     * @param x first value in pow
     * @param y second value in pow
     *
     */
    public Pow(String x, String y) {
        super(new Var(x), new Var(y));
        this.num1 = new Var(x);
        this.num2 =  new Var(y);
    }
    /**
     * constroctor.
     * @param num first number in pow
     * @param num2 second number in pow
     *
     */
    public Pow(double num, double num2) {
        super(new Num(num), new Num(num2));
        this.num1 = new Num(num);
        this.num2 = new Num(num2);
    }
    /**
     * constroctor.
     * @param num first number in pow
     * @param x second value in pow
     *
     */
    public Pow(double num, String x) {
        super(new Num(num), new Var(x));
        this.num2 = new Var(x);
        this.num1 = new Num(num);
    }
    /**
     * constroctor.
     * @param y first value in pow
     * @param x second Expression in pow
     *
     */
    public Pow(String y, Expression x) {
        this(new Var(y), x);

    }
    /**
     * constroctor.
     * @param x first Expression in pow
     * @param num second value in pow
     *
     */
    public Pow(Expression x, double num) {
        this(x, new Num(num));

    }
    /**
     * constroctor.
     * @param x first Expression in pow
     * @param y second value in pow
     *
     */
    public Pow(Expression x, String y) {
        this(x, new Var(y));

    }
    /**
     * constroctor.
     * @param num first number in pow
     * @param x second value in pow
     *
     */
    public Pow(double num, Expression x) {
        this(new Num(num), x);

    }


    /**
     *
     * @throws Exception if evaluate has a variable.
     * calculates the pow and returns answer
     * @return result of calculation
     *
     */
    public double evaluate() throws Exception {

        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }
        if (this.num2.evaluate() < 1 && this.num1.evaluate() < 0) {
            System.out.println("cannot do sqrt of negative number, number changed to positive");
            return (Math.pow(new Neg(this.num1).evaluate(), this.num2.evaluate()));
        }

        return (Math.pow(this.num1.evaluate(), this.num2.evaluate()));

    }

    /**
     *
     * @return sign of the calculation.
     *
     */
    public String getSign() {
        return "^";
    }

    /**
     * @param one first experssion in pow.
     * @param two second experssion in pow
     * @return  new pow with its elements
     *
     */
    public Pow type(Expression one, Expression two) {
        return new Pow(one, two);

    }

    /**
     * @param var to diffreentiate by.
     * @return differentiated exspression
     *
     */
    public Expression differentiate(String var) {


        return new Mult(this, new Plus(new Mult(this.num1.differentiate(var), new Div(this.num2, this.num1)),
                new Mult(this.num2.differentiate(var), new Log(new Var("e"), this.num1))));
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

            if (this.num1 instanceof Pow) {
                return new Pow(((Pow) this.num1).num1.simplify(),
                        new Mult(((Pow) this.num1).num2, this.num2).simplify());
            }

            return new Pow(this.num1.simplify(), this.num2.simplify());
        }
    }

}
