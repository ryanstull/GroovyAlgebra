package groovyAlg.main

class Cot implements Trig{

    String symbol = "cot"
    Closure<Number> operation = {Double a -> 1/Math.tan(a)}

    MathObject derivative(){
        new Multiply('f1':new Num(-1),'f2':new Exponent('f1':new Csc('f1':new Var()),'f2':new Num(2)))
    }
}
