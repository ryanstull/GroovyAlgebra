package groovyAlg

import groovyAlg.main.Sin
import groovyAlg.main.Var

//MathObject f = new Add('f1':new Cos('f1':new Var()),'f2':new Multiply("f1":new Var(),"f2":new Num(3)))
//println f
//println f.evaluate(3)
//f=f.derivative()
//println f

def f = new Sin('f1':new Var())
println f
f = f.derivative()
println f