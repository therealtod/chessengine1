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
            white_pawn_moves[i] |= Board.squares[i + 8];
            white_pawn_double_moves[i] |= Board.squares[i + 16];
            //black_pawn_moves[64-i] = Board.squares[56-i] | Board.squares[48-i];
        }
        for (i = 16; i < 56; ++i)
        {
            white_pawn_moves[i] |= Board.squares[i + 8];
        }
        //initializing all black pawn moves
        for (i = 55; i > 47; --i)
        {
            black_pawn_moves[i] |= Board.squares[i - 8];
            black_pawn_double_moves[i] |= Board.squares[i - 16];
        }
        for (i = 47; i > 7; --i)
        {
            black_pawn_moves[i] |= Board.squares[i - 8];
        }
        //initializing all white pawn captures
        for (i = 8; i < 56; ++i)
        {
            if (Board.n_file[i] > 1)
            {
                white_pawn_captures[i] |= Board.squares[i + 7];
            }

            if (Board.n_file[i] < 8)
            {
                white_pawn_captures[i] |= Board.squares[i + 9];
            }
        }
        for (i = 55; i > 7; --i)
        {
            if (Board.n_file[i] > 1)
            {
                black_pawn_captures[i] |= Board.squares[i - 9];
            }
            if (Board.n_file[i] < 8)
            {
                black_pawn_captures[i] |= Board.squares[i - 7];
            }
        }

        //initializing all rook moves
        for (i = 0; i < 64; ++i)
        {
            for (j = 0; j < 64; ++j)
            {
                if ((Board.n_rank[i] == Board.n_rank[j] || Board.n_file[i] == Board.n_file[j]) && i != j)
                {
                    rook_attacks[i] |= Board.squares[j];
                }
            }
            //rook_attacks [i] -= Board.squares[i];
        }

        //initializing all knight moves
        for (i = 0; i < 64; ++i)
        {
            if (Board.n_rank[i] > 2 && Board.n_file[i] > 1)
            {
                knight_attacks[i] |= Board.squares[i - 17];
            }
            if (Board.n_rank[i] > 2 && Board.n_file[i] < 8)
            {
                knight_attacks[i] |= Board.squares[i - 15];
            }
            if (Board.n_rank[i] > 1 && Board.n_file[i] > 2)
            {
                knight_attacks[i] |= Board.squares[i - 10];
            }
            if (Board.n_rank[i] > 1 && Board.n_file[i] < 7)
            {
                knight_attacks[i] |= Board.squares[i - 6];
            }
            if (Board.n_rank[i] < 8 && Board.n_file[i] > 2)
            {
                knight_attacks[i] |= Board.squares[i + 6];
            }
            if (Board.n_rank[i] < 8 && Board.n_file[i] < 7)
            {
                knight_attacks[i] |= Board.squares[i + 10];
            }
            if (Board.n_rank[i] < 7 && Board.n_file[i] > 1)
            {
                knight_attacks[i] |= Board.squares[i + 15];
            }
            if (Board.n_rank[i] < 7 && Board.n_file[i] < 8)
            {
                knight_attacks[i] |= Board.squares[i + 17];
            }
        }

        for (i = 0; i < 64; ++i)
        {
            System.out.println("A knight on " + Board.square_names[i] + " attacks these squares");
            Bitboards.display(knight_attacks[i]);
        }

        //initializing all bishop moves
        for (i = 0; i < 64; ++i)
        {
            int rank = Board.n_rank[i];
            int file = Board.n_file[i];
            //TO BE CONTINUED
        }
    }

    static void generate_possible_moves()
    {
        int from_square, to_square;
        Move move = new Move();
        long targets;
        long candidate_destin;
        long current_piece;
        long free_squares = ~Position.occupied_squares;

        if (Board.white_is_on_move)
        {
            move.set_piece(Pieces.white_pawn);
            current_piece = Position.w_pawns;
            targets = ~Position.white_pieces;
            while (current_piece != 0)
            {
                from_square = Bitboards.bitScanForwardDeBruijn64(current_piece);
                move.set_from_square(from_square);
                //adding pawn advances
                candidate_destin = white_pawn_moves[from_square] & free_squares;
                if (candidate_destin != 0 && Board.n_rank[from_square] == 2)
                {
                    candidate_destin |= white_pawn_double_moves[from_square];
                }
                //adding captures
                candidate_destin |= white_pawn_captures[from_square]
                        & Position.black_pieces;
                //now iterating on candidate destination to generate possible moves
                while (candidate_destin != 0)
                {
                    to_square
                            = Bitboards.bitScanForwardDeBruijn64(candidate_destin);
                    move.set_to_square(to_square);
                    move.set_capured_piece(Position.piece_in_square[to_square]);
                    if ((Board.n_rank[to_square]) == 8)
                    {
                        move.set_promoting_piece(Pieces.white_queen);
                        Position.possiblemoves.add(move);
                        move.set_promoting_piece(Pieces.white_rook);
                        Position.possiblemoves.add(move);
                        move.set_promoting_piece(Pieces.white_bishop);
                        Position.possiblemoves.add(move);
                        move.set_promoting_piece(Pieces.white_knight);
                        Position.possiblemoves.add(move);
                        move.set_promoting_piece(Pieces.blank);
                    } else
                    {

                        Position.possiblemoves.add(move);
                    }
                    candidate_destin ^= Board.squares[to_square];
                }
                /*if (Position.ep_square != 0)
                 {
                 if (white_pawn_attacks[from_square] & Board.squares[])
                 }
                 */
                current_piece ^= Board.squares[from_square];
            }

            //WHITE KNIGHTS
            move.set_piece(Pieces.white_knight);
            current_piece = Position.w_knights;
            while (current_piece != 0)
            {
                from_square = Bitboards.bitScanForwardDeBruijn64(current_piece);
                move.set_from_square(from_square);
                candidate_destin = knight_attacks[from_square] & targets;
                while (candidate_destin != 0)
                {
                    to_square = 
                            Bitboards.bitScanForwardDeBruijn64(candidate_destin);
                    move.set_to_square(to_square);
                    move.set_capured_piece(Position.piece_in_square[to_square]);
                    Position.possiblemoves.add(move);
                    candidate_destin ^= Board.squares[to_square];

                }
                current_piece ^= Board.squares[from_square];
            }
            //
        }
    }

    private static boolean is_valid_square(int n)
    {
        return (n >= 0 && n < 64);
    }

    private static long[] white_pawn_moves = new long[64];
    private static long[] white_pawn_double_moves = new long[64];
    private static long[] black_pawn_moves = new long[64];
    private static long[] black_pawn_double_moves = new long[64];
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
