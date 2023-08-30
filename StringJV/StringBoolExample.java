package StringJV;

public class StringBoolExample {
    public static void main(String[] args) {
        new StringBoolExample().stringBool();
    }

    /**
     * Each time you create a string literal , the JVM checks the "string constant
     * pool" first. If the string already exists in the pool, a reference to the
     * pooled instance is returned. If the string doesn't exist in the pool, a new
     * string instance is created and placed in the pool.
     */
    private void stringBool() {

        String a = "abc";
        String b = "abc";
        a = a == b ? "true" : "false";
        System.out.println(a);

        /**
         * In such case, JVM will create a new string object in normal (non-pool) heap
         * memory, and the literal "Welcome" will be placed in the string constant pool.
         * The variable s will refer to the object in a heap (non-pool).
         */
        String c = new String("abc");
        c = c == a ? "true" : "false";
        System.out.println(c);
    }
}