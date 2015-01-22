package groovyAlg
import groovy.transform.AutoClone
/**
 * Created by ryan on 1/13/15.
 */
@AutoClone
abstract class Expression {

    /**
     * Returns a simplified version of the expression
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
