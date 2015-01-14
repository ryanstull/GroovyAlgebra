package groovyAlg

/**
 * This class represents a variable
 */
class Var implements NonFormula {

	/**
	 * Evaluates a variable which simply returns the value passed as an argument
	 *
	 * @param x The value to evaluate the variable at
	 * @return The value passed as a parameter
	 */
	Number evaluate(Number x) {x}

	/**
	 * Returns the derivative of x which is 1
	 *
	 * @return The number 1
	 */
	ArithmeticExpression derivative() {
		new Num(1)
	}

	String toString(){
		"x"
	}

	boolean equals(Var other){
		true
	}
}