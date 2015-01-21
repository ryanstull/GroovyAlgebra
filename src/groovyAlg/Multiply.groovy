package groovyAlg

import groovy.transform.InheritConstructors

@InheritConstructors
class Multiply extends MultiOp {

    String symbol = "*"
    Closure<Number> operation = { a, b -> a * b }
    Number identity = 1

    ArithmeticExpression derivative() {
        new Add(terms.collect { a ->
            new Multiply([a.derivative()] + terms.grep {
                !it.is(a)
            })
        }).simplify()
    }

    ArithmeticExpression simplify() {
        for (int i = 0; i < terms.size(); i++) {
            terms[i] = terms[i].simplify()
        }
        if (terms.contains(new Num(0))) {
            return new Num(0)
        }

        terms = terms.findAll() {
            it != new Num(1)
        }

        def map = new HashMap<ArithmeticExpression,List<ArithmeticExpression>>()
        terms.each {
            def func
            if (it instanceof Exponent) {
                func = it.terms[0]
                if(! map[func]){
                    map.put(func,[])
                }
                map[func] << it.terms[1]
            } else {
                func = it
                if(! map[func]){
                    map.put(func,[])
                }
                map[func] << new Num(1)
            }
        }

        def newTerms = []
        map.each { k, v ->
            newTerms << new Exponent(k,new Add(v))
        }
        terms = newTerms


    }

    String toString() {
        terms.collect {it.toString()}.join(symbol)
    }
}