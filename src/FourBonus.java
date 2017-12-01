/**
 * bonus.
 */
public class FourBonus extends FourExp implements Expression {
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
     * forth exp.
     */
    private Expression num4;

    /**
     * constroctor.
     * @param one first expression
     * @param two second expression
     * @param three third expression
     * @param four forth expression
     */
    public FourBonus(Expression one, Expression two, Expression three, Expression four) {
        super(one, two, three, four);
        this.num1 = one;
        this.num2 =  two;
        this.num3 = three;
        this.num4 = four;

    }

    /**
     * @param one first expression.
     * @param two second expression
     * @param three third expression
     * @param four forth expression
     * gets new exp using specific type
     * @return new exp of same type with exps
     *
     */
    public Expression type(Expression one, Expression two, Expression three, Expression four) {
        return new FourBonus(one, two, three, four);
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
        return (this.num1.evaluate() + this.num2.evaluate() + this.num3.evaluate() + this.num4.evaluate());
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

        return new FourBonus(this.num1.differentiate(var), this.num2.differentiate(var),
                this.num3.differentiate(var), this.num4.differentiate(var));

    }
    /**.
     * @return simplified expression,
     * more clear gets rid of unnecessary characters
     *
     */
    public Expression simplify() {
        int[] count = new int[7];
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
            if (checkSame(this.num1, this.num4)) {
                count[2] = 1;
            }
            if (checkSame(this.num2, this.num3)) {
                count[3] = 1;
            }
            if (checkSame(this.num2, this.num4)) {
                count[4] = 1;
            }
            if (checkSame(this.num4, this.num3)) {
                count[5] = 1;
            }
            for (int i = 0; i < 7; i++) {
                if (count[i] == 1) {
                    check++;
                }
            }
            if (check == 1) {
                    return checkOne(count);
            } else if (check >= 2) {
                return checkTwo(count);
            }

            return new Plus(new Plus(this.num1.simplify(), this.num2.simplify()).simplify(),
                    new Plus(this.num3.simplify(), this.num4.simplify()).simplify()).simplify();
        }

    }
    /**
     *  by the numbers in count array checks how to simplify the expression.
     * @param count array of numbers
     * @return the simple expression
     */
    public Expression checkOne(int[] count) {
        if (count[0] == 1) {
            return new Plus(new Plus(this.num1, this.num2), new Plus(this.num4, this.num3)).simplify();

        } else if (count[1] == 1) {
            return new Plus(new Plus(this.num1, this.num3), new Plus(this.num4, this.num2)).simplify();

        } else if (count[2] == 1) {
            return new Plus(new Plus(this.num1, this.num4), new Plus(this.num3, this.num2)).simplify();

        } else if (count[3] == 1) {
            return new Plus(new Plus(this.num2, this.num3), new Plus(this.num4, this.num1)).simplify();

        } else if (count[4] == 1) {
            return new Plus(new Plus(this.num2, this.num4), new Plus(this.num1, this.num3)).simplify();

        } else if (count[5] == 1) {
            return new Plus(new Plus(this.num4, this.num3), new Plus(this.num1, this.num2)).simplify();
        }
       return new Plus(new Plus(this.num1.simplify(), this.num2.simplify()).simplify(),
               new Plus(this.num3.simplify(), this.num4.simplify()).simplify()).simplify();
    }
    /**
     *  by the numbers in count array checks how to simplify the expression.
     * @param count array of numbers
     * @return the simple expression
     */
    public Expression checkTwo(int[] count) {
        if (count[0] == 1 && count[1] == 1 && count[2] == 1) {
            return new Plus(new Plus(this.num1, this.num2).simplify(),
                    new Plus(this.num4, this.num3).simplify()).simplify();

        } else if (count[0] == 1 && count[1] == 1 || count[0] == 1 && count[3] == 1 || count[1] == 1 && count[3] == 1) {
            return new Plus(new Plus(new Plus(this.num1, this.num2).simplify(),
                    this.num3).simplify(), this.num4).simplify();

        } else if (count[0] == 1 && count[2] == 1 || count[2] == 1 && count[3] == 1 || count[2] == 1 && count[4] == 1) {
            return new Plus(new Plus(new Plus(this.num1, this.num2).simplify(),
                    this.num4).simplify(), this.num3).simplify();

        } else if (count[1] == 1 && count[2] == 1 || count[2] == 1 && count[5] == 1) {
            return new Plus(new Plus(new Plus(this.num1, this.num3).simplify(),
                    this.num4).simplify(), this.num2).simplify();

        } else if (count[1] == 1 && count[4] == 1) {
            return new Plus(new Plus(this.num1, this.num3).simplify(),
                    new Plus(this.num2.simplify(), this.num4.simplify())).simplify();

        } else if (count[1] == 1 && count[5] == 1) {
            return new Plus(new Plus(this.num1, this.num2).simplify(),
                    new Plus(this.num3.simplify(), this.num4.simplify())).simplify();

        } else if (count[3] == 1 && count[4] == 1 || count[3] == 1 && count[5] == 1 || count[4] == 1 && count[5] == 1) {
            return new Plus(new Plus(new Plus(this.num3, this.num2).simplify(),
                    this.num4).simplify(), this.num1).simplify();

        }

        return new Plus(new Plus(this.num1.simplify(), this.num2.simplify()).simplify(),
                new Plus(this.num3.simplify(), this.num4.simplify()).simplify()).simplify();
    }

}
