package groovyAlg

class Num implements NonFormula{	
	Number num
	
	Num(Number num){
		this.num=num
	}

	Num(String num){
		this.num = Integer.valueOf(num)
	}
	
	MathObject derivative() {
		new Num(0)
	}
	
	Number evaluate(Number x) {num}
	
	String toString(){num}

}
