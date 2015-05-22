package chessengine1;

import static chessengine1.Position.*;

/**
 *
 * @author tod
 */
public class Bitboards
{

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
                    break;
                case 'R':
                    w_rooks |= Board.squares[i];
                    break;
                case 'N':
                    w_knights |= Board.squares[i];
                    break;
                case 'B':
                    w_bishops |= Board.squares[i];
                    break;
                case 'Q':
                    w_queens |= Board.squares[i];
                    break;
                case 'K':
                    w_king |= Board.squares[i];
                    break;
                case 'p':
                    b_pawns |= Board.squares[i];
                    break;
                case 'r':
                    b_rooks |= Board.squares[i];
                    break;
                case 'n':
                    b_knights |= Board.squares[i];
                    break;
                case 'b':
                    b_bishops |= Board.squares[i];
                    break;
                case 'q':
                    b_queens |= Board.squares[i];
                    break;
                case 'k':
                    b_king |= Board.squares[i];
                    break;
                default:
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

        }
        return;
    }
    /*
     public static void init_chessboard()
     {
        
     char [] board_string = Stringboard.getInit_position();
        
     long w_pawns= 0L, w_rooks= 0L, w_knights= 0L, w_bishops= 0L, 
     w_queens= 0L, w_king= 0L, b_pawns= 0L, b_rooks= 0L, 
     b_knights= 0L, b_bishops= 0L, b_queens= 0L, b_king= 0L;
        
     string_to_bitboards (board_string, w_pawns, w_rooks, w_knights,
     w_bishops, w_queens, w_king, b_pawns, b_rooks, b_knights, 
     b_bishops, b_queens, b_king);
     }
     static void string_to_bitboards(char [] board, long wp, long wr, 
     long wn, long wb, long wq, long wk, long bp, long br, long bn, 
     long bb, long bq, long bk)
     {
     for (int i=0; i<64; ++i)
     {
     switch (board[i])
     {
     case 'P':
     wp |= ( 1 << i);
     break;
     case 'R':
     wr |= ( 1 << i);
     break;
     case 'N':
     wn |= ( 1 << i);
     break;
     case 'B':
     wb |= ( 1 << i);
     break;
     case 'Q':
     wq |= ( 1 << i);
     break;
     case 'K':
     wk |= ( 1 << i);
     break;
     case 'p':
     bp |= ( 1 << i);
     break;
     case 'r':
     br |= ( 1 << i);
     break;
     case 'n':
     bn |= ( 1 << i);
     break;
     case 'b':
     bb |= ( 1 << i);
     break;
     case 'q':
     bq |= ( 1 << i);
     break;
     case 'k':
     bk |= ( 1 << i);
     break;
                  
     }
     }
     }
     public static void visualize_bitboard (Bitboards b) //Just for debugging purposes
     {
        
     }
     public static void draw_board (long wp, long wr, 
     long wn, long wb, long wq, long wk, long bp, long br, long bn, 
     long bb, long bq, long bk)
     {
        
     }
     public Stringboard toStringboard ()
     {
     return null;
     }
     */

}
