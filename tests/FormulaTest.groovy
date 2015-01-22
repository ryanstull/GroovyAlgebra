import groovyAlg.parser.Parser

/**
 * Created by ryan on 1/20/15.
 */
class FormulaTest extends GroovyTestCase {

    void testEquality(){
        def a = Parser.parse("x+2")
        def b = Parser.parse("x+2")
        def c = Parser.parse("x-2")

        assertEquals("Two expressions should be the same arithmetically should " +
                "be equal even if they aren't the same in memory",a,b)

        assertFalse("x+2 and x-2 should register as different",a==c)

        def sin1 = Parser.parse("sin(x)")
        def sin2 = Parser.parse("sin(x)")

        assertEquals("Two different sin objects should be the same",sin1,sin2)

        def cos1 = Parser.parse("cos(x)")

        assertFalse("Sin and cos should be different",sin1==cos1)
    }
}
