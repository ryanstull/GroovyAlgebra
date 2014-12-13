package groovyAlg

trait MathObject {
	
	abstract Number evaluate(Number x)
	abstract MathObject derivative()
	abstract String toString()
	abstract MathObject simplify()
}
