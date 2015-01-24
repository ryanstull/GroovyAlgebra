package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the logarithm
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2015-1-16
 * @vesion  1.0
 */
@InheritConstructors
class Log extends BinaryOp {

    String symbol = "log"
    Closure<Number> operation = Math.&log10

    ArithmeticExpression derivative() {
        null//TODO
    }

    String toString() {
        "${getSymbol()}(${terms[0].toString()})"
    }

    ArithmeticExpression simplify() {
        this
    }
}
