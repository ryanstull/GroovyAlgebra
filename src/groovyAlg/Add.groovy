package groovyAlg

import groovy.transform.InheritConstructors

@InheritConstructors
class Add extends MultiOp {

    String symbol = "+"
    Closure<Number> operation = { a, b -> a + b }
    Number identity = 0

    ArithmeticExpression derivative() {
        new Add(terms.collect { it.derivative() }).simplify()
    }

    ArithmeticExpression simplify() {
        Add rtrn = this.clone()
        def newTerms = rtrn.terms

        for (int i = 0; i < terms.size(); i++) {
            newTerms[i] = terms[i].simplify()
        }
        for (int i = 0; i < newTerms.size(); i++) {
            if(newTerms[i] instanceof Add){
                newTerms.addAll(newTerms[i].terms)
                newTerms.remove(i)
            }
        }

        newTerms.retainAll{
            it!=new Num(0)
        }

        for(int i=newTerms.size()-1;i>=0;i--){
            if(newTerms[i] instanceof Num){
                for(int j=i-1;j>=0;j--){
                    if(newTerms[j] instanceof Num){
                        newTerms[j] = new Num(newTerms[j].num+newTerms[i].num)
                        newTerms.remove(i)
                    }
                }
            }
        }

        if (rtrn.terms.size()==1){
            return rtrn.terms[0]
        }

        def map = new LinkedHashMap<ArithmeticExpression,List<ArithmeticExpression>>()
        for(it in newTerms){
            def func
            if (it instanceof Multiply) {
                func = new Multiply(it.terms.findAll{a -> !(a instanceof Num)})
                if (!map.containsKey(func)) {
                    map.put(func, [])
                }
                map[func] << it.terms.find { a -> a instanceof Num }
            } else {
                func = it
                if (!map.containsKey(func)) {
                    map.put(func, [])
                }
                map[func] << new Num(1)
            }
        }

        def terms2 = []
        map.each { k, v ->
            if (v.size()==1 && v[0]==new Num(1)){
                terms2 << k
            }else{
                terms2 << new Multiply([k,new Add(v).simplify()])
            }

        }

        rtrn.terms = terms2
        newTerms = rtrn.terms

        for (int i = 0; i < newTerms.size(); i++) {
            newTerms[i] = newTerms[i].simplify()
        }

        if (rtrn.terms.size()==1){
            return rtrn.terms[0]
        }

        return rtrn
    }

    String toString() {
        String rtrn = ""
        for(ArithmeticExpression term: terms){
            if(!term.is(terms.first()) && !(term instanceof Num && term.num<0)){
                rtrn+="+"
            }
            rtrn += term.toString()
        }
        return rtrn
    }
}