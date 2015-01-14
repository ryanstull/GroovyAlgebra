package test

import groovyAlg.*
import groovyAlg.parser.Parser

def x = (ArithmeticExpression) Parser.parse("(4*x+1)^2+2*cos(x)")
println x
def y = x.derivative()
println y
assert x.evaluate(0) == 3