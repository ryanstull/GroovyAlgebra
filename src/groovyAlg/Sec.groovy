package groovyAlg

class Sec implements Trig{

	String symbol = "sec"
	Closure<Number> operation = {Double a -> 1/Math.cos(a)}

	MathObject derivative(){
		new Multiply('f1':new Sec('f1':new Var()),'f2':new Tan('f1':new Var()))
	}
}
