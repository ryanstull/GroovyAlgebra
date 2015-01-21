import groovyAlg.*
import groovyAlg.parser.Parser

/**
 * Created by ryan on 1/20/15.
 */
class ParserTest extends GroovyTestCase {

    void testParse() {

        assertEquals("Parsing a num",new Num(2),Parser.parse("2"))
        assertEquals("Parsing a num",new Num(-2),Parser.parse("-2"))

        assertEquals("Parsing a variable",new Var(),Parser.parse("x"))

        assertEquals("Parsing an addition, x+2",Parser.parse("x+2"),new Add([new Var(),new Num(2)]))
        assertEquals("Parsing a subtraction",Parser.parse("x-2"),new Add([new Var(),new Num(-2)]))

        assertEquals("Parsing sin",new Sin(new Var()),Parser.parse("sin(x)"))
        assertEquals("Parsing cos",new Cos(new Var()),Parser.parse("cos(x)"))
        assertEquals("Parsing tan",new Tan(new Var()),Parser.parse("tan(x)"))
        assertEquals("Parsing csc",new Csc(new Var()),Parser.parse("csc(x)"))
        assertEquals("Parsing sec",new Sec(new Var()),Parser.parse("sec(x)"))
        assertEquals("Parsing cot",new Cot(new Var()),Parser.parse("cot(x)"))
    }
}
