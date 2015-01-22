import groovyAlg.Exponent
import groovyAlg.Multiply
import groovyAlg.Num
import groovyAlg.Var

/**
 * Created by ryan on 1/21/15.
 */
class MultiplyTest extends GroovyTestCase {

    void testSimplify() {
        def mult1 = new Multiply([new Num(1),new Num(9),new Num(3)]).simplify()
        assertEquals("Testing number multiplication simplification",new Num(27),mult1)

        def mult2 = new Multiply([new Var(),new Exponent(new Var(),new Num(2))]).simplify()

        assertEquals("Testing simplification of exponents should be x^3",new Exponent(new Var(),new Num(3)),mult2)
    }
}
