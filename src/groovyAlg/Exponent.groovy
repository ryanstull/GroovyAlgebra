package groovyAlg

class Exponent implements BinaryOp{

	String symbol = "^"
	Closure<Number> operation = {a,b -> a**b}

	MathObject derivative() {
		null
	}

	MathObject simplify() {
		f1=f1.simplify()
		f2=f2.simplify()

		def equals = {MathObject a,Number b -> a instanceof Num && a.num==b}

		if(equals(f1,1)){
			return new Num(1)
		}else if(equals(f2,1)){
			return f1
		}else if(equals(f2,0)){
			return new Num(1)
		}else if(equals(f1,0)){
			return new Num(0)
		}

		return this
	}

}