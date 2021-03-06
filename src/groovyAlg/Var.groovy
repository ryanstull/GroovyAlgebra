package groovyAlg

/**
 * This class represents a variable, such as x, which when evaluated merely returns the value given to it
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 *
 * TODO add support for different simultaneous variables, such as x,y,z etc..
 */
class Var extends NonFormula {

    /**
     * Evaluates a variable which simply returns the value passed as an argument
     *
     * @param x The value to evaluate the variablne at
     * @return The value passed as a parameter
     */
    Number evaluate(Number x) { x }

    /**
     * Returns the derivative of x which is 1
     *
     * @return The number 1
     */
    ArithmeticExpression derivative() {
        new Num(1)
    }

    String toString() {
        "x"
    }

    ArithmeticExpression compose(ArithmeticExpression f) {
        f
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Var)) return false

        return true
    }

    int hashCode() {
        return 0
    }
}