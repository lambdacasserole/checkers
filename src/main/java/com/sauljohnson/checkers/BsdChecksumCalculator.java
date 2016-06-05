package com.sauljohnson.checkers;

/**
 * Provides BSD checksum calculation.
 *
 * @version 1.0 05 June 2016
 * @author Saul Johnson, Alex Mullen, Lee Oliver
 */
public class BsdChecksumCalculator {

    /**
     * Converts a 16-bit integer to a length-2 byte array.
     * @param x the integer to convert
     * @return  a length-2 byte array containing the result
     */
    private byte[] shortToByteArray(short x) {
        return new byte[] {
                (byte) ((x >> 8) & 0xff),
                (byte) (x & 0xff)
        };
    }

    public short computeShort(byte[] data) {
        int checksum = 0;
        for (byte current : data) {
            checksum = (checksum >>> 1) + ((checksum & 1) << 15);
            checksum += current;
            checksum &= 0xffff;
        }
        return (short) checksum;
    }

    /**
     * Computes the checksum for the specified byte array.
     * @param data  the byte array for which to compute the checksum
     * @return      the checksum for the specified byte array
     */
    public byte[] compute(byte[] data) {
        return shortToByteArray(computeShort(data));
    }
}
