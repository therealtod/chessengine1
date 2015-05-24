package chessengine1;

import java.util.ArrayList;

/**
 *
 * @author tod
 */
public class Position
{
    static char [] piece_in_square = new char [64];
    //Move [] possiblemoves = new Move [Bitboards.max_move_buffer_size];
    static ArrayList possiblemoves = new ArrayList <Move>();
    static long w_pawns = 0L, w_rooks = 0L, w_knights = 0L, w_bishops = 0L,
            w_queens = 0L, w_king = 0L, b_pawns = 0L, b_rooks = 0L,
            b_knights = 0L, b_bishops = 0L, b_queens = 0L, b_king = 0L;
    static long white_pieces = 0L, black_pieces = 0L, occupied_squares = 0L, ep_square=0L;

}
