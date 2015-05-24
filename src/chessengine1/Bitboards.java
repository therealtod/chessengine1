package chessengine1;

import static chessengine1.Position.*;
import static chessengine1.Board.*;
import static chessengine1.MoveGenerator.sliding_attacks;

/**
 *
 * @author tod
 */
public class Bitboards
{
    public static void init_char_bitsets ()
    {
        onebyte_bitset[0] = 1;
        for (int i=1; i<8; i++)
        {
            onebyte_bitset[i] =  (onebyte_bitset[i-1]) << 1;
        }
    }
    
    public static void init_sliding_attacks ()
    {
        int state6bit, state8bit,attack8bit;
        int square, slide;
        for (square=0; square <8; ++ square)
        {
            for (state6bit =0; state6bit <64 ; ++state6bit)
            {
                state8bit = state6bit << 1;
                attack8bit = 0;
                if(square <7)
                {
                    attack8bit |= onebyte_bitset[square+1];
                }
                slide = square+2;
                while (slide <8)
                {
                    if (((~state8bit) & onebyte_bitset[slide-1] )!= 0)
                    {
                        attack8bit |= onebyte_bitset[slide];
                    }
                    else break;
                    ++slide;
                }
                if (square > 0)
                {
                    attack8bit |= onebyte_bitset[square -1];
                }
                slide = square -2;
                while (slide >= 0)
                {
                    if(((~state8bit & onebyte_bitset[slide +1])) != 0)
                    {
                        attack8bit |= onebyte_bitset[slide];
                    }
                    else break;
                    --slide;
                }
                sliding_attacks[square][state6bit] = attack8bit;
            }
        }
        
    }
    public static void init_masks()
    {
        int file, rank, square, diag_a8h1, diag_a1h8;
        for (file = 1; file < 9; ++file)
        {
            for (rank = 1; rank < 9; ++rank)
            {
                rank_mask[board_index[file][rank]] = squares[board_index[2][rank]]
                        | squares[board_index[3][rank]]
                        | squares[board_index[4][rank]]
                        | squares[board_index[5][rank]]
                        | squares[board_index[6][rank]]
                        | squares[board_index[7][rank]];

                file_mask[board_index[file][rank]] = squares[board_index[file][2]]
                        | squares[board_index[file][3]]
                        | squares[board_index[file][4]]
                        | squares[board_index[file][5]]
                        | squares[board_index[file][6]]
                        | squares[board_index[file][7]];

                diag_a8h1 = file + rank;
                diag_a8h1_mask[board_index[file][rank]] = 0x0L;
                if (diag_a8h1 < 10)
                {
                    for (square = 2; square < diag_a8h1; ++square)
                    {
                        diag_a8h1_mask[board_index[file][rank]]
                                |= squares[board_index[square][diag_a8h1 - square]];
                    }
                } else
                {
                    for (square = 2; square < 17 - diag_a8h1; ++square)
                    {
                        diag_a8h1_mask[board_index[file][rank]]
                                |= squares[board_index[diag_a8h1 + square - 9][9 - square]];
                    }
                }

                diag_a1h8 = file - rank;
                diag_a1h8_mask[board_index[file][rank]] = 0x0L;
                if (diag_a1h8 > -1)
                {
                    for (square = 2; square < 8 - diag_a1h8; ++square)
                    {
                        diag_a1h8_mask[board_index[file][rank]]
                                |= squares[board_index[diag_a1h8 + square][square]];
                    }
                } else
                {
                    for (square = 2; square < 8 + diag_a1h8; ++square)
                    {
                        diag_a1h8_mask[board_index[file][rank]]
                                |= squares[board_index[square][square - diag_a1h8]];
                    }
                }
            }

        }
    }

    public static void init_magic_numbers()
    {
        int file, rank, diag_a8h1, diag_a1h8;
        for (file = 1; file < 9; ++file)
        {
            for (rank = 1; rank < 9; ++rank)
            {
                diag_a8h1 = file + rank;
                diag_a8h1_magic_number[board_index[file][rank]]
                        = diag_a8h1_magics[diag_a8h1 - 2];

                diag_a1h8 = file - rank;
                diag_a1h8_magic_number[board_index[file][rank]]
                        = diag_a1h8_magics[diag_a1h8 + 7];

                file_magic_number[board_index[file][rank]] = 
                        file_magics[file-1];
            }
        }

    }

    public static Stringboard toStringboard()
    {
        Stringboard s = new Stringboard();
        for (int i = 0; i < 64; ++i)
        {
            if ((w_pawns & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'P');
            }
            if ((w_rooks & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'R');
            }
            if ((w_knights & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'N');
            }
            if ((w_bishops & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'B');
            }
            if ((w_queens & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'Q');
            }
            if ((w_king & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'K');
            }
            if ((b_pawns & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'p');
            }
            if ((b_rooks & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'r');
            }
            if ((b_knights & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'n');
            }
            if ((b_bishops & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'b');
            }
            if ((b_queens & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'q');
            }
            if ((b_king & Board.squares[i]) != 0)
            {
                s.setSquare(i, 'k');
            }

        }
        return s;
    }

    private void import_stringboard(Stringboard s)
    {
        for (int i = 0; i < 64; ++i)
        {
            switch (s.getSquare(i))
            {
                case 'P':
                    w_pawns |= (1 << i);
                    break;
                case 'R':
                    w_rooks |= (1 << i);
                    break;
                case 'N':
                    w_knights |= (1 << i);
                    break;
                case 'B':
                    w_bishops |= (1 << i);
                    break;
                case 'Q':
                    w_queens |= (1 << i);
                    break;
                case 'K':
                    w_king |= (1 << i);
                    break;
                case 'p':
                    b_pawns |= (1 << i);
                    break;
                case 'r':
                    b_rooks |= (1 << i);
                    break;
                case 'n':
                    b_knights |= (1 << i);
                    break;
                case 'b':
                    b_bishops |= (1 << i);
                    break;
                case 'q':
                    b_queens |= (1 << i);
                    break;
                case 'k':
                    b_king |= (1 << i);
                    break;

            }
        }
    }

    public static void set_init_position()
    {
        char[] init = Stringboard.getInit_position();
        for (int i = 0; i < 64; ++i)
        {
            switch (init[i])
            {
                case 'P':
                    w_pawns |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.white_pawn;
                    break;
                case 'R':
                    w_rooks |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.white_rook;
                    break;
                case 'N':
                    w_knights |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.white_knight;
                    break;
                case 'B':
                    w_bishops |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.white_bishop;
                    break;
                case 'Q':
                    w_queens |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.white_queen;
                    break;
                case 'K':
                    w_king |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.white_king;
                    break;
                case 'p':
                    b_pawns |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.black_pawn;
                    break;
                case 'r':
                    b_rooks |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.black_rook;
                    break;
                case 'n':
                    b_knights |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.black_knight;
                    break;
                case 'b':
                    b_bishops |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.black_bishop;
                    break;
                case 'q':
                    b_queens |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.black_queen;
                    break;
                case 'k':
                    b_king |= Board.squares[i];

                    Position.piece_in_square[i] = Pieces.black_king;
                    break;
                default:
                    Position.piece_in_square[i] = Pieces.blank;
                    break;

            }
        }
        white_pieces = Position.w_pawns | Position.w_rooks
                | Position.w_knights | Position.w_bishops | Position.w_queens
                | Position.w_king;
        black_pieces = Position.b_pawns | Position.b_rooks
                | Position.b_knights | Position.b_bishops | Position.b_queens
                | Position.b_king;
        occupied_squares = white_pieces | black_pieces;
    }

    static public void display(Long b)
    {
        int rank, file;
        char tmp;
        for (rank = 8; rank >= 1; rank--)
        {
            System.out.println("    +---+---+---+---+---+---+---+---+");
            System.out.print(rank + "   |");
            for (file = 1; file <= 8; file++)
            {
                if ((b & Board.squares[8 * (rank - 1) + file - 1]) != 0)
                {
                    tmp = 'x';
                } else
                {
                    tmp = ' ';
                }
                System.out.print(" " + tmp + " |");
            }
            System.out.println();
        }
        System.out.println("    +---+---+---+---+---+---+---+---+");
        System.out.println("      a   b   c   d   e   f   g   h");

        /*else
         {
         std::cout << "      h   g   f   e   d   c   b   a" << std::endl;
         for (rank = 1; rank <= 8; rank++)
         {
         std::cout << "    +---+---+---+---+---+---+---+---+" << std::endl;
         std::cout << "    |";
         for (file = 8; file >= 1; file--)
         {
         std::cout << " " << PIECENAMES[square[BOARDINDEX[file][rank]]] << "|";
         }
         std::cout << std::setw(3) << rank << std::endl;
         }
         std::cout << "    +---+---+---+---+---+---+---+---+" << std::endl << std::endl;
         }*/
        try
        {
            System.in.read();
        } catch (Exception e)
        {
            System.exit(-1);
        }
        return;
    }
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

    public static int max_move_buffer_size = 200;

    public static int[] onebyte_bitset = new int[8];
    public static long rank_mask[] = new long[64];
    public static long file_mask[] = new long[64];
    public static long diag_a8h1_mask[] = new long[64];
    public static long diag_a1h8_mask[] = new long[64];
    public static long file_magic_number[] = new long[64];
    public static long diag_a8h1_magic_number[] = new long[64];
    public static long diag_a1h8_magic_number[] = new long[64];

    private static long[] diag_a8h1_magics =
    {
        0x0L,
        0x0L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0080808080808080L,
        0x0040404040404040L,
        0x0020202020202020L,
        0x0010101010101010L,
        0x0008080808080808L,
        0x0L,
        0x0L

    };

    private static long[] diag_a1h8_magics =
    {
        0x0L,
        0x0L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x0101010101010100L,
        0x8080808080808000L,
        0x4040404040400000L,
        0x2020202020000000L,
        0x1010101000000000L,
        0x0808080000000000L,
        0x0L,
        0x0L
    };

    private static long[] file_magics =
    {
        0x8040201008040200L,
        0x4020100804020100L,
        0x2010080402010080L,
        0x1008040201008040L,
        0x0804020100804020L,
        0x0402010080402010L,
        0x0201008040201008L,
        0x0100804020100804L
    };

}
