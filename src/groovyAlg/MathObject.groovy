package groovyAlg

trait MathObject {
	
	abstract Number evaluate(Number x)
	abstract MathObject derivative()
	abstract String toString()
	abstract MathObject simplify()

	MathObject plus(MathObject b){
		new Add('f1':this,'f2':b).simplify()
	}

	MathObject minus(MathObject b){
		new Subtract('f1':this,'f2':b).simplify()
	}

	MathObject multiply(MathObject b){
		new Multiply('f1':this,'f2':b).simplify()
	}

	MathObject div(MathObject b){
		new Divide('f1':this,'f2':b).simplify()
	}

	MathObject power(MathObject b){
		new Exponent('f1':this,'f2':b).simplify()
	}

	MathObject negative(){
		new Multiply('f1':this,'f2':new Num(-1)).simplify()
	}

}