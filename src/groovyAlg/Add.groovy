package groovyAlg

class Add implements MultiOp {

	String symbol = "+"
	Closure<Number> operation = {a,b -> a+b}
	Closure<Double> getStart = {0}

	ArithmeticExpression derivative() {

	}

	ArithmeticExpression simplify(){

	}
 }