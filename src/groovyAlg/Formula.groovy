package groovyAlg

abstract class Formula extends ArithmeticExpression {
    List<ArithmeticExpression> terms
    Closure<Number> operation
    String symbol
    private mc= [compare:{ArithmeticExpression a,ArithmeticExpression b-> getSortOrder(a)==getSortOrder(b)? 0:
            getSortOrder(a)<getSortOrder(b)? -1: 1}] as Comparator


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

    /**
     * Sorts the terms into a standardized order i.e. putting constants before other expressions
     */
    void sort(){
        terms.sort(mc)
    }

    /**
     * Returns the place a given type of expression should have when sorted
     *
     * @param x The expression
     * @return  It's place in a sorted array of expressions
     */
    static int getSortOrder(ArithmeticExpression x){
        switch (x){
            case Num: return 0
            case Var: return 1
            case Multiply: return 2
            case Divide: return 3
            case Log: return 4
            case Sin: return 5
            case Cos: return 6
            case Tan: return 7
            case Csc: return 8
            case Sec: return 9
            case Cot: return 10
            case Exponent: return 11
            case Add: return 12
        }
    }
}