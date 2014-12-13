package groovyAlg

class Add implements BinaryOp {

	String symbol = "+"
	Closure<Number> operation = {a,b -> a+b}
	
	MathObject derivative() {
		new Add('f1':f1.derivative(),'f2':f2.derivative()).simplify()
	}

	MathObject simplify(){
		f1 = f1.simplify()
		f2 = f2.simplify()

		def equals = {MathObject a,Number b -> a instanceof Num && a.num==b}

		if(equals(f1,0)){
			return f2;
		}else if(equals(f2,0)){
			return f1;
		}else if(f1 instanceof Num && f2 instanceof Num){
			return new Num(f1.num+f2.num)
		}

		return this
	}
 }