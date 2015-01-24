package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the cosine function
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@InheritConstructors
class Cos extends Trig {

    String symbol = "cos"
    Closure<Number> operation = Math.&cos

    ArithmeticExpression derivative() {
        new Multiply([new Num(-1), new Sin(terms[0]), terms[0].derivative()]).simplify()
    }

}
