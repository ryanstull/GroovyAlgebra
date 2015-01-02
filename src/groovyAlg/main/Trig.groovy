package groovyAlg.main

trait Trig extends UnaryOp{

	String toString(){
		"${getSymbol()}(${f1.toString()})"
	}

	MathObject simplify(){
		this
	}
}
