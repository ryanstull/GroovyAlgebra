package groovyAlg

class Multiply implements BinaryOp {

	String symbol = "*"
	Closure<Number> operation = {a,b -> a*b}
	Closure<Double> getStart = {1}

	ArithmeticExpression derivative() {
	}

	ArithmeticExpression simplify(){
	}
}