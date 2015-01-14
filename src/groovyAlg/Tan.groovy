package groovyAlg

/**
 * This class represents the sin function
 *
 * @author Ryan Stull
 */
class Tan implements Trig{

	String symbol = "tan"

	//References the java.Math implementation for tan
	Closure<Number> operation = Math.&tan

	/**
	 * @return sec^2(f1)*f1'
	 */
	ArithmeticExpression derivative(){
		new Multiply('f1':new Exponent('f1':new Sec('f1':new Var()),'f2':new Num(2)),'f2':f1.derivative())
	}
	
}
