import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MatrixListTest {

    // Test for an empty matrix
    @Test
    public void testEmptyMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{});
        assertEquals("", matrix.toString(), "Empty matrix should produce an empty string.");
        assertEquals(0, matrix.howManyX(0), "Empty matrix should always return 0 occurrences.");
        assertEquals(Integer.MIN_VALUE, matrix.findMax(), "Empty matrix should return Integer.MIN_VALUE as max.");
    }

    // Test for single row and column matrices
    @Test
    public void testSingleRowMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{{1, 2, 3}});
        assertEquals(1, matrix.howManyX(2), "Single row matrix should correctly count occurrences.");
        assertEquals(3, matrix.findMax(), "Single row matrix should correctly find the max value.");
    }

    @Test
    public void testSingleColumnMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{{1}, {2}, {3}});
        assertEquals(1, matrix.howManyX(2), "Single column matrix should correctly count occurrences.");
        assertEquals(3, matrix.findMax(), "Single column matrix should correctly find the max value.");
    }

    // Test for matrices with all identical elements
    @Test
    public void testMatrixWithIdenticalElements() {
        MatrixList matrix = new MatrixList(new int[][]{
                {5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}
        });
        assertEquals(5, matrix.findMax(), "Max should be the identical value.");
    }

    // Test for negative numbers
    @Test
    public void testNegativeNumbersMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{
                {-1, -2, -3},
                {-4, -5, -6},
                {-7, -8, -9}
        });
        assertEquals(-1, matrix.findMax(), "Max should be the least negative value.");
    }

    // Test for mixed positive and negative numbers
    @Test
    public void testMixedNumbersMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{
                {3, -1, 4},
                {-1, 5, -9},
                {2, -6, 5}
        });
        assertEquals(5, matrix.findMax(), "Max should be the largest positive number.");
    }

    // Test for out-of-bounds access
    @Test
    public void testOutOfBoundsAccess() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixList matrix = new MatrixList(mat);
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(-1, 0), "Accessing negative row should return Integer.MIN_VALUE.");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, -1), "Accessing negative column should return Integer.MIN_VALUE.");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(10, 0), "Accessing row out of bounds should return Integer.MIN_VALUE.");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, 10), "Accessing column out of bounds should return Integer.MIN_VALUE.");
    }

    // Test for sparse matrices
    @Test
    public void testSparseMatrix() {
        int[][] mat = {
                {0, 0, 0},
                {0, 7, 0},
                {0, 0, 0}
        };
        MatrixList matrix = new MatrixList(mat);
        assertEquals(7, matrix.findMax(), "Max should correctly identify the only non-zero value.");
    }

    // Test for large and small values
    @Test
    public void testLargeAndSmallValuesMatrix() {
        int[][] mat = {
                {Integer.MIN_VALUE, -100, 0},
                {1, Integer.MAX_VALUE, -50}
        };
        MatrixList matrix = new MatrixList(mat);
        assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Max should correctly identify Integer.MAX_VALUE.");
    }

    @Test
    public void testAlternatingPattern() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 1},
                {2, 1, 2},
                {1, 2, 1}
        });
        assertEquals(2, matrix.findMax(), "Max should be correct in alternating pattern");
    }

    @Test
    public void testNonSquareMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        });
        assertEquals(8, matrix.findMax(), "Should find max in non-square matrix");
    }

    @Test
    public void testDiagonalPattern() {
        MatrixList matrix = new MatrixList(new int[][]{
                {9, 0, 0},
                {0, 9, 0},
                {0, 0, 9}
        });
        assertEquals(9, matrix.findMax(), "Should find max in diagonal matrix");
    }

    @Test
    public void testBoundaryValues() {
        MatrixList matrix = new MatrixList(new int[][]{
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MIN_VALUE + 1, Integer.MIN_VALUE}
        });
        assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Should handle MAX_VALUE correctly");
    }

    @Test
    public void testZigZagPattern() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 3},
                {6, 5, 4},
                {7, 8, 9}
        });
        assertEquals(9, matrix.findMax(), "Should find max in zigzag pattern");
    }

    @Test
    public void testSingleElement() {
        MatrixList matrix = new MatrixList(new int[][]{{42}});
        assertEquals(42, matrix.findMax(), "Should find max in single element matrix");
    }

    @Test
    public void testRepeatedRows() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        });
        assertEquals(3, matrix.findMax(), "Should find max in matrix with repeated rows");
    }

    @Test
    public void testRepeatedColumns() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        });
        assertEquals(3, matrix.findMax(), "Should find max in matrix with repeated columns");
    }

    @Test
    public void testTriangularPattern() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 0, 0},
                {2, 3, 0},
                {4, 5, 6}
        });
        assertEquals(6, matrix.findMax(), "Should find max in triangular pattern");
    }

    @Test
    public void testAllZeros() {
        MatrixList matrix = new MatrixList(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });
        assertEquals(0, matrix.findMax(), "Should handle matrix of all zeros");
    }

    @Test
    public void testIncreasingValues() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        });
        assertEquals(0, matrix.howManyX(13), "Should handle non-existent value");
        assertEquals(12, matrix.findMax(), "Should find max in increasing pattern");
    }

    @Test
    public void testAlternatingSignsPattern() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, -1, 1},
                {-1, 1, -1},
                {1, -1, 1}
        });
        assertEquals(1, matrix.findMax(), "Should find max in alternating signs pattern");
    }

    @Test
    public void testWideMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8}
        });
        assertEquals(1, matrix.howManyX(8), "Should find element in wide matrix");
        assertEquals(8, matrix.findMax(), "Should find max in wide matrix");
    }

    @Test
    public void testTallMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        });
        assertEquals(8, matrix.findMax(), "Should find max in tall matrix");
    }

    @Test
    public void testCheckerboardPattern() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 1, 2},
                {2, 1, 2, 1},
                {1, 2, 1, 2},
                {2, 1, 2, 1}
        });
        assertEquals(2, matrix.findMax(), "Should find max in checkerboard pattern");
    }

    @Test
    public void testBorderPattern() {
        MatrixList matrix = new MatrixList(new int[][]{
                {5, 5, 5, 5},
                {5, 0, 0, 5},
                {5, 0, 0, 5},
                {5, 5, 5, 5}
        });
        assertEquals(5, matrix.findMax(), "Should find max in border pattern");
    }

    @Test
    public void testSequentialDuplicates() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 1, 2, 2},
                {3, 3, 4, 4},
                {5, 5, 6, 6}
        });
        assertEquals(6, matrix.findMax(), "Should find max with sequential duplicates");
    }

    @Test
    public void testLargeValuesDifference() {
        MatrixList matrix = new MatrixList(new int[][]{
                {Integer.MIN_VALUE, 0, Integer.MAX_VALUE},
                {Integer.MIN_VALUE / 2, 0, Integer.MAX_VALUE / 2},
                {-1, 0, 1}
        });
        assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Should handle extreme value differences");
    }

    @Test
    public void testSparseMatrixWithNegatives() {
        MatrixList matrix = new MatrixList(new int[][]{
                {0, -1, 0},
                {0, 0, 0},
                {-1, 0, 0}
        });
        assertEquals(0, matrix.findMax(), "Should find max in sparse matrix with negatives");
    }

    @Test
    public void testPrimeNumbersOnly() {
        MatrixList matrix = new MatrixList(new int[][]{
                {2, 3, 5, 7},
                {11, 13, 17, 19},
                {23, 29, 31, 37}
        });
        assertEquals(37, matrix.findMax(), "Should find largest prime");
    }

    @Test
    public void testFibonacciSequence() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 1, 2, 3},
                {5, 8, 13, 21},
                {34, 55, 89, 144}
        });
        assertEquals(144, matrix.findMax(), "Should find largest Fibonacci number");
    }

    @Test
    public void testBinaryRepresentation() {
        MatrixList matrix = new MatrixList(new int[][]{
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 0, 1, 1}
        });
        int expectedDecimal = 0b1011; // 11 in decimal
    }

    @Test
    public void testPowerOfTwo() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 4, 8},
                {16, 32, 64, 128},
                {256, 512, 1024, 2048}
        });
        assertEquals(1, matrix.howManyX(64), "Should find specific power of 2");
        assertEquals(2048, matrix.findMax(), "Should find largest power of 2");
    }

    @Test
    public void testASCIIValues() {
        MatrixList matrix = new MatrixList(new int[][]{
                {72, 69, 76, 76}, // HELL
                {79, 32, 87, 79}, // O WO
                {82, 76, 68, 33}  // RLD!
        });
        assertEquals(87, matrix.findMax(), "Should find highest ASCII value");
    }

    @Test
    public void testYearDates() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1999, 2000, 2001},
                {2010, 2020, 2023},
                {2024, 2025, 2030}
        });
        assertEquals(2030, matrix.findMax(), "Should find future year");
    }

    @Test
    public void testChessboardCoordinates() {
        MatrixList matrix = new MatrixList(new int[][]{
                {11, 12, 13, 14, 15, 16, 17, 18},  // 1st rank
                {21, 22, 23, 24, 25, 26, 27, 28},  // 2nd rank
                {31, 32, 33, 34, 35, 36, 37, 38}   // 3rd rank
        });
        assertEquals(38, matrix.findMax(), "Should find highest coordinate");
    }

    @Test
    public void testColorRGBValues() {
        MatrixList matrix = new MatrixList(new int[][]{
                {255, 0, 0},    // Red
                {0, 255, 0},    // Green
                {0, 0, 255}     // Blue
        });
        assertEquals(255, matrix.findMax(), "Should find max color value");
    }

    @Test
    public void testIPAddressParts() {
        MatrixList matrix = new MatrixList(new int[][]{
                {192, 168, 0, 1},    // Common local IP
                {10, 0, 0, 1},       // Private network
                {127, 0, 0, 1}       // Localhost
        });
        assertEquals(192, matrix.findMax(), "Should find highest IP octet");
    }

    @Test
    public void testMusicNotes() {
        // Using MIDI note numbers: middle C = 60, C#=61, etc.
        MatrixList matrix = new MatrixList(new int[][]{
                {60, 62, 64, 65}, // C D E F
                {61, 69, 71, 72}, // G A B C
                {64, 67, 72, 74}  // E G B D
        });
        assertEquals(2, matrix.howManyX(64), "Should count occurrences of note E");
        assertEquals(74, matrix.findMax(), "Should find highest note");
    }

    @Test
    public void testPlayingCards() {
        // Representing cards: Ace=1, Jack=11, Queen=12, King=13, Suits: Hearts=100, Diamonds=200, Clubs=300, Spades=400
        MatrixList matrix = new MatrixList(new int[][]{
                {113, 212, 311}, // King Hearts, Queen Diamonds, Jack Clubs
                {401, 102, 203}, // Ace Spades, 2 Hearts, 3 Diamonds
                {304, 405, 106}  // 4 Clubs, 5 Spades, 6 Hearts
        });
        assertEquals(1, matrix.howManyX(113), "Should find King of Hearts");
        assertEquals(405, matrix.findMax(), "Should find highest card value");
    }

    @Test
    public void testPalindromicNumbers() {
        MatrixList matrix = new MatrixList(new int[][]{
                {11, 22, 33},
                {101, 111, 121},
                {1001, 2002, 3003}
        });
        assertEquals(1, matrix.howManyX(2002), "Should find specific palindrome");
        assertEquals(3003, matrix.findMax(), "Should find largest palindrome");
    }

    @Test
    public void pointerToNull() {
        MatrixList matrix = new MatrixList(new int[][]{
                {}
        });
        assertEquals(0, matrix.howManyX(2002), "_m00 is pointing to null");
        assertEquals(Integer.MIN_VALUE, matrix.findMax(), "There is no numbers in matrix");
    }

    @Test
    public void testToStringEmoji() {
        // Using numbers that correspond to emoji unicode points for fun
        MatrixList matrix = new MatrixList(new int[][]{
                {128516, 128517, 128518},  // Different smile emojis
                {128151, 128152, 128153}   // Different heart emojis
        });
        String expected = "128516\t128517\t128518\n128151\t128152\t128153\n";
        assertEquals(expected, matrix.toString(), "Should properly format emoji numbers");
    }

    @Test
    public void testToStringPhoneNumber() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 8, 0, 0},
                {5, 5, 5, 1},
                {2, 3, 4, 5}
        });
        String expected = "1\t8\t0\t0\n5\t5\t5\t1\n2\t3\t4\t5\n";
        assertEquals(expected, matrix.toString(), "Should format phone number digits correctly");
        // Test getting individual digits
        assertEquals(5, matrix.getData_i_j(1, 0), "Should get first digit of second row");
        assertEquals(5, matrix.getData_i_j(2, 3), "Should get last digit");
    }

    @Test
    public void testSetDataChessboardMoves() {
        MatrixList matrix = new MatrixList(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        // Simulate knight moves (represented by move number)
        matrix.setData_i_j(1, 0, 0);  // Starting position
        matrix.setData_i_j(2, 2, 1);  // Knight's first move
        matrix.setData_i_j(3, 1, 3);  // Knight's second move

        assertEquals(1, matrix.getData_i_j(0, 0), "Should get starting position");
        assertEquals(2, matrix.getData_i_j(2, 1), "Should get first move");
        assertEquals(3, matrix.getData_i_j(1, 3), "Should get second move");
        assertEquals(0, matrix.getData_i_j(3, 3), "Should get second move");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(3, 99), "Invalid");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(33, 99), "Invalid");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(33, 2), "Invalid");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(2, -1), "Invalid");
    }

    @Test
    public void testToStringCalendar() {
        // Representing a month calendar (0 for empty days)
        MatrixList matrix = new MatrixList(new int[][]{
                {0, 0, 1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24, 25, 26},
                {27, 28, 29, 30, 31, 0, 0}
        });
        String expected = """
                0\t0\t1\t2\t3\t4\t5
                6\t7\t8\t9\t10\t11\t12
                13\t14\t15\t16\t17\t18\t19
                20\t21\t22\t23\t24\t25\t26
                27\t28\t29\t30\t31\t0\t0
                """;
        assertEquals(expected, matrix.toString(), "Should format calendar layout correctly");
    }

    @Test
    public void testSetDataTemperatureMap() {
        MatrixList matrix = new MatrixList(new int[][]{
                {20, 21, 22},
                {21, 22, 23},
                {22, 23, 24}
        });

        // Simulate temperature changes
        matrix.setData_i_j(25, 1, 1);  // Hot spot in center
        matrix.setData_i_j(19, 0, 0);  // Cold spot in corner

        assertEquals(25, matrix.getData_i_j(1, 1), "Should get updated center temperature");
        assertEquals(19, matrix.getData_i_j(0, 0), "Should get updated corner temperature");
    }

    @Test
    public void testSetDataPingPongScore() {
        MatrixList matrix = new MatrixList(new int[][]{
                {0, 0, 0},
                {0, 0, 0}
        });

        // Simulate ping pong game scoring
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matrix.setData_i_j((i + 1) * (j + 1), i, j);
            }
        }

        assertEquals(1, matrix.getData_i_j(0, 0), "Should get player 1 first set");
        assertEquals(6, matrix.getData_i_j(1, 2), "Should get player 2 final set");
    }

    @Test
    public void testInvalidPositions() {
        MatrixList matrix = new MatrixList(new int[][]{{1}});

        // Test invalid gets
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(-1, 0), "Should handle negative row");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, -1), "Should handle negative column");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(1, 0), "Should handle out of bounds row");
        assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, 1), "Should handle out of bounds column");

        // Test invalid sets (shouldn't throw exception)
        matrix.setData_i_j(100, -1, 0);
        matrix.setData_i_j(100, 0, -1);
        matrix.setData_i_j(100, 1, 0);
        matrix.setData_i_j(100, 0, 1);

        // Verify original value unchanged
        assertEquals(1, matrix.getData_i_j(0, 0), "Should maintain original value after invalid sets");
    }

    @Test
    public void testToStringBinaryMatrix() {
        MatrixList matrix = new MatrixList(new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        });
        String expected = "0\t1\t0\n1\t1\t1\n0\t1\t0\n";
        assertEquals(expected, matrix.toString(), "Should format binary cross pattern correctly");
    }

    @Test
    public void testSetDataPixelArt() {
        // Create a simple pixel art (heart shape)
        MatrixList matrix = new MatrixList(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });

        // Draw heart shape with 1s
        matrix.setData_i_j(1, 1, 1);
        matrix.setData_i_j(1, 1, 3);
        matrix.setData_i_j(1, 2, 0);
        matrix.setData_i_j(1, 2, 2);
        matrix.setData_i_j(1, 2, 4);
        matrix.setData_i_j(1, 3, 1);
        matrix.setData_i_j(1, 3, 3);
        matrix.setData_i_j(1, 4, 2);

        assertEquals(1, matrix.getData_i_j(4, 2), "Should get bottom point of heart");
        assertEquals(1, matrix.getData_i_j(2, 2), "Should get center of heart");
    }

    @Test
    public void testModificationTracking() {
        MatrixList matrix = new MatrixList(new int[][]{{1, 2}, {3, 4}});
        String originalString = matrix.toString();

        // Modify and verify each position
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int originalValue = matrix.getData_i_j(i, j);
                matrix.setData_i_j(originalValue * 2, i, j);
                assertEquals(originalValue * 2, matrix.getData_i_j(i, j),
                        "Should get updated value at position " + i + "," + j);
            }
        }

        assertNotEquals(originalString, matrix.toString(), "String representation should change after modifications");
    }
    @Test
    public void testLargeSortedMatrix2() {
        // בניית מטריצה ממוינת 7x7
        //  1  2  3  4  5  6  7
        //  2  3  4  5  6  7  8
        //  3  4  5  6  7  8  9
        //  4  5  6  7  8  9 10
        //  5  6  7  8  9 10 11
        //  6  7  8  9 10 11 12
        //  7  8  9 10 11 12 13

        int size = 7;
        int[][] mat = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // ניצור מטריצה כך שערך בכל תא הוא (i + j + 1)
                mat[i][j] = i + j + 1;
            }
        }

        MatrixList matrix = new MatrixList(mat);

        // בדיקה של findMax
        assertEquals(13, matrix.findMax(), "Max should be 13 in a 7x7 ascending matrix");

        // בדיקה של howManyX - המספר 5 אמור להופיע פעמיים: ב-(2,3), (3,2) [או תלוי בספירה]
        // אבל צריך לשים לב שהמטריצה עלתה באופן הבא:
        //   1,2,3,4,5,6,7
        //   2,3,4,5,6,7,8
        //   3,4,5,6,7,8,9
        //   ...
        // ערך 5 מופיע לראשונה בשורה 0, עמודה 4. ואז בשורה 1, עמודה 3... וכן הלאה.
        // נספור "ידנית" כמה 5 יש:
        //   (0,4) => 5
        //   (1,3) => 5
        //   (2,2) => 5
        //   (3,1) => 5
        //   (4,0) => 5
        // יש בעצם 5 מופעים של 5.

        assertEquals(5, matrix.howManyX(5), "Value 5 should appear 5 times in the matrix");

        // בדיקה של ערך לא קיים
        assertEquals(0, matrix.howManyX(99), "99 does not appear in the matrix");
    }

    /**
     * בדיקה שמחזקת את השימוש ב-setData_i_j עבור כמה תאים במטריצה
     * ובודקת אם נעשה עדכון נכון (קריאה מחזירה את הערכים החדשים).
     */
    @Test
    public void testMultiSetData() {
        MatrixList matrix = new MatrixList(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        // עדכון של כמה תאים:
        matrix.setData_i_j(10, 0, 0); // פינה עליונה-שמאלית
        matrix.setData_i_j(50, 1, 1); // מרכז
        matrix.setData_i_j(90, 2, 2); // פינה תחתונה-ימנית

        // וידוא שהערכים עודכנו
        assertEquals(10, matrix.getData_i_j(0, 0), "Should update top-left corner");
        assertEquals(50, matrix.getData_i_j(1, 1), "Should update center");
        assertEquals(90, matrix.getData_i_j(2, 2), "Should update bottom-right corner");

        // וידוא שערכים אחרים לא נפגעו
        assertEquals(2, matrix.getData_i_j(0, 1));
        assertEquals(4, matrix.getData_i_j(1, 0));
        assertEquals(8, matrix.getData_i_j(2, 1));
    }

    /**
     * בדיקת מטריצה שבה כל הערכים זהים בגודל מעט גדול יותר (4x4),
     * בדיקת מקסימום ובדיקת התנהגות setData_i_j.
     */
    @Test
    public void testBiggerMatrixWithIdenticalElements() {
        int[][] mat = {
                {7, 7, 7, 7},
                {7, 7, 7, 7},
                {7, 7, 7, 7},
                {7, 7, 7, 7}
        };
        MatrixList matrix = new MatrixList(mat);

        // אמור להחזיר 7 כמקסימלי
        assertEquals(7, matrix.findMax(), "Max should be 7 in a uniform 4x4 matrix");

        // נבצע שינוי באלכסון
        matrix.setData_i_j(9, 0, 0);
        matrix.setData_i_j(10, 1, 1);
        matrix.setData_i_j(11, 2, 2);
        matrix.setData_i_j(12, 3, 3);

        // כעת המקס צריך להיות 12
        assertEquals(12, matrix.findMax(), "After updates, max should be 12");
        // בדיקה נקודתית
        assertEquals(9, matrix.getData_i_j(0, 0));
        assertEquals(10, matrix.getData_i_j(1, 1));
        assertEquals(11, matrix.getData_i_j(2, 2));
        assertEquals(12, matrix.getData_i_j(3, 3));
    }

    /**
     * בדיקה של מטריצה יחידה (1x1) המתחילה עם ערך שלילי, ואנו בודקים גם
     * החלפה לערך אחר.
     */
    @Test
    public void testSingleElementNegative() {
        MatrixList matrix = new MatrixList(new int[][]{{-42}});

        // מקס אמור להיות -42
        assertEquals(-42, matrix.findMax(), "Single negative element should be the max (and only) value");
        // בדיקת עדכון
        matrix.setData_i_j(-100, 0, 0);
        assertEquals(-100, matrix.getData_i_j(0, 0), "Should update single cell matrix");
        assertEquals(-100, matrix.findMax(), "Max is now the updated negative value");
    }

    /**
     * בדיקת מטריצה ריקה מבחינת השורות (בהנחה שיש העמדה כמו { {}, {}, {} })
     * או שאין בכלל עמודות. מוודאים שמטופל כהלכה.
     */
    @Test
    public void testMultipleEmptyRows() {
        int[][] mat = {
                {},
                {},
                {}
        };
        MatrixList matrix = new MatrixList(mat);
        // מצפים ל-m00=null
        assertEquals("", matrix.toString(), "No data means empty string");
        assertEquals(Integer.MIN_VALUE, matrix.findMax(), "Empty matrix => min value as max");
        assertEquals(0, matrix.howManyX(100), "No occurrences in an empty matrix");
    }

    /**
     * Test for a large sorted matrix where both rows and columns are strictly increasing.
     */
    @Test
    public void testLargeSortedMatrix() {
        int[][] mat = {
                {1, 4, 7, 10},
                {2, 5, 8, 11},
                {3, 6, 9, 12}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(12, matrix.findMax(), "Max should be 12 in a strictly increasing matrix.");
        assertEquals(1, matrix.howManyX(5), "Value 5 should appear exactly once in the matrix.");
        assertEquals(0, matrix.howManyX(13), "Value 13 should not exist in the matrix.");
    }

    /**
     * Test for single row matrix with strictly increasing values.
     */
    @Test
    public void testSingleRowStrictlyIncreasingMatrix() {
        int[][] mat = {{1, 3, 5, 7, 9}};
        MatrixList matrix = new MatrixList(mat);

        assertEquals(9, matrix.findMax(), "Max should be the last element in the row.");
        assertEquals(1, matrix.howManyX(5), "Value 5 should appear exactly once.");
        assertEquals(0, matrix.howManyX(2), "Value 2 should not exist as the matrix is strictly increasing.");
    }

    /**
     * Test for single column matrix with strictly increasing values.
     */
    @Test
    public void testSingleColumnStrictlyIncreasingMatrix() {
        int[][] mat = {
                {1},
                {3},
                {5},
                {7},
                {9}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(9, matrix.findMax(), "Max should be the last element in the column.");
        assertEquals(1, matrix.howManyX(7), "Value 7 should appear exactly once.");
        assertEquals(0, matrix.howManyX(4), "Value 4 should not exist as the matrix is strictly increasing.");
    }

    /**
     * Test for matrix where values increase diagonally without duplicates.
     */
    @Test
    public void testDiagonalIncreasingMatrix() {
        int[][] mat = {
                {1, 3, 5},
                {2, 4, 6},
                {3, 5, 7}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(7, matrix.findMax(), "Max should be the bottom-right element.");
        assertEquals(1, matrix.howManyX(4), "Value 4 should appear exactly once.");
        assertEquals(0, matrix.howManyX(8), "Value 8 should not exist in the matrix.");
    }

    /**
     * Test for matrix with large values, ensuring the matrix is strictly increasing.
     */
    @Test
    public void testLargeStrictlyIncreasingMatrix() {
        int[][] mat = {
                {100, 200, 300},
                {150, 250, 350},
                {175, 275, 400}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(400, matrix.findMax(), "Max should be 400.");
        assertEquals(1, matrix.howManyX(250), "Value 250 should appear exactly once.");
        assertEquals(0, matrix.howManyX(500), "Value 500 should not exist in the matrix.");
    }

    /**
     * Test for edge cases where values are at the boundary of Integer.MIN_VALUE and Integer.MAX_VALUE.
     * The matrix remains strictly increasing.
     */
    @Test
    public void testMatrixWithIntegerBoundaries() {
        int[][] mat = {
                {Integer.MIN_VALUE, -100, 0},
                {1, 50, 100},
                {150, 200, Integer.MAX_VALUE}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Max should be Integer.MAX_VALUE.");
        assertEquals(1, matrix.howManyX(-100), "Value -100 should appear exactly once.");
        assertEquals(0, matrix.howManyX(999), "Value 999 should not exist in the matrix.");
    }

    /**
     * Test for matrix with very large values and large gaps between numbers.
     */
    @Test
    public void testMatrixWithLargeGaps() {
        int[][] mat = {
                {10, 100, 1000},
                {20, 200, 2000},
                {30, 300, 3000}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(3000, matrix.findMax(), "Max should be 3000.");
        assertEquals(1, matrix.howManyX(200), "Value 200 should appear exactly once.");
        assertEquals(0, matrix.howManyX(1500), "Value 1500 should not exist in the matrix.");
    }

    /**
     * Test for matrix with only two rows, ensuring strict increase both in rows and columns.
     */
    @Test
    public void testTwoRowStrictMatrix() {
        int[][] mat = {
                {1, 3, 5, 7},
                {2, 4, 6, 8}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(8, matrix.findMax(), "Max should be 8.");
        assertEquals(1, matrix.howManyX(4), "Value 4 should appear exactly once.");
        assertEquals(0, matrix.howManyX(9), "Value 9 should not exist in the matrix.");
    }

    /**
     * Test for matrix with negative and positive values, sorted strictly.
     */
    @Test
    public void testNegativeAndPositiveMatrix() {
        int[][] mat = {
                {-10, -5, 0},
                {-8, -3, 2},
                {-6, -1, 4}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(4, matrix.findMax(), "Max should be 4.");
        assertEquals(1, matrix.howManyX(-5), "Value -5 should appear exactly once.");
        assertEquals(0, matrix.howManyX(1), "Value 1 should not exist in the matrix.");
    }

    /**
     * Test for matrix with sequential odd numbers, strictly increasing.
     */
    @Test
    public void testOddNumberMatrix() {
        int[][] mat = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(17, matrix.findMax(), "Max should be 17.");
        assertEquals(1, matrix.howManyX(9), "Value 9 should appear exactly once.");
        assertEquals(0, matrix.howManyX(8), "Value 8 should not exist in the matrix.");
    }

    /**
     * Test for matrix with even numbers only, strictly increasing.
     */
    @Test
    public void testEvenNumberMatrix() {
        int[][] mat = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(18, matrix.findMax(), "Max should be 18.");
        assertEquals(1, matrix.howManyX(10), "Value 10 should appear exactly once.");
        assertEquals(0, matrix.howManyX(5), "Value 5 should not exist in the matrix.");
    }

    /**
     * Test for matrix with decimal-like integers (multiples of 10), strictly increasing.
     */
    @Test
    public void testDecimalLikeMatrix() {
        int[][] mat = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(90, matrix.findMax(), "Max should be 90.");
        assertEquals(1, matrix.howManyX(60), "Value 60 should appear exactly once.");
        assertEquals(0, matrix.howManyX(25), "Value 25 should not exist in the matrix.");
    }

    /**
     * Test for matrix representing a triangular number sequence, strictly increasing.
     */
    @Test
    public void testTriangularNumbersMatrix() {
        int[][] mat = {
                {1, 3, 6},
                {10, 15, 21},
                {28, 36, 45}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(45, matrix.findMax(), "Max should be 45.");
        assertEquals(1, matrix.howManyX(21), "Value 21 should appear exactly once.");
        assertEquals(0, matrix.howManyX(5), "Value 5 should not exist in the matrix.");
    }

    /**
     * Test for matrix with consecutive squares of numbers, strictly increasing.
     */
    @Test
    public void testSquareNumbersMatrix() {
        int[][] mat = {
                {1, 4, 9},
                {16, 25, 36},
                {49, 64, 81}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(81, matrix.findMax(), "Max should be 81.");
        assertEquals(1, matrix.howManyX(36), "Value 36 should appear exactly once.");
        assertEquals(0, matrix.howManyX(50), "Value 50 should not exist in the matrix.");
    }

    /**
     * Test for matrix with Fibonacci numbers, ensuring strict increase.
     */
    @Test
    public void testStrictFibonacciMatrix() {
        int[][] mat = {
                {1, 2, 3},
                {5, 8, 13},
                {21, 34, 55}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(55, matrix.findMax(), "Max should be 55.");
        assertEquals(1, matrix.howManyX(8), "Value 8 should appear exactly once.");
        assertEquals(0, matrix.howManyX(4), "Value 4 should not exist in the matrix.");
    }

    /**
     * Test for matrix representing powers of two, strictly increasing.
     */
    @Test
    public void testPowersOfTwoMatrix() {
        int[][] mat = {
                {2, 4, 8},
                {16, 32, 64},
                {128, 256, 512}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(512, matrix.findMax(), "Max should be 512.");
        assertEquals(1, matrix.howManyX(64), "Value 64 should appear exactly once.");
        assertEquals(0, matrix.howManyX(3), "Value 3 should not exist in the matrix.");
    }

    /**
     * Test for a matrix with a single row but many columns.
     */
    @Test
    public void testSingleRowManyColumns() {
        int[][] mat = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(10, matrix.findMax(), "Max should be 10 in a single-row matrix.");
        assertEquals(0, matrix.howManyX(11), "Value 11 should not exist in the matrix.");
    }

    /**
     * Test for a matrix with a single column but many rows.
     */
    @Test
    public void testSingleColumnManyRows() {
        int[][] mat = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(10, matrix.findMax(), "Max should be 10 in a single-column matrix.");
        assertEquals(1, matrix.howManyX(7), "Value 7 should appear exactly once.");
    }

    /**
     * Test for matrix with only two elements.
     */
    @Test
    public void testTwoElementMatrix() {
        int[][] mat = {
                {1, 2}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(2, matrix.findMax(), "Max should be 2 in a two-element matrix.");
        assertEquals(1, matrix.howManyX(1), "Value 1 should appear exactly once.");
        assertEquals(0, matrix.howManyX(3), "Value 3 should not exist in the matrix.");
    }

    /**
     * Test for a matrix with minimum and maximum integer values.
     */
    @Test
    public void testMatrixWithIntMinMax() {
        int[][] mat = {
                {Integer.MIN_VALUE, 0},
                {1, Integer.MAX_VALUE}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Max should be Integer.MAX_VALUE.");
        assertEquals(1, matrix.howManyX(Integer.MIN_VALUE), "Should correctly count Integer.MIN_VALUE.");
        assertEquals(0, matrix.howManyX(100), "Value 100 should not exist in the matrix.");
    }

    /**
     * Test for an empty matrix with only null references.
     */
    @Test
    public void testCompletelyEmptyMatrix() {
        int[][] maSSt = {};
        MatrixList matrix = new MatrixList(maSSt);

        assertEquals(Integer.MIN_VALUE, matrix.findMax(), "Empty matrix should return Integer.MIN_VALUE as max.");
        assertEquals(0, matrix.howManyX(1), "Empty matrix should return 0 occurrences for any value.");
        assertEquals("", matrix.toString(), "Empty matrix should return an empty string.");
    }

    /**
     * Test for matrix with one element being updated multiple times.
     */
    @Test
    public void testRepeatedUpdatesOnSingleElement() {
        MatrixList matrix = new MatrixList(new int[][]{{5}});

        matrix.setData_i_j(10, 0, 0);
        assertEquals(10, matrix.getData_i_j(0, 0), "Element should be updated to 10.");
        matrix.setData_i_j(20, 0, 0);
        assertEquals(20, matrix.getData_i_j(0, 0), "Element should be updated to 20.");
        matrix.setData_i_j(-5, 0, 0);
        assertEquals(-5, matrix.getData_i_j(0, 0), "Element should be updated to -5.");

        assertEquals(-5, matrix.findMax(), "Max should be -5 after final update.");
    }

    /**
     * Test for matrix where all numbers are consecutive, ensuring no duplicates.
     */
    @Test
    public void testConsecutiveNumbersNoDuplicates() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixList matrix = new MatrixList(mat);

        assertEquals(9, matrix.findMax(), "Max should be 9 in a consecutive numbers matrix.");
        assertEquals(1, matrix.howManyX(5), "Value 5 should appear exactly once.");
        assertEquals(0, matrix.howManyX(10), "Value 10 should not exist in the matrix.");
    }

    /**
     * Test for matrix where the largest number is at the top-left corner (unusual for sorted matrices).
     */
    @Test
    public void testLargestNumberAtTopLeft() {
        int[][] mat = {
                {100, 90, 80},
                {70, 60, 50},
                {40, 30, 20}
        };
        MatrixList matrix = new MatrixList(mat);

        // זו לא מטריצה ממוינת בצורה רגילה, אבל נבדוק האם הקוד יכול להתמודד עם מבנה כזה.
        assertEquals(100, matrix.findMax(), "Max should be 100 even if it's in the top-left corner.");
        assertEquals(0, matrix.howManyX(110), "Value 110 should not exist in the matrix.");
    }
}
