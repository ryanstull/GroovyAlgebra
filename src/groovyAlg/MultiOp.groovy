package groovyAlg
/**
 * Created by ryan on 1/13/15.
 */
abstract class MultiOp extends Formula {
    Number identity

    MultiOp(Collection<ArithmeticExpression> terms = []) {
        this.terms = terms
    }

    MultiOp(ArithmeticExpression... terms) {
        this.terms = terms
    }

    void addTerm(ArithmeticExpression f) {
        terms.add(f)
    }

    Number evaluate(Number x) {
        terms.inject(getIdentity(), {
            sum, term -> operation(sum, term.evaluate(x))
        })
    }

    ArithmeticExpression compose(ArithmeticExpression f) {
        terms.collect {
            it.compose(f)
        }
    }
}