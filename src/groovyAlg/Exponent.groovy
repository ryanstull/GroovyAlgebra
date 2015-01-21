package groovyAlg

import groovy.transform.InheritConstructors

@InheritConstructors
class Exponent extends BinaryOp {

    String symbol = "^"
    Closure<Number> operation = { a, b -> a**b }

    ArithmeticExpression derivative() {
        if (terms[1] instanceof Num && !(terms[0] instanceof Num)) {
            new Multiply([new Num(terms[1].num-1),terms[0],terms[0].derivative()])
        }
        throw Exception('Invalid derivative')
    }

    ArithmeticExpression simplify() {
        terms[0] = terms[0].simplify()
        terms[1] = terms[1].simplify()

        def equals = { ArithmeticExpression a, Number b -> a instanceof Num && a.num == b }

        if (equals(terms[0], 1)) {
            return new Num(1)
        } else if (equals(terms[1], 1)) {
            return terms[0]
        } else if (equals(terms[1], 0)) {
            return new Num(1)
        } else if (equals(terms[0], 0)) {
            return new Num(0)
        } else if (terms[0] instanceof Num && terms[1] instanceof Num) {
            return new Num(Math.pow(terms[0].num.doubleValue(), terms[1].num.doubleValue()))
        }

        return this
    }

}