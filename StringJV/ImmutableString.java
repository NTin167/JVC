package StringJV;

/**
 * 1. ClassLoader:
 * 
 * A ClassLoader in Java uses a String object as an argument. Consider, if the
 * String object is modifiable, the value might be changed and the class that is
 * supposed to be loaded might be different.
 * 
 * To avoid this kind of misinterpretation, String is immutable.
 * 
 * 2. Thread Safe:
 * 
 * As the String object is immutable we don't have to take care of the
 * synchronization that is required while sharing an object across multiple
 * threads.
 * 
 * 3. Security:
 * 
 * As we have seen in class loading, immutable String objects avoid further
 * errors by loading the correct class. This leads to making the application
 * program more secure. Consider an example of banking software. The username
 * and password cannot be modified by any intruder because String objects are
 * immutable. This can make the application program more secure.
 * 
 * 4. Heap Space:
 * 
 * The immutability of String helps to minimize the usage in the heap memory.
 * When we try to declare a new String object, the JVM checks whether the value
 * already exists in the String pool or not. If it exists, the same value is
 * assigned to the new object. This feature allows Java to use the heap space
 * efficiently.
 * 
 * @author https://www.javatpoint.com/immutable-string
 */
public class ImmutableString {
    public static void main(String[] args) {
        String s = "tinnv";
        String a = "tinnv";
        String b = "tinnv";
        s.concat(s);
        if (s == a) {
            System.out.println(s);
            System.out.println(a);
            System.out.println(b);

        }

        s = s.concat(s);
        if (s == a) {
            System.out.println(s);
            System.out.println(a);
            System.out.println(b);

        }

        s = "zzz";
        System.out.println(s);
        System.out.println(a);
        System.out.println(b);
    }
}
