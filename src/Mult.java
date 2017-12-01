/**
 * multiply both expressions.
 */
public class Mult extends BinaryExpression implements Expression {
    /**
     * num to multiply.
     */
    private Expression num1;
    /**
     * num 2 to multiply.
     */
    private Expression num2;

    /**
     * constroctor.
     * @param one first experssion in mult
     * @param two second experssion in mult
     *
     */
    public Mult(Expression one, Expression two) {
        super(one, two);
        this.num1 = one;
        this.num2 = two;
    }
    /**
     * constroctor.
     * @param x first value in mult
     * @param num second number in mult
     *
     */
    public Mult(String x, double num) {
        super(new Var(x), new Num(num));
        this.num1 = new Var(x);
        this.num2 = new Num(num);
    }
    /**
     * constroctor.
     * @param x first value in mult
     * @param y second value in mult
     *
     */
    public Mult(String x, String y) {
        super(new Var(x), new Var(y));
        this.num1 = new Var(x);
        this.num2 =  new Var(y);
    }
    /**
     * constroctor.
     * @param num first number in mult
     * @param num3 second number in mult
     *
     */
    public Mult(double num, double num3) {
        super(new Num(num), new Num(num3));
        this.num1 = new Num(num);
        this.num2 = new Num(num3);
    }
    /**
     * constroctor.
     * @param num first number in mult
     * @param x second value in mult
     *
     */
    public Mult(double num, String x) {
        super(new Num(num), new Var(x));
        this.num2 = new Var(x);
        this.num1 = new Num(num);
    }
    /**
     * constroctor.
     * @param y first value in mult
     * @param x second Expression in mult
     *
     */
    public Mult(String y, Expression x) {
        this(new Var(y), x);

    }
    /**
     * constroctor.
     * @param x first Expression in mult
     * @param num second value in mult
     *
     */
    public Mult(Expression x, double num) {
        this(x, new Num(num));

    }
    /**
     * constroctor.
     * @param x first Expression in mult
     * @param y second value in mult
     *
     */
    public Mult(Expression x, String y) {
        this(x, new Var(y));

    }
    /**
     * constroctor.
     * @param num first number in mult
     * @param x second value in mult
     *
     */
    public Mult(double num, Expression x) {
        this(new Num(num), x);

    }

    /**.
     * @throws Exception if evaluate has a variable
     * calculates the log and returns answer
     * @return result of calculation
     *
     */
    public double evaluate() throws Exception {

        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }

        return (this.num1.evaluate() * this.num2.evaluate());

    }

    /**
     * @return sign of the calculation.
     */
    public String getSign() {
        return " * ";
    }


    /**
     * @param one first experssion in mult.
     * @param two second experssion in mult
     * @return a new mult with its elements
     *
     */
    public Mult type(Expression one, Expression two) {
        return new Mult(one, two);

    }

    /**
     * @param var to diffreentiate by.
     * @return differentiated exspression
     *
     */
    public Expression differentiate(String var) {
        /*if (this.num1.toString().contains(var)) {
            return new Plus(new Mult(this.num1.differentiate(var), this.num2),
                    new Mult(this.num1, this.num2.differentiate(var)));
        }
        if (this.num2.toString().contains(var)) {
            return new Plus(new Mult(this.num2.differentiate(var), this.num1),
                    new Mult(this.num2, this.num1.differentiate(var)));
        }
        return this;*/

        return new Plus(new Mult(this.num1.differentiate(var), this.num2),
                new Mult(this.num1, this.num2.differentiate(var)));
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

            if (this.num1.toString().equals("1.0")) {
                return this.num2.simplify();

            } else if (this.num2.toString().equals("1.0")) {
                return this.num1.simplify();

            } else if (this.num1.toString().equals("0.0") || this.num2.toString().equals("0.0")) {
                return new Num(0);
            }

            if (this.num1.simplify().toString().equals("0.0") || this.num2.simplify().toString().equals("0.0")) {
                return new Num(0);

            } else if (this.num2.simplify().toString().equals("1.0")) {
                return this.num1.simplify();

            } else if (this.num1.simplify().toString().equals("1.0")) {
                return this.num2.simplify();
            }
            if (this.num1 instanceof Pow && this.num2 instanceof Pow
                    && this.num1.getVariables().containsAll(this.num2.getVariables())
                    && this.num2.getVariables().containsAll(this.num1.getVariables())) {
                if (((Pow) this.num1).getNum1().toString().equals(((Pow) this.num2).getNum1().toString())) {
                    return new Pow(((Pow) this.num1).getNum1(),
                            new Plus(((Pow) this.num1).getNum2(), ((Pow) this.num2).getNum2()).simplify());
                }
            }

            return new Mult(this.num1.simplify(), this.num2.simplify());
        }
    }
    /**
     * @return num 1 of mult.
     *
     */
    public Expression getNum1() {
        return this.num1;
    }
    /**
     * @return num 2 of mult.
     *
     */
    public Expression getNum2() {
        return this.num2;
    }
}
