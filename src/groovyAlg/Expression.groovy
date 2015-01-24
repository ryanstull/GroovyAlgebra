package groovyAlg
import groovy.transform.AutoClone
/**
 /**
 * This class represents an abstract expression which can be evaluated or manipulated
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
@AutoClone
abstract class Expression {

    /**
     * Returns a simplified version of the expression
     * !!NOTE   The returned expression is not guaranteed to be of
     * the same class as the calling expressions class
     * <p>
     * For example and addition of 2+3 will simplify to 5 which will have
     * a class of Num, and it won't be an addition with only one term that is 5
     * Another example, e^(ln(x)) will simplify to x which is of type Var
     * </p>
     *
     * @return a simplified expression
     */
    abstract Expression simplify()

    /**
     * Used to implement negation operator overloading for math objects
     *
     * @param b The other math object to add to this one
     * @return An expression which is the addition of the two objects
     */
    abstract Expression negative()

    abstract String toString()
}
