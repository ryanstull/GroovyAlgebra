import groovyAlg.Add
import groovyAlg.Num
import groovyAlg.Var

/**
 * Created by ryan on 1/21/15.
 */
class AddTest extends GroovyTestCase {

    void testToString() {
        def x = new Add([new Num(2),new Var()])

        assertEquals("Testing toString for normal add","2+x",x.toString())
        "Sin and cos should be different"
        def x2 = new Add([new Var(),new Num(-2)])

        assertEquals("Testing with negative numbers","x-2",x2.toString())
    }
}
