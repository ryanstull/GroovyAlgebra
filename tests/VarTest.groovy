import groovyAlg.Var

/**
 * Created by ryan on 1/21/15.
 */
class VarTest extends GroovyTestCase {

    void testEquals() {
        def x1 = new Var()
        def x2 = new Var()

        assertTrue("Any two vars should be equal",x1==x2)

    }
}
