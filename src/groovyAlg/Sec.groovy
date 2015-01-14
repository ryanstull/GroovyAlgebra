package groovyAlg

/**
 * This class represents the sec function
 *
 * @author Ryan Stull
 */
class Sec implements Trig{

	String symbol = "sec"

	//References the java.math implementation of cos
	Closure<Number> operation = {Double a -> 1/Math.cos(a)}

	/**
	 * @return sec(f1)*tan(f1)*f1'
	 */
	ArithmeticExpression derivative(){
		new Multiply('f1':new Multiply('f1':new Sec('f1':f1),'f2':new Tan('f1':f1)),'f2':f1.derivative())
	}
}
