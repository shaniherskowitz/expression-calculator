import java.util.Map;
import java.util.List;
/**.
 * interface for mathematical expressions,
 * uses them to calculate different types of math problems in a
 * recursive generic way.
 */
public interface Expression extends CheckSame  {


    /**.
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment map to calculate by
     * @throws Exception if for some reason cannot calculate
     * @return result
     */
    double evaluate(Map<String, Double> assignment) throws Exception;


    /**.
     * @throws Exception if for some reason cannot calculate
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return result
     */
    double evaluate() throws Exception;

    /**.
     * @return a list of the variables in the expression.
     */
    List<String> getVariables();


    /**
     * @return a nice string representation of the expression.
     */
    String toString();

    /**.
     * @return  a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     * @param var variable to assign.
     * @param expression to place in var.
     */
    Expression assign(String var, Expression expression);

    /**.
     * @return  the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     * @param var differentiating by var
     */
    Expression differentiate(String var);

    /**
     * @return  a simplified version of the current expression.
     */
    Expression simplify();
}
