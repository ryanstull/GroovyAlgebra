package groovyAlg

/**
 * This class wraps a java.lang.Number in order for it to be a child of Expression
 *
 * @author Ryan Stull
 */
class Num extends NonFormula {
    Number num

    Num(Number num) {
        this.num = num
    }

    Num(String num) {
        this.num = Integer.valueOf(num)
    }

    /**
     * @return The derivative of a variable which is 0
     */
    ArithmeticExpression derivative() {
        new Num(0)
    }

    /**
     * Composes the given expression into this one
     * For a num, this just returns the num itself
     *
     * @param f The expression to compose into this one
     * @return  the number
     */
    ArithmeticExpression compose(ArithmeticExpression f) {
        this.clone()
    }

    /**
     * Returns the number's value
     *
     * @param x The number to evaluate this expression
     * @return  The value of the num instance variable
     */
    Number evaluate(Number x) { num }

    String toString() { num }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Num num1 = (Num) o

        if (num != num1.num) return false

        return true
    }

}
