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
public class MoveGenerator
{

    public static void init()
    {
        int i, j;

        //initializing all white pawn moves
        for (i = 8; i < 16; ++i)
        {
            white_pawn_moves[i] |= Board.squares[i + 8] | Board.squares[i + 16];
            //black_pawn_moves[64-i] = Board.squares[56-i] | Board.squares[48-i];
        }
        for (i = 16; i < 56; ++i)
        {
            white_pawn_moves[i] |= Board.squares[i + 8];
        }
        //initializing all black pawn moves
        for (i = 55; i > 47; --i)
        {
            black_pawn_moves[i] |= Board.squares[i - 8] | Board.squares[i - 16];
        }
        for (i = 47; i > 7; --i)
        {
            black_pawn_moves[i] |= Board.squares[i - 8];
        }
        //initializing all rook moves
        for (i = 0; i < 64; ++i)
        {
            for (j = 0; j < 64; ++j)
            {
                if (Board.n_rank[i] == Board.n_rank[j] || Board.n_file[i] == Board.n_file[j])
                {
                    rook_attacks[i] |= Board.squares[j];
                }
            }
        }
        //initializing all knight moves
        for (i = 0; i < 64; ++i)
        {
           if (Board.n_rank[i] >= 2 && Board.n_file[i] >=1)
           {
               knight_attacks[i] |= Board.squares[i-17];
           }
           if (Board.n_rank[i] >= 2 && Board.n_file[i] <=7)
           {
               knight_attacks[i] |= Board.squares[i-15];
           }
           if (Board.n_rank[i] >= 2 && Board.n_file[i] >=1)
           {
               knight_attacks[i] |= Board.squares[i-17];
           }
           //TO BE CONTINUED
        }
    }

    static void generate_possible_moves()
    {
        int from_square, to_square;
        Move move = new Move();
        long targets;
        long current_piece;
        long free_squares = ~Bitboards.occupied_squares;

        if (Board.white_is_on_move)
        {
            current_piece = Bitboards.w_pawns;
            targets = ~Bitboards.white_pieces;
            while (current_piece != 0)
            {
                from_square = Bitboards.bitScanForwardDeBruijn64(current_piece);
                move.set_from_square(from_square);

            }
        }
    }

    private static boolean is_valid_square(int n)
    {
        return (n >= 0 && n < 64);
    }

    private static long[] white_pawn_moves = new long[64];
    private static long[] black_pawn_moves = new long[64];
    private static long[] white_pawn_captures = new long[64];
    private static long[] black_pawn_captures = new long[64];
    private static long[] rook_attacks = new long[64];
    private static long[] knight_attacks = new long[64];
    private static long[] bishop_attacks = new long[64];
    private static long[] queen_attacks = new long[64];
    private static long[] king_attacks = new long[64];
    //private static long [] white_rook_attacks = new long [64];
    //private static long [] black_rook_attacks = new long [64];
    //private static long [] white_knight_attacks = new long [64];
    //private static long [] black_knight_attacks = new long [64];
    //private static long [] white_bishop_attacks = new long [64];
    //private static long [] black_bishop_attacks = new long [64];
    //private static long [] white_queen_attacks = new long [64];
    //private static long [] black_queen_attacks = new long [64];
    //private static long [] white_king_attacks = new long [64];
    //private static long [] black_king_attacks = new long [64];


}
