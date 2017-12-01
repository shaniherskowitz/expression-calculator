/**
 * subtract of exp from the other.
 */
public class Minus extends BinaryExpression implements Expression {
    /**
     * num to subtract from.
     */
    private Expression num1;
    /**
     * subtract this number from first one.
     */
    private Expression num2;


    /**
     * constroctor.
     * @param one first experssion in minus
     * @param two second experssion in minus
     *
     */
    public Minus(Expression one, Expression two) {

        super(one, two);
        this.num1 = one;
        this.num2 = two;
    }
    /**
     * constroctor.
     * @param x first value in minus
     * @param num second number in minus
     *
     */
    public Minus(String x, double num) {
        super(new Var(x), new Num(num));
        this.num1 = new Var(x);
        this.num2 = new Num(num);
    }
    /**
     * constroctor.
     * @param x first value in minus
     * @param y second value in minus
     *
     */
    public Minus(String x, String y) {
        super(new Var(x), new Var(y));
        this.num1 = new Var(x);
        this.num2 =  new Var(y);
    }
    /**
     * constroctor.
     * @param num first number in minus
     * @param num3 second number in minus
     *
     */
    public Minus(double num, double num3) {
        super(new Num(num), new Num(num3));
        this.num1 = new Num(num);
        this.num2 = new Num(num3);
    }
    /**
     * constroctor.
     * @param num first number in minus
     * @param x second value in minus
     *
     */
    public Minus(double num, String x) {
        super(new Num(num), new Var(x));
        this.num2 = new Var(x);
        this.num1 = new Num(num);
    }
    /**
     * constroctor.
     * @param y first value in minus
     * @param x second Expression in minus
     *
     */
    public Minus(String y, Expression x) {
        this(new Var(y), x);

    }
    /**
     * constroctor.
     * @param x first Expression in minus
     * @param num second value in minus
     *
     */
    public Minus(Expression x, double num) {
        this(x, new Num(num));

    }
    /**
     * constroctor.
     * @param x first Expression in minus
     * @param y second value in minus
     *
     */
    public Minus(Expression x, String y) {
        this(x, new Var(y));

    }
    /**
     * constroctor.
     * @param num first number in minus
     * @param x second value in minus
     *
     */
    public Minus(double num, Expression x) {
        this(new Num(num), x);

    }

    /**
     *.
     * @throws Exception if evaluate has a variable
     * calculates the log and returns answer
     * @return result of calculation
     *
     */
    public double evaluate() throws Exception {

        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
            }

        return (this.num1.evaluate() - this.num2.evaluate());

    }

    /**
     * @return sign of the calculation.
     */
    public String  getSign() {
        return " - ";
    }


    /**
     * @param one first experssion in minus.
     * @param two second experssion in minus
     * @return a new minus with its elements
     *
     */
    public Minus type(Expression one, Expression two) {
        return new Minus(one, two);

    }
    /**
     * @param var to diffreentiate by.
     * @return differentiated exspression
     *
     */
    public Expression differentiate(String var) {

        return new Minus(this.num1.differentiate(var), this.num2.differentiate(var));
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


            if (this.num1.toString().equals(this.num2.toString()) || checkSame()) {
                return new Num(0);

            } else if (this.num2.toString().equals("0.0")) {
                return this.num1.simplify();

            } else if (this.num1.toString().equals("0.0")) {
                return new Neg(this.num2.simplify());

            }
            if (this.num1.simplify().toString().equals("0.0")) {
                return new Neg(this.num2.simplify());

            } else if (this.num2.simplify().toString().equals("0.0")) {
                return this.num1.simplify();
            }
            //bonus
            if (this.num1 instanceof Mult && this.num2 instanceof Mult) {
                if (((Mult) this.num1).getNum2().toString().equals(((Mult) this.num2).getNum2().toString())
                        && ((Mult) this.num1).getNum2() instanceof Var) {
                    return new Mult(new Minus(((Mult) this.num1).getNum1(),
                            ((Mult) this.num2).getNum1()).simplify(), ((Mult) this.num1).getNum2().simplify());

                } else if (((Mult) this.num1).getNum1().toString().equals(((Mult) this.num2).getNum1().toString())
                        && ((Mult) this.num1).getNum1() instanceof Var) {
                    return new Mult(new Minus(((Mult) this.num1).getNum2(),
                            ((Mult) this.num2).getNum2()).simplify(), ((Mult) this.num1).getNum1().simplify());

                } else if (((Mult) this.num1).getNum1().toString().equals(((Mult) this.num2).getNum2().toString())
                        && ((Mult) this.num1).getNum1() instanceof Var) {
                    return new Mult(new Minus(((Mult) this.num1).getNum2(),
                            ((Mult) this.num2).getNum1()).simplify(), ((Mult) this.num1).getNum1().simplify());

                } else if (((Mult) this.num1).getNum2().toString().equals(((Mult) this.num2).getNum1().toString())
                        && ((Mult) this.num1).getNum2() instanceof Var) {
                    return new Mult(new Minus(((Mult) this.num1).getNum1(),
                            ((Mult) this.num2).getNum2()).simplify(), ((Mult) this.num1).getNum2().simplify());
                }
            }
            return new Minus(this.num1.simplify(), this.num2.simplify());
        }
    }


}
