package groovyAlg

import groovy.transform.InheritConstructors

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
