package groovyAlg
/**
 * This class represents a function which is commutative and could have multiple terms in it.
 * For example addition or multiplication
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2015-01-13
 * @vesion  1.0
 */
abstract class MultiOp extends Formula {
    Number identity

    MultiOp(Collection<ArithmeticExpression> terms = []) {
        this.terms = terms
    }

    MultiOp(ArithmeticExpression... terms) {
        this.terms = terms
    }

    /**
     * Adds a term to the multiOp
     *
     * @param f The expression to add
     */
    void addTerm(ArithmeticExpression f){
        terms.add(f)
    }

    /**
     * @param x The number for which to evaluate the expression
     * @return  the result of evaluating each term for x and then combining the results using the operation of the particular multiOp
     */
    Number evaluate(Number x) {
        terms.inject(getIdentity(), {
            sum, term -> operation(sum, term.evaluate(x))
        })
    }

    /**
     * {@inheritDoc}
     */
    ArithmeticExpression compose(ArithmeticExpression f) {
        terms.collect {
            it.compose(f)//TODO fix this
        }
    }
}