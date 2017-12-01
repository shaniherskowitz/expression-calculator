import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * number class, holds number.
 */
public class Num implements Expression {
    /**
     * number.
     */
    private double number;

    /**
     * @param first number from user.
     */
    public Num(double first) {
        this.number = first;
    }

    /**.
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment map to calculate by
     * @throws Exception if for some reason cannot calculate
     * @return number
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        /*double number1 = 0;
        int count = 0;
        for (Map.Entry<String, Double> pair : assignment.entrySet()) {
            number1 = pair.getValue();
            try {
                for (int i = 0; i < this.getVariables().size(); i++) {
                    if (!pair.getKey().equals(this.getVariables().get(i))) {
                        count++;
                    }
                }
            } catch (Exception e) {
                if (count == this.getVariables().size()) {
                    throw new Exception("val not in assignment");
                }
            }
        }*/
        return this.evaluate();

     }
    /**
     * @throws Exception if for some reason cannot calculate(wont happen).
     * evaluates the number
     * @return number
     */
    public double evaluate() throws Exception {

        return this.number;
    }


    /**
     * @return  empty list cuz has no variables.
     */
    public List<String> getVariables() {
        return new ArrayList<>();

    }

    /**
     *@return number in string format.
     */
    public String toString() {
        return "" +  this.number;

    }

    /**
     * @param var not used.
     * @param expression not used
     * @return  null since has no variable to assign
     */
    public Expression assign(String var, Expression expression) {
        return null;

    }
    /**
     * @param var not used.
     * @return 0 since thats th differentiation of a number
     */
    public Expression differentiate(String var) {
        return new Num(0);
    }

    /**
     * @return not way to simplify, returns number.
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
