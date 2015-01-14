package groovyAlg

class Divide implements BinaryOp {

	String symbol = "/"
	Closure<Number> operation = {a,b -> a/b}

	ArithmeticExpression derivative() {
		new Divide('f1':new Subtract('f1':new Multiply('f1':f1.derivative(),'f2':f2),'f2':new Multiply('f1':f1,'f2':f2.derivative())),
				'f2':new Exponent('f1':f2,'f2':new Num(2)))
	}

	ArithmeticExpression simplify(){
		f1=f1.simplify()
		f2=f2.simplify()

		def equals = {ArithmeticExpression a,Number b -> a instanceof Num && a.num==b}

		if(equals(f2,1)){
			return f1
		}else if(equals(f1,0)){
			return new Num(0)
		}else if(f1 instanceof Num && f2 instanceof Num){
			return new Num(f1.num/f2.num)
		}

		return this;
	}
}