package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the cosecant function
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@InheritConstructors
class Csc extends Trig {

    String symbol = "csc"
    Closure<Number> operation = { Double a -> 1 / Math.sin(a) }

    ArithmeticExpression derivative() {
        new Multiply([new Num(-1), new Cot(terms[0]), new Csc(terms[0]), terms[0].derivative()]).simplify()
    }
}
