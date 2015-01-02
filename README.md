Groovy Algebra
================

A (very) simple computer algebra system, implemented in groovy

As of now, since it lacks a parser, it isn't too useful, but I plan on adding one soon.

You can construct different algebraic formula like so

```
def x = new Multiply('f1':new Num(3),'f2':new Sin('f1':new Var()))
// I know, I'll be adding a parser soon
```

After which you can evaluate the expression by

```
print x.evaluate(4)
```
or differentiate it!

```
def x2 = x.derivative()
```

That's all for now!

