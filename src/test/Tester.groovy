package test

import groovyAlg.parser.Parser

def x = Parser.parse("(4*x+1)^2+2*cos(x)")
println x
assert x.evaluate(0) == 3