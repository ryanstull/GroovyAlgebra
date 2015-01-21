package groovyAlg

abstract class Formula extends ArithmeticExpression {
    List<ArithmeticExpression> terms
    Closure<Number> operation
    String symbol

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Formula)) return false

        if(terms.size()!=o.terms.size()) return false

        if(this.class!=o.class) return false

        def placesMatched = []
        out: for (it in terms) {
            for (int i = 0; i < o.terms.size(); i++) {
                if (it == o.terms[i] && !(placesMatched.contains(i))) {
                    placesMatched << i
                    break out
                }
                if(i == o.terms.size()-1){
                    return false
                }
            }
        }
        return true
    }
}