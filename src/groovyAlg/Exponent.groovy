package groovyAlg

class Exponent implements BinaryOp{

	String symbol = "^"
	Closure<Number> operation = {a,b -> a**b}

	ArithmeticExpression derivative() {
		if (!(f1 instanceof Num) && !(f2 instanceof Num)) {
			throw Exception('Invalid derivative')
		} else if (f2 instanceof Num && !(f1 instanceof Num)) {
			return new Multiply('f1':new Multiply('f1': new Num(f2.num),'f2': new Exponent('f1':f1,'f2':new Num(f2.num-1))),'f2':f1.derivative()).simplify()
		}
	}

	ArithmeticExpression simplify() {
		f1=f1.simplify()
		f2=f2.simplify()

		def equals = {ArithmeticExpression a,Number b -> a instanceof Num && a.num==b}

		if(equals(f1,1)){
			return new Num(1)
		}else if(equals(f2,1)){
			return f1
		}else if(equals(f2,0)){
			return new Num(1)
		}else if(equals(f1,0)){
			return new Num(0)
		}else if(f1 instanceof Num && f2 instanceof Num){
			return new Num(Math.pow(f1.num.doubleValue(),f2.num.doubleValue()))
		}

		return this
	}

}