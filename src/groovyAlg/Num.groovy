package groovyAlg

class Num implements NonFormula{	
	Number num
	
	Num(Number num){
		this.num=num
	}
	
	MathObject derivative() {
		new Num(0)
	}
	
	Number evaluate(Number x) {num}
	
	String toString(){num}

}
