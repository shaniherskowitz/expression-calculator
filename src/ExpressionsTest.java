
import java.util.Map;
import java.util.TreeMap;
/**
 * runs basic test.
 */
public class ExpressionsTest {
    /**
     * runs program based on assignment requirements.
     * @param args not used
     * @throws Exception not used
     */
    public static void main(String[] args) throws Exception {

        try {


        Expression s = new Plus(new Mult(2, "x"),
                new Plus(new Sin(new Mult(4, "y")), new Pow("e", "x")));

        System.out.println(s);

        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        double value = s.evaluate(assignment);
        System.out.println(value);
        System.out.println(s.differentiate("x"));
        System.out.println(s.differentiate("x").evaluate(assignment));
        System.out.println(s.differentiate("x").simplify());
        } catch (Exception e) {
            System.out.println("there was a problem");
        }

    }
}
