package groovyAlg

abstract class Formula extends ArithmeticExpression {
    List<ArithmeticExpression> terms
    Closure<Number> operation
    String symbol

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Formula)) return false

        if (terms.size() != o.terms.size()) return false

        if (this.class != o.class) return false

        def placesMatched = []
        for (it in terms) {
            out:for (int i = 0; i < o.terms.size(); i++) {
                if (it == o.terms[i] && !(placesMatched.contains(i))) {
                    placesMatched << i
                    break out
                }
                if (i == o.terms.size() - 1) {
                    return false
                }
            }
        }
        return true
    }

    int hashCode() {
        int result
        result = (terms != null ? terms.hashCode() : 0)
        result = 31 * result + (operation != null ? operation.hashCode() : 0)
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0)
        return result
    }
}