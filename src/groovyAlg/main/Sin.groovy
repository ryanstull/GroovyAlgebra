package groovyAlg.main

class Sin implements Trig {

	String symbol = "sin"
	Closure<Number> operation = Math.&sin

	MathObject derivative() {
		new Multiply('f1': new Cos('f1':f1), 'f2': f1.derivative()).simplify()
	}

}