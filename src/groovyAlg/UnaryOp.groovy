package groovyAlg

/**
 * This class represents a function which contains only one other expression
 * for example the sin function
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
abstract class UnaryOp extends Formula {

    UnaryOp(ArithmeticExpression f = new Var()) {
        terms = [f]
    }

    Number evaluate(Number x) {
        operation(x)
    }

    /**
     * {@inheritDoc}
     */
    ArithmeticExpression compose(ArithmeticExpression f) {
        def rtrn = (UnaryOp) this.clone()
        if (rtrn.terms[0] instanceof NonFormula) {
            rtrn.terms[0] = f
        } else {
            rtrn.terms[0] = rtrn.terms[0].compose(f)
        }
        return rtrn
    }
}