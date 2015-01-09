package groovyAlg

class Var implements NonFormula {

	Number evaluate(Number x) {x}

	MathObject derivative() {
		new Num(1)
	}

	String toString(){
		"x"
	}

	boolean equals(Var other){
		true
	}
}