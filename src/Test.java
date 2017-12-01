

/**
 * just a test.
 */
public class Test {
    /**
     * @param args not used.
     * @throws Exception not used
     */



        public static void main(String[] args) throws Exception {

        Expression y = new Plus(new Mult(2, "x"), new Plus(2, new Plus(new Mult(4, "x"), 1)));

        System.out.println("The expression:");
        System.out.println(y);
        System.out.println("The simplified expression:");
        System.out.println(y.simplify());
        System.out.println();

            Expression b = new FourBonus(new Mult("x", 2), new Num(5),
                    new Mult(6, "x"), new Mult(6, "x"));

            System.out.println("The expression:");
            System.out.println(b);
            System.out.println("The simplified expression:");
            System.out.println(b.simplify());
            System.out.println();


            Expression q = new ThreeBonus(new Mult(2, "x"), new Num(2) , new Mult(4, "x"));

            System.out.println("The expression:");
            System.out.println(q);
            System.out.println("The simplified expression:");
            System.out.println(q.simplify());
            System.out.println();
        }
    }



