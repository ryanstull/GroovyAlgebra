package groovyAlg.main

class Cos implements Trig{

    String symbol = "cos"
    Closure<Number> operation = Math.&cos

    MathObject derivative(){
        new Multiply('f1':new Num(-1),'f2':new Sin('f1':new Var()))
    }

}
