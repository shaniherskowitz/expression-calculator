/**
 * bonus.
 */
public class ThreeBonus extends ThreeExp implements Expression {
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
     * constroctor.
     * @param one first expression
     * @param two second expression
     * @param three third expression
     *
     */
    public ThreeBonus(Expression one, Expression two, Expression three) {
        super(one, two, three);
        this.num1 = one;
        this.num2 =  two;
        this.num3 = three;

    }

    /**
     * @param one first expression.
     * @param two second expression
     * @param three third expression
     * gets new exp using specific type
     * @return new exp of same type with exps
     *
     */
    public Expression type(Expression one, Expression two, Expression three) {
        return new ThreeBonus(one, two, three);
    }
    /**
     * @throws Exception if cannot evaluate this type.
     * calculates a binary expression
     * @return result
     */
    public double evaluate() throws Exception {
        if (this.getVariables().size() > 0) {
            throw new Exception("not empty assignment");
        }
        return (this.num1.evaluate() + this.num2.evaluate() + this.num3.evaluate());
    }
    /**
     *  gets the sign of specific expression.
     *   @return string with sign
     */
    public String getSign() {
        return " + ";
    }
    /**
     * @param var to diffreentiate by.
     * @return differentiated exspression
     *
     */
    public Expression differentiate(String var) {

        return new ThreeBonus(this.num1.differentiate(var), this.num2.differentiate(var), this.num3.differentiate(var));

    }
    /**.
     * @return simplified expression,
     * more clear gets rid of unnecessary characters
     *
     */
    public Expression simplify() {
        int[] count = new int[4];
        int check = 0;
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
            if (checkSame(this.num1, this.num2)) {
                count[0] = 1;
            }
            if (checkSame(this.num1, this.num3)) {
                count[1] = 1;
            }
            if (checkSame(this.num2, this.num3)) {
                count[3] = 1;
            }
            for (int i = 0; i < 4; i++) {
                if (count[i] == 1) {
                    check++;
                }
            }
            if (check == 1) {
                return checkOne(count);
            } else if (check == 2) {
                return new Plus(new Plus(this.num1, this.num2).simplify(), this.num3).simplify();
            }

            return new Plus(new Plus(this.num1.simplify(), this.num2.simplify()).simplify(),
                    this.num3.simplify()).simplify();
        }
    }

    /**
     *  by the numbers in count array checks how to simplify the expression.
     * @param count array of numbers
     * @return the simple expression
     */
    public Expression checkOne(int[] count) {
        if (count[0] == 1) {
            return new Plus(new Plus(this.num1, this.num2).simplify(), this.num3).simplify();

        } else if (count[1] == 1) {
            return new Plus(new Plus(this.num1, this.num3).simplify(), this.num2).simplify();

        } else if (count[2] == 1) {
            return new Plus(new Plus(this.num3, this.num2).simplify(), this.num1).simplify();
        }
        return new Plus(new Plus(this.num1.simplify(), this.num2.simplify()).simplify(),
                this.num3.simplify()).simplify();

    }



}
