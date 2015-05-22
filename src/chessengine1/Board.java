/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessengine1;

/**
 *
 * @author tod
 */
public class Board
{

    public static void init()
    {
        init_squares();
        //TODO
    }

    private static void init_squares()
    {
        long bit = 1L;
        for (int i = 0; i < 64; ++i)
        {
            squares[i] = bit << i;
        }

    }

    static int[] n_rank =
    {
        1, 1, 1, 1, 1, 1, 1, 1,
        2, 2, 2, 2, 2, 2, 2, 2,
        3, 3, 3, 3, 3, 3, 3, 3,
        4, 4, 4, 4, 4, 4, 4, 4,
        5, 5, 5, 5, 5, 5, 5, 5,
        6, 6, 6, 6, 6, 6, 6, 6,
        7, 7, 7, 7, 7, 7, 7, 7,
        8, 8, 8, 8, 8, 8, 8, 8
    };
    static int[] n_file =
    {
        1, 2, 3, 4, 5, 6, 7, 8,
        1, 2, 3, 4, 5, 6, 7, 8,
        1, 2, 3, 4, 5, 6, 7, 8,
        1, 2, 3, 4, 5, 6, 7, 8,
        1, 2, 3, 4, 5, 6, 7, 8,
        1, 2, 3, 4, 5, 6, 7, 8,
        1, 2, 3, 4, 5, 6, 7, 8,
        1, 2, 3, 4, 5, 6, 7, 8

    };
    
    static private final long deBruijn = 0x03f79d71b4cb0a89L;
    static private final int[] magicTable =
    {
        0, 1, 48, 2, 57, 49, 28, 3,
        61, 58, 50, 42, 38, 29, 17, 4,
        62, 55, 59, 36, 53, 51, 43, 22,
        45, 39, 33, 30, 24, 18, 12, 5,
        63, 47, 56, 27, 60, 41, 37, 16,
        54, 35, 52, 21, 44, 32, 23, 11,
        46, 26, 40, 15, 34, 20, 31, 10,
        25, 14, 19, 9, 13, 8, 7, 6,
    };

    static public int bitScanForwardDeBruijn64(long b)
    {
        int idx = (int) (((b & -b) * deBruijn) >>> 58);
        return magicTable[idx];
    }
    //CONSTANTS
    static final long FILE_A = 72340172838076673L;
    static final long FILE_H = -9187201950435737472L;
    static final long FILE_AB = 217020518514230019L;
    static final long FILE_GH = -4557430888798830400L;
    static final long RANK_1 = -72057594037927936L;
    static final long RANK_4 = 1095216660480L;
    static final long RANK_5 = 4278190080L;
    static final long RANK_8 = 255L;
    static final long CENTRE = 103481868288L;
    static final long EXTENDED_CENTRE = 66229406269440L;
    static final long KING_SIDE = -1085102592571150096L;
    static final long QUEEN_SIDE = 1085102592571150095L;
    static final long KING_B7 = 460039L;
    static final long KNIGHT_C6 = 43234889994L;

    static long white_targets;
    static long black_targets;
    static long white_pieces;
    static long black_pieces;

    static long[] squares = new long[64];
    static boolean white_is_on_move = true;
}
