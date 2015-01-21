package groovyAlg

class Num extends NonFormula {
    Number num

    Num(Number num) {
        this.num = num
    }

    Num(String num) {
        this.num = Integer.valueOf(num)
    }

    ArithmeticExpression derivative() {
        new Num(0)
    }

    ArithmeticExpression compose(ArithmeticExpression f) {
        new Num(num)
    }

    Number evaluate(Number x) { num }

    String toString() { num }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Num num1 = (Num) o

        if (num != num1.num) return false

        return true
    }

}
