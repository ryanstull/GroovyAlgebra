package groovyAlg

import groovy.transform.InheritConstructors

/**
 * This class represents the cosecant function
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@InheritConstructors
class Divide extends BinaryOp {

    String symbol = "/"
    Closure<Number> operation = { a, b -> a / b }

    /**
     * @return The derivative of a division using the quotient rule
     */
    ArithmeticExpression derivative() {
        new Divide(new Add([new Multiply([terms[0].derivative(), terms[1]]), new Multiply([new Num(-1), terms[0], terms[1].derivative()])]), new Exponent(terms[1], new Num(2)))
    }

    /**
     * {@inheritDoc }
     */
    ArithmeticExpression simplify() {
        terms[0] = terms[0].simplify()
        terms[1] = terms[1].simplify()

        def equals = { ArithmeticExpression a, Number b -> a instanceof Num && a.num == b }

        if (equals(terms[1], 1)) {
            return terms[0]
        } else if (equals(terms[1], 0)) {
            return new Num(0)
        } else if (terms[0] instanceof Num && terms[1] instanceof Num) {
            return new Num(terms[0].num / terms[1].num)
        }

        return this;
    }
}