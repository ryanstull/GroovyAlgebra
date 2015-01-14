package groovyAlg

/**
 * Created by ryan on 1/13/15.
 */
trait MultiOp extends Formula{
    ArrayList<ArithmeticExpression> terms
    Closure<Double> getStart

    Number evaluate(Number x){
        def rtrn = getStart()
        terms.each {
            operation(rtrn,it)
        }
        return rtrn
    }

    ArithmeticExpression compose(ArithmeticExpression f){
        terms.each {
            it.compose(f)
        }
    }
}