package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the sin function
 *
 * @author Ryan Stull
 */
@InheritConstructors
class Tan extends Trig {

    String symbol = "tan"

    //References the java.Math implementation for tan
    Closure<Number> operation = Math.&tan

    /**
     * @return sec^2(f1)*f1'
     */
    ArithmeticExpression derivative() {
        new Multiply(new Exponent(new Sec(terms[0]), new Num(2)), terms[0].derivative()).simplify()
    }

}