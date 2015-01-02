package groovyAlg.main

trait BinaryOp extends Formula{
	MathObject f2;

	Number evaluate(Number x) {
		operation(f1.evaluate(x),f2.evaluate(x))
	}
	
	MathObject compose(MathObject f){
		if(f1 instanceof NonFormula){
			f1=f
		}else{
			f1=f1.compose(f)
		}
		
		if(f2 instanceof NonFormula){
			f2=f
		}else{
			f2=f2.compose(f)
		}
	}
	
	String toString(){
		String f1Str
		String f2Str
		if(f1 instanceof NonFormula || f1 instanceof Trig){
			f1Str = f1.toString()
		}else{
			f1Str = "("+f1.toString()+")"
		}
		
		if(f2 instanceof NonFormula || f2 instanceof Trig){
			f2Str = f2.toString()
		}else{
			f2Str = "("+f2.toString()+")"
		}
		f1Str+"${getSymbol()}"+f2Str
	}

}