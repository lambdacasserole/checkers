package com.sauljohnson.checkers;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link BsdChecksumCalculator} class.
 *
 * @version 1.0 05 June 2016
 * @author  Saul Johnson
 */
public class BsdChecksumCalculatorTests extends TestCase {

    /** An array of data to hash. */
    private byte[][] data;

    /** An array of expected hashes. */
    private byte[][] hashes;

    public BsdChecksumCalculatorTests() {
        // Array of data strings.
        String[] dataStrings = new String[]
                {
                        "4e6651734b46703151374a7a5477444b", // ASCII: NfQsKFp1Q7JzTwDK
                        "6849325a637568725144556a4633716e", // ASCII: hI2ZcuhrQDUjF3qn
                        "4a72336d344646545a5a6c664f45346a", // ASCII: Jr3m4FFTZZlfOE4j
                        "51617175644139445045684272735270", // ASCII: QaqudA9DPEhBrsRp
                        "61516e5855537a4771756d506347534f", // ASCII: aQnXUSzGqumPcGSO
                        "6649337a3371766178334a4c39316a4a", // ASCII: fI3z3qvax3JL91jJ
                        "4d334653704475674e7230714436766d", // ASCII: M3FSpDugNr0qD6vm
                        "756a77467358335543567772695a5946"  // ASCII: ujwFsX3UCVwriZYF
                };

        // Turn data strings into bytes.
        data = new byte[dataStrings.length][];
        for (int i = 0; i < dataStrings.length; i++) {
            data[i] = toByteArray(dataStrings[i]);
        }

        // Array of expected hashes.
        String[] hashStrings = new String[]
                {
                        "3e6d",
                        "d38b",
                        "966f",
                        "9f0b",
                        "6cf8",
                        "f663",
                        "be0f",
                        "742d"
                };

        // Turn hash strings into bytes.
        hashes = new byte[hashStrings.length][];
        for (int i = 0; i < hashStrings.length; i++) {
            hashes[i] = toByteArray(hashStrings[i]);
        }
    }

    /**
     * Converts a hexadecimal string to a byte array.
     * @param hex   the hexadecimal string to convert
     * @return  the resulting byte array
     */
    private static byte[] toByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i+1), 16));
        }
        return data;
    }

    public void testCompute() {
        // Initialize calculator.
        BsdChecksumCalculator subject = new BsdChecksumCalculator();

        // Loop over test data.
        for (int i = 0; i < data.length; i++) {
            // Compute hash.
            byte[] actual = subject.compute(data[i]);
            byte[] expected = hashes[i];

            // Expected hash and actual hash should be same length.
            assertEquals(expected.length, actual.length);

            // Expected hash and actual hash should be identical.
            for (int j = 0; j < expected.length; j++) {
                assertEquals(expected[j], actual[j]);
            }
        }
    }
}
