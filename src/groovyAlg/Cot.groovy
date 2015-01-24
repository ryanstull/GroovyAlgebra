package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the tangent function
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@InheritConstructors
class Cot extends Trig {

    String symbol = "cot"
    Closure<Number> operation = { Double a -> 1 / Math.tan(a) }

    ArithmeticExpression derivative() {
        new Multiply([new Num(-1), new Exponent(new Csc(terms[0]), new Num(2)), terms[0].derivative()]).simplify()
    }
}
