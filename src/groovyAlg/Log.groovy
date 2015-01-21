package groovyAlg

import groovy.transform.InheritConstructors

/**
 * Created by ryan on 1/16/15.
 */
@InheritConstructors
class Log extends UnaryOp {

    String symbol = "log"
    Closure<Number> operation = Math.&log10

    ArithmeticExpression derivative() {
        null
    }

    String toString() {
        "${getSymbol()}(${terms[0].toString()})"
    }

    ArithmeticExpression simplify() {
        this
    }
}
