package groovyAlg.main

trait Formula extends MathObject{
	MathObject f1
	Closure<Num> operation
	String symbol
	
	abstract MathObject compose(MathObject f)

}