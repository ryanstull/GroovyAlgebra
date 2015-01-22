package groovyAlg

import groovyAlg.parser.Parser

def x = Parser.parse("2*x*3*x^3")

println x

def y = Parser.parse("sin(x)^4")

println y

def z = x*y

println z

println z.derivative()

