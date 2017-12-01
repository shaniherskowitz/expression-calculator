/**
 * plus of to different expressions.
 */
public class Plus extends BinaryExpression implements Expression {
    /**
     * first num.
     */
    private Expression num1;
    /**
     * second num.
     */
    private Expression num2;

    /**
     * constroctor.
     *
     * @param one first experssion in plus
     * @param two second experssion in plus
     */
    public Plus(Expression one, Expression two) {

        super(one, two);
        this.num1 = one;
        this.num2 = two;
    }

    /**
     * constroctor.
     *
     * @param x   first value in plus
     * @param num second number in plus
     */
    public Plus(String x, double num) {
        super(new Var(x), new Num(num));
        this.num1 = new Var(x);
        this.num2 = new Num(num);
    }

    /**
     * constroctor.
     *
     * @param x first value in plus
     * @param y second value in plus
     */
    public Plus(String x, String y) {
        super(new Var(x), new Var(y));
        this.num1 = new Var(x);
        this.num2 = new Var(y);

    }

    /**
     * constroctor.
     *
     * @param num  first number in plus
     * @param num3 second number in plus
     */
    public Plus(double num, double num3) {
        super(new Num(num), new Num(num3));
        this.num1 = new Num(num);
        this.num2 = new Num(num3);
    }

    /**
     * constroctor.
     *
     * @param num first number in plus
     * @param x   second value in plus
     */
    public Plus(double num, String x) {
        super(new Num(num), new Var(x));
        this.num2 = new Var(x);
        this.num1 = new Num(num);
    }

    /**
     * constroctor.
     *
     * @param y first value in plus
     * @param x second Expression in plus
     */
    public Plus(String y, Expression x) {
        this(new Var(y), x);

    }

    /**
     * constroctor.
     *
     * @param x   first Expression in plus
     * @param num second value in plus
     */
    public Plus(Expression x, double num) {
        this(x, new Num(num));

    }

    /**
     * constroctor.
     *
     * @param x first Expression in plus
     * @param y second value in plus
     */
    public Plus(Expression x, String y) {
        this(x, new Var(y));

    }

    /**
     * constroctor.
     *
     * @param num first number in plus
     * @param x   second value in plus
     */
    public Plus(double num, Expression x) {
        this(new Num(num), x);

    }


    /**
     * @return result of calculation
     * @throws Exception if evaluate has a variable.
     *                   calculates the log and returns answer
     */
    public double evaluate() throws Exception {

        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }
        return (this.num1.evaluate() + this.num2.evaluate());

    }

    /**
     * @return sign of the calculation.
     */
    public String getSign() {
        return " + ";
    }

    /**
     * @param one first experssion in plus.
     * @param two second experssion in plus.
     * @return new plus with its elements
     */
    public Plus type(Expression one, Expression two) {
        return new Plus(one, two);
    }

    /**
     * @param var to diffreentiate by.
     * @return differentiated exspression
     */
    public Expression differentiate(String var) {

        return new Plus(this.num1.differentiate(var), this.num2.differentiate(var));

    }

    /**
     * .
     *
     * @return simplified expression,
     * more clear gets rid of unnecessary characters
     */
    public Expression simplify() {
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {

            if (this.num1.toString().equals("0.0")) {
                return this.num2.simplify();

            } else if (this.num2.toString().equals("0.0")) {
                return this.num1.simplify();

            }

            if (this.num1.simplify().toString().equals("0.0")) {
                return this.num2.simplify();

            } else if (this.num2.simplify().toString().equals("0.0")) {
                return this.num1.simplify();
            }
            //bonus
            return bonusSimplify();


        }
    }

    /**
     * simplify for bonus.
     * @return simple expression
     */
    public Expression bonusSimplify() {

        /*if (this.num2 instanceof Plus && ((Plus) this.num2).num2 instanceof Plus) {
            return new FourBonus(this.num1, ((Plus) this.num2).num1,
                    ((Plus) ((Plus) this.num2).num2).num1, ((Plus) ((Plus) this.num2).num2).num2).simplify();
        }

        if (this.num1 instanceof Plus) {
            return new  ThreeBonus(this.num2, ((Plus) this.num1).num1, ((Plus) this.num1).num2);
        }
        if (this.num2 instanceof Plus) {
            return new  ThreeBonus(this.num1, ((Plus) this.num2).num2, ((Plus) this.num2).num1);
        }*/

        if (this.num1 instanceof Mult && this.num2 instanceof Mult) {
            if (((Mult) this.num1).getNum2().toString().equals(((Mult) this.num2).getNum2().toString())
                    && ((Mult) this.num1).getNum2() instanceof Var) {
                return new Mult(new Plus(((Mult) this.num1).getNum1(),
                        ((Mult) this.num2).getNum1()).simplify(), ((Mult) this.num1).getNum2().simplify());

            } else if (((Mult) this.num1).getNum1().toString().equals(((Mult) this.num2).getNum1().toString())
                    && ((Mult) this.num1).getNum1() instanceof Var) {
                return new Mult(new Plus(((Mult) this.num1).getNum2(),
                        ((Mult) this.num2).getNum2()).simplify(), ((Mult) this.num1).getNum1().simplify());

            } else if (((Mult) this.num1).getNum1().toString().equals(((Mult) this.num2).getNum2().toString())
                    && ((Mult) this.num1).getNum1() instanceof Var) {
                return new Mult(new Plus(((Mult) this.num1).getNum2(),
                        ((Mult) this.num2).getNum1()).simplify(), ((Mult) this.num1).getNum1().simplify());

            } else if (((Mult) this.num1).getNum2().toString().equals(((Mult) this.num2).getNum1().toString())
                    && ((Mult) this.num1).getNum2() instanceof Var) {
                return new Mult(new Plus(((Mult) this.num1).getNum1(),
                        ((Mult) this.num2).getNum2()).simplify(), ((Mult) this.num1).getNum2().simplify());
            }

        }

        return new Plus(this.num1.simplify(), this.num2.simplify());

    }


}
