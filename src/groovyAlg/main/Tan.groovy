package groovyAlg.main

class Tan implements Trig{

	String symbol = "tan"
	Closure<Number> operation = Math.&tan

	MathObject derivative(){
		new Multiply('f1':new Exponent('f1':new Sec('f1':new Var()),'f2':new Num(2)),'f2':f1.derivative())
	}
	
}
