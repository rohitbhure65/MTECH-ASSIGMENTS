package unsigned;

public class Unsigned {
    public static void main(String[] args) {

        // BYTE
        byte b = (byte) 255;
        System.out.println("byte   : " + Byte.toUnsignedInt(b)
                + " | Range: 0 to 255");

        // SHORT
        short s = (short) 65535;
        System.out.println("short  : " + Short.toUnsignedInt(s)
                + " | Range: 0 to 65535");

        // INT
        int i = -1;
        System.out.println("int    : " + Integer.toUnsignedLong(i)
                + " | Range: 0 to 4294967295");

        // LONG
        long l = -1;
        System.out.println("long   : " + Long.toUnsignedString(l)
                + " | Range: 0 to 18446744073709551615");
    }
}
