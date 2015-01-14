package groovyAlg

trait Formula extends ArithmeticExpression{
	ArithmeticExpression f1
	Closure<Num> operation
	String symbol
	
	abstract ArithmeticExpression compose(ArithmeticExpression f)

}