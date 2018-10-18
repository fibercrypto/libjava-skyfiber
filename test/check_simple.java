import junit.framework.*;

/**
 * Un test de ejemplo sobre la clase String.
 */
public class EjemploTest extends TestCase {

    public void testConcat() {
        String s = "hola";
        String s2 = s.concat(" que tal");
        assertTrue(s2.equals("hola que tal"));
    } // testConcat

    public static Test suite() {
        return new TestSuite(EjemploTest.class);
    } // suite

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    } // main

} // class