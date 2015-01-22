package groovyAlg
/**
 * Created by ryan on 1/13/15.
 */
abstract class ArithmeticExpression extends Expression {

    /**
     * This function returns the numeric value of the math object.
     *
     * @param x The input value to the math object
     * @return The value of the expression evaluated for the given x value
     */
    abstract Number evaluate(Number x)

    abstract ArithmeticExpression compose(ArithmeticExpression f)

    abstract ArithmeticExpression simplify()

    /**
     * Returns the derivative of the math object.  For example if the math object is x^2 the
     * derivative returned will be 2*x
     *
     * @return The derivative of the math object
     */
    abstract ArithmeticExpression derivative()

    ArithmeticExpression negative() {
        new Multiply([this, new Num(-1)]).simplify()
    }

    /**
     * Used to implement addition operator overloading for math objects
     *
     * @param b The other math object to add to this one
     * @return An expression which is the addition of the two objects
     */
    ArithmeticExpression plus(ArithmeticExpression b) {
        new Add([this, b]).simplify()
    }

    /**
     * Used to implement subtraction operator overloading for math objects
     *
     * @param b The other math object to add to this one
     * @return An expression which is the addition of the two objects
     */
    ArithmeticExpression minus(ArithmeticExpression b) {
        new Add([this, b.negative()]).simplify()
    }

    /**
     * Used to implement multiplication operator overloading for math objects
     *
     * @param b The other math object to add to this one
     * @return An expression which is the addition of the two objects
     */
    ArithmeticExpression multiply(ArithmeticExpression b) {
        new Multiply([this, b]).simplify()
    }

    /**
     * Used to implement division operator overloading for math objects
     *
     * @param b The other math object to add to this one
     * @return An expression which is the addition of the two objects
     */
    ArithmeticExpression div(ArithmeticExpression b) {
        new Divide(this, b).simplify()
    }

    /**
     * Used to implement exponentiation operator overloading for math objects
     *
     * @param b The other math object to add to this one
     * @return An expression which is the addition of the two objects
     */
    ArithmeticExpression power(ArithmeticExpression b) {
        new Exponent(this, b).simplify()
    }

}
