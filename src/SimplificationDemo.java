
/**
 * bonus class.
 */
public class SimplificationDemo {
    /**
     * @param args not used.
     * @throws Exception not used
     */
    public static void main(String[] args) throws Exception {
        try {



        Expression s = new Pow(new Pow("x", "y"), new Var("z"));

        System.out.println("The expression:");
        System.out.println(s);
        System.out.println("The simplified expression:");
        System.out.println(s.simplify());
        System.out.println();

        Expression o = new Plus(new Mult("x", 5), new Mult(2, "x"));

        System.out.println("The expression:");
        System.out.println(o);
        System.out.println("The simplified expression:");
        System.out.println(o.simplify());
        System.out.println();

        Expression h = new Minus(new Mult("x", 5), new Mult(2, "x"));

        System.out.println("The expression:");
        System.out.println(h);
        System.out.println("The simplified expression:");
        System.out.println(h.simplify());
        System.out.println();



        Expression u = new FourBonus(new Mult("x", 4), new Num(5), new Mult(6, "x"),
                new Var("y"));

        System.out.println("The expression:");
        System.out.println(u);
        System.out.println("The simplified expression:");
        System.out.println(u.simplify());
        System.out.println();

        Expression l = new FourBonus(new Mult("x", 2), new Mult("x", 4),
                new Mult(6, "x"), new Mult("x", 1));

        System.out.println("The expression:");
        System.out.println(l);
        System.out.println("The simplified expression:");
        System.out.println(l.simplify());
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

        Expression t = new ThreeBonus(new Mult("x", 7), new Num(5),
                new Mult("x", 7));

        System.out.println("The expression:");
        System.out.println(t);
        System.out.println("The simplified expression:");
        System.out.println(t.simplify());
        System.out.println();

        Expression w = new Plus(new Mult(new Pow("x", 7), new Pow("x", 6)), new Num(5));

        System.out.println("The expression:");
        System.out.println(w);
        System.out.println("The simplified expression:");
        System.out.println(w.simplify());
        System.out.println();

        Expression x = new Mult(new Pow("x", 9), new Pow("x", 7));

        System.out.println("The expression:");
        System.out.println(x);
        System.out.println("The simplified expression:");
        System.out.println(x.simplify());
        System.out.println();

        } catch (Exception e) {
            System.out.println("there was a problem");
        }



    }

}
