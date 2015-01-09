package groovyAlg

trait UnaryOp extends Formula{

	MathObject compose(MathObject f){
		if(f1 instanceof NonFormula){
			f1=f
		}else{
			f1=f1.compose(f)
		}
	}

	Number evaluate(Number x){
		operation(x)
	}
}