import groovyAlg.parser.Parser

/**
 * Created by ryan on 1/20/15.
 */
class FormulaTest extends GroovyTestCase {

    void testEquality(){
        def a = Parser.parse("x+2")
        def b = Parser.parse("x+2")
        def c = Parser.parse("x-2")
        assert a==b: "Two expressions should be the same arithmetically should " +
                "be equal even if they aren't the same in memory"

        assert a!=c: "x+2 should be different from x-2"

        def sin1 = Parser.parse("sin(x)")
        def sin2 = Parser.parse("sin(x)")

        assert sin1==sin2: "Two different sin objects should be the same"

        def cos1 = Parser.parse("cos(x)")

        assert sin1!=cos1: "Sin and cos should be different"
    }
}
