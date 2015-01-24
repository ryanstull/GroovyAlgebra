package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the secant function
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@InheritConstructors
class Sec extends Trig {

    String symbol = "sec"

    //References the java.math implementation of cos
    Closure<Number> operation = { Double a -> 1 / Math.cos(a) }

    /**
     * @return sec ( f1 ) *tan(f1)*f1'
     */
    ArithmeticExpression derivative() {
        new Multiply(new Sec(terms[0]), new Tan(terms[0]), terms[0].derivative()).simplify()
    }
}
