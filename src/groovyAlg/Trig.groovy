package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class contains information that is common to all trigonometric functions, such as formatting
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@InheritConstructors
abstract class Trig extends UnaryOp {

    String toString() {
        "${getSymbol()}(${terms[0].toString()})"
    }

    //TODO Add simplification rules for all trig functions
    ArithmeticExpression simplify() {
        this
    }
}
