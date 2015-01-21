package groovyAlg

import groovyAlg.parser.Parser

def x = Parser.parse("x+5")

def y = Parser.parse("2+x")

println x.evaluate(2)

println x==y