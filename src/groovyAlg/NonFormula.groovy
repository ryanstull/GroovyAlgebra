package groovyAlg

/**
 * This class represents the an expression which doesn't contain other expressions,
 * such as a number or a variable
 *
 * @author  Ryan Stull <rstull1200@gmail.com>
 * @since   2014-12-12
 * @vesion  1.0
 */
abstract class NonFormula extends ArithmeticExpression {

    /**
     * Returns a simplified version of the expression
     *
     * For non-formulas this simply returns the expression itself
     */
    ArithmeticExpression simplify() {
        this
    }
}
