
public class check_simple {

    static {
        try {
            System.loadLibrary("skycoin");
        } catch (UnsatisfiedLinkError e) {
            System.err.println(
                    "Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n"
                            + e);
            System.exit(1);
        }
    }

    skycoin skycoin = new skycoin();

    public static void main(String argv[]) {
        // Call our gcd() function

        int x = 42;
        int y = 105;
        int g = skycoin.SKY_OK;
        System.out.println("The gcd of " + x + " and " + y + " is " + g);

        // Manipulate the Foo global variable

        // Output its current value
        System.out.println("Foo = " + skycoin.SKY_OK);

        // See if the change took effect
        System.out.println("Foo = " + skycoin.SKY_OK);
    }
}