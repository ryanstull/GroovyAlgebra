package groovyAlg

import groovy.transform.InheritConstructors

@InheritConstructors
class Cos extends Trig {

    String symbol = "cos"
    Closure<Number> operation = Math.&cos

    ArithmeticExpression derivative() {
        new Multiply([new Num(-1), new Cos(terms[0]), terms[0].derivative()]).simplify()
    }

}
