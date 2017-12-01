import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * variable class, holds variable.
 */
public class Var implements Expression  {
    /**
     * string representation for variable.
     */
    private String string;

    /**
     * @param str string from user, is variable.
     */
    public Var(String str) {
        this.string = str;
    }


    /**.
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment map to calculate by
     * @throws Exception if for some reason cannot calculate
     * not used in this class
     * @return result
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        String str;
        double num = 0;

        for (Map.Entry<String, Double> pair : assignment.entrySet()) {

            str = pair.getKey();
            num = pair.getValue();
            this.assign(str, new Num(num));

            }
        return num;
    }


    /**
     * @throws Exception if gets here and is still a variable.
     * evaluates the number
     * @return calculations
     */
    public double evaluate() throws Exception {
        if (Double.parseDouble(this.string) >= 0 && Double.parseDouble(this.string) <= 9) {
            return Double.parseDouble(this.string);
        }
       throw new Exception("this is a variable!");
    }

    /**
     * @return list containing this variable only.
     */
    public List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        variables.add(this.string);
        return variables;
    }

    /**
     * @return itself.
     */
    public String toString() {
        return this.string;

    }

    /**
     * @param var to place expression in.
     * @param expression to put in var
     * @return if this variable is var then places expression in it
     */
    public Expression assign(String var, Expression expression) {

        Var one = this;

        if (one.string.equals(var)) {
            return expression;
        }


        return one;

    }
    /**
     * @param var to differentiate by.
     * @return if the var is this variable returns 1 else returns 0
     *
     */
    public Expression differentiate(String var) {
        if (this.string.equals(var)) {
            return new Num(1);
        }

        return new Num(0);
    }
    /**
     * @return nothing to simplify returns itself.
     */
    public Expression simplify() {
        return this;
    }

    /**
     * @return no sign returns empty string.
     */
    public String getSign() {
        return "";
    }


}
