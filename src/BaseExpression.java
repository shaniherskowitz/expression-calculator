import java.util.ArrayList;
import java.util.List;

/**
 * class that holds functions to all mathematical expressions.
 */
public abstract class BaseExpression {

    /**
     * @return Returns a list of the variables in the expression.
     */
    public List<String> getVariables() {
        List<String> vars = new ArrayList<>();
        for (int i = 0; i < this.toString().length(); i++) {
            if ((this.toString().charAt(i) >= 'a' && this.toString().charAt(i) <= 'z'
                    || this.toString().charAt(i) >= 'A' && this.toString().charAt(i) <= 'Z')
                    && !vars.contains("" + this.toString().charAt(i))) {
                if (this.toString().contains("cos") && this.toString().charAt(i) == 'c') {
                    i += 2;
                    continue;
                }
                if (this.toString().contains("sin") && this.toString().charAt(i) == 's') {
                    i += 2;
                    continue;
                }
                if (this.toString().contains("log") && this.toString().charAt(i) == 'l') {
                    i += 2;
                    continue;
                }
                vars.add("" + this.toString().charAt(i));
            }
        }
        return vars;
    }




}
