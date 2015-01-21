package groovyAlg

import groovy.transform.InheritConstructors

@InheritConstructors
class Add extends MultiOp {

    String symbol = "+"
    Closure<Number> operation = { a, b -> a + b }
    Number identity = 0

    ArithmeticExpression derivative() {
        new Add(terms.collect { it.derivative() }).simplify()
    }

    ArithmeticExpression simplify() {
        for (int i = 0; i < terms.size(); i++) {
            terms[i] = terms[i].simplify()
        }

        terms = terms.findAll() {
            it != new Num(0)
        }

        if (terms.size()==1){
            return terms[0]
        }

        //TODO implement this simplify
        return this
    }

    String toString() {
        terms.collect { it.toString() }.join(symbol)
    }
}