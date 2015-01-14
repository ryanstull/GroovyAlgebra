package groovyAlg

trait UnaryOp extends Formula{

	Number evaluate(Number x){
		operation(x)
	}

	ArithmeticExpression compose(ArithmeticExpression f){
		if(f1 instanceof NonFormula){
			f1=f
		}else{
			f1=f1.compose(f)
		}
	}
}