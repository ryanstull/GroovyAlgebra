package test

import groovyAlg.parser.Parser

def x = Parser.parse("sin(x)^2-2")

println x.evaluate(Math.PI/2)
y = x.derivative()
println y
