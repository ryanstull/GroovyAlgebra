package groovyAlg

/**
 * This class represents the sin function
 *
 * @author Ryan Stull
 */
class Sin implements Trig {

	String symbol = "sin"

	//References the java.Math implementation of sin
	Closure<Number> operation = Math.&sin

	/**
	 * @return cos(f1)*f1'
	 */
	ArithmeticExpression derivative() {
		new Multiply('f1': new Cos('f1':f1), 'f2': f1.derivative()).simplify()
	}

}