Groovy Algebra
================

A simple computer algebra system, implemented in groovy

You can construct different algebraic formula like so

```
import groovyAlg.*
import groovyAlg.parser.*

def x = Parser.parse("(4*x+1)^2+2*cos(x)")
```

After which you can evaluate the expression by

```
assert x.evaluate(0) == 3
```
or differentiate it!

```
def x2 = x.derivative()
```

Also expressions are automatically simplified

```
def x3 = Parser.parse("2*x*3*x^3")
assert x3.ToString() == "6x^4"
```

That's all for now!

