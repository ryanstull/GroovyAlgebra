package groovyAlg

trait MathObject {
	
	abstract Number evaluate(Number x)
	abstract MathObject derivative()
	abstract String toString()
	abstract MathObject simplify()
	MathObject negate(){
		return new Multiply('f1':this,'f2':new Num(-1))
	}
}
