package groovyAlg

import groovy.transform.InheritConstructors

@InheritConstructors
class Exponent extends BinaryOp {

    String symbol = "^"
    Closure<Number> operation = { a, b -> a**b }

    ArithmeticExpression derivative() {
        if (terms[1] instanceof Num && !(terms[0] instanceof Num)) {
            return new Multiply([new Num(terms[1].num), new Exponent(terms[0],new Num(terms[1].num - 1)), terms[0].derivative()])
        }
        throw new Exception('Invalid derivative')
    }

    ArithmeticExpression simplify() {
        Exponent rtrn = this.clone()
        def newTerms = rtrn.terms

        newTerms[0] = newTerms[0].simplify()
        newTerms[1] = newTerms[1].simplify()

        def equals = { ArithmeticExpression a, Number b -> a instanceof Num && a.num == b }

        if (equals(newTerms[0], 1)) {
            return new Num(1)
        } else if (equals(newTerms[1], 1)) {
            return newTerms[0]
        } else if (equals(newTerms[1], 0)) {
            return new Num(1)
        } else if (equals(newTerms[0], 0)) {
            return new Num(0)
        } else if (newTerms[0] instanceof Num && newTerms[1] instanceof Num) {
            return new Num(Math.pow(newTerms[0].num.doubleValue(), newTerms[1].num.doubleValue()))
        }

        return rtrn
    }

}