package groovyAlg

class Csc implements Trig{

    String symbol = "csc"
    Closure<Number> operation = {Double a -> 1/Math.sin(a)}

    MathObject derivative(){
        new Multiply('f1':new Num(-1),'f2':new Multiply('f1':new Cot('f1':new Var()),'f2':new Csc('f1':new Var())))
    }
}
