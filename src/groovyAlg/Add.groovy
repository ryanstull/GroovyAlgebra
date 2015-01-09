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
		}else{
			def l1 = []
			def l2 = []
			if(f1 instanceof Add){
				l1.add(f1.f1)
				l1.add(f1.f2)
			}else{
				l1.add(f1)
			}

			if(f2 instanceof Add){
				l2.add(f2.f1)
				l2.add(f2.f2)
			}else{
				l2.add(f2)
			}

			HashMap<Class,ArrayList<MathObject>> x = new HashMap<Class,ArrayList<MathObject>>()

			for(ArrayList<MathObject> l: [l1,l2]){
				for(MathObject m: l){
					if(!x.containsKey(m.getClass())){
						def arr = new ArrayList<MathObject>()
						arr.add(m)
						x.put(m.getClass(),arr);
					}else{
						x.get(m.getClass()).add(m)
					}
				}
			}

			x.each {k,v ->
				switch(v.size()){
					case 1: break
					case 2: break
					case 3: break
					case 4: break
				}
			}

			ArrayList<MathObject> stuff = new ArrayList<MathObject>()

		}

		return this
	}
 }