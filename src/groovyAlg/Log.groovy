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
        if(terms[0] instanceof Num){
            switch (terms[0].num){
                case Math.E:
                    return "ln(${terms[0].toString()})"

                case 2:
                    return "lg(${terms[0].toString()})"

                default:
                    return "${getSymbol()}_${terms[0]}(${terms[1]})"
            }
        }
    }

    ArithmeticExpression simplify() {
        this
    }

}
