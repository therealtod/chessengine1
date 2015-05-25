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
    
    static String [] square_names =
    {
        "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1",
        "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
        "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
        "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
        "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
        "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
        "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
        "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"
        
    };
    

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



    static long[] squares = new long[64];
    static boolean white_is_on_move = true;
    
    static final int [][] board_index = 
    {
        {0,0,0,0,0,0,0,0},
        {0,0,1,2,3,4,5,6,7},
        {0,8,9,10,11,12,13,14,15},
        {0,16,17,18,19,20,21,22,23},
        {0,24,25,26,27,28,29,30,31},
        {0,32,33,34,35,36,37,38,39},
        {0,40,41,42,43,44,45,46,47},
        {0,48,49,50,51,52,53,54,55},
        {0,56,57,58,59,60,61,62,63}
        
    };
    
}
