/**
 * log first elm is base second is number to calculate.
 */
public class Log extends BinaryExpression implements Expression {
    /**
     * base for log.
     */
    private Expression num1;
    /**
     * number to log.
     */
    private Expression num2;

    /**
     * constroctor.
     * @param one first experssion in log
     * @param two second experssion in log
     *
     */
    public Log(Expression one, Expression two) {
        super(one, two);
        this.num1 = one;
        this.num2 = two;
    }
    /**
     * constroctor.
     * @param x first value in log
     * @param num second number in log
     *
     */
    public Log(String x, double num) {
        super(new Var(x), new Num(num));
        this.num1 = new Var(x);
        this.num2 = new Num(num);
    }
    /**
     * constroctor.
     * @param x first value in log
     * @param y second value in log
     *
     */
    public Log(String x, String y) {
        super(new Var(x), new Var(y));
        this.num1 = new Var(x);
        this.num2 =  new Var(y);
    }
    /**
     * constroctor.
     * @param num first number in log
     * @param num3 second number in log
     *
     */
    public Log(double num, double num3) {
        super(new Num(num), new Num(num3));
        this.num1 = new Num(num);
        this.num2 = new Num(num3);
    }
    /**
     * constroctor.
     * @param num first number in log
     * @param x second value in log
     *
     */
    public Log(double num, String x) {
        super(new Num(num), new Var(x));
        this.num2 = new Var(x);
        this.num1 = new Num(num);
    }
    /**
     * constroctor.
     * @param y first value in log
     * @param x second Expression in log
     *
     */
    public Log(String y, Expression x) {
        this(new Var(y), x);

    }
    /**
     * constroctor.
     * @param x first Expression in log
     * @param num second value in log
     *
     */
    public Log(Expression x, double num) {
        this(x, new Num(num));

    }
    /**
     * constroctor.
     * @param x first Expression in log
     * @param y second value in log
     *
     */
    public Log(Expression x, String y) {
        this(x, new Var(y));

    }
    /**
     * constroctor.
     * @param num first number in log
     * @param x second value in log
     *
     */
    public Log(double num, Expression x) {
        this(new Num(num), x);

    }

    /**
     *.
     * @throws Exception if evaluate has a variable or if logs base is below 0 or log num is below 1
     * calculates the log and returns answer
     * @return result of calculation
     *
     */
    public double evaluate() throws Exception {


        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }

        return (Math.log(this.num2.evaluate()) / Math.log(this.num1.evaluate()));

    }

    /**.
     * @return sign of the calculation
     */
    public String getSign() {
        return "log";
    }


    /**
     * @param one first experssion in log.
     * @param two second experssion in log
     * @return a new log with its elements
     *
     */
    public Log type(Expression one, Expression two) {
        return new Log(one, two);

    }
    /**
     * @param var to diffreentiate by.
     * @return differentiated exspression
     *
     */
    public Expression differentiate(String var) {

        return new Div(this.num2.differentiate(var), new Mult(this.num2, new Log(new Var("e"), this.num1)));

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
                return new Num(1);
            }
            return new Log(this.num1.simplify(), this.num2.simplify());
        }
    }

    /**.
     * @return simplified expression,
     * more clear gets rid of unnecessary characters
     * adds different string for log elements
     *
     */
    @Override
    public String toString() {
        if (this.num1.toString().equals("2.71828")) {
            this.num1 = new Var("e");
        }
        if (this.num2.toString().equals("2.71828")) {
            this.num2 = new Var("e");
        }
        return this.getSign() + "(" + this.num1.toString() + ", " + this.num2.toString() + ")";

    }



}
