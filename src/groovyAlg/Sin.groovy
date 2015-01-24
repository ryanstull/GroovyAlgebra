package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the sin function
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@InheritConstructors
class Sin extends Trig {

    String symbol = "sin"

    //References the java.Math implementation of sin
    Closure<Number> operation = Math.&sin

    /**
     * @return cos ( f1 ) *f1'
     */
    ArithmeticExpression derivative() {
        new Multiply([new Cos(terms[0]), terms[0].derivative()]).simplify()
    }

}