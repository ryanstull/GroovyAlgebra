package groovyAlg

abstract class BinaryOp extends Formula {

    BinaryOp(ArithmeticExpression f1 = new Var(), ArithmeticExpression f2 = new Var()) {
        terms = [f1, f2]
    }

    Number evaluate(Number x) {
        operation(terms[0].evaluate(x), terms[1].evaluate(x))
    }

    ArithmeticExpression compose(ArithmeticExpression f) {
        def rtrn = (BinaryOp) this.clone()
        if (rtrn.terms[0] instanceof NonFormula) {
            rtrn.terms[0] = f
        } else {
            rtrn.terms[0] = terms[0].compose(f)
        }

        if (rtrn.terms[1] instanceof NonFormula) {
            rtrn.terms[1] = f
        } else {
            rtrn.terms[1] = rtrn.terms[1].compose(f)
        }

        return rtrn
    }

    String toString() {
        String f1Str
        String f2Str
        if (terms[0] instanceof NonFormula || terms[0] instanceof Trig) {
            f1Str = terms[0].toString()
        } else {
            f1Str = "(" + terms[0].toString() + ")"
        }

        if (terms[1] instanceof NonFormula || terms[1] instanceof Trig || (terms[0] instanceof Num && (terms[1] instanceof Exponent || terms[1] instanceof Trig))) {
            f2Str = terms[1].toString()
        } else {
            f2Str = "(" + terms[1].toString() + ")"
        }
        if ((terms[0] instanceof Num) && getSymbol() == "*") {
            if (terms[0].num == -1) {
                return "-" + f2Str
            } else {
                return f1Str + f2Str
            }
        } else {
            return f1Str + "${getSymbol()}" + f2Str
        }
    }

}