import junit.framework.TestSuite

//TODO Write more tests...


public class MyTestSuite extends TestSuite {
    private static final String TEST_ROOT = "tests/";
    public static TestSuite suite() throws Exception {
        TestSuite suite = new TestSuite();
        GroovyTestSuite gsuite = new GroovyTestSuite();
        suite.addTestSuite(gsuite.compile(TEST_ROOT + "ParserTest.groovy"));
        suite.addTestSuite(gsuite.compile(TEST_ROOT + "FormulaTest.groovy"));
        return suite;
    }
}