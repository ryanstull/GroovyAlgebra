package groovyAlg

abstract class UnaryOp extends Formula {

    UnaryOp(ArithmeticExpression f = new Var()) {
        terms = [f]
    }

    Number evaluate(Number x) {
        operation(x)
    }

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