package chessengine1;

/**
 *
 * @author tod
 */
public class Bitboards
{

    /*public Bitboards()
     {
     w_pawns = w_rooks = w_knights = w_bishops = w_queens = w_king = b_pawns = b_rooks
     = b_knights = b_bishops = b_queens = b_king = 0L;
     }*/
    public Stringboard toStringboard()
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

    public void set_init_position()
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
        white_pieces = Bitboards.w_pawns | Bitboards.w_rooks
                | Bitboards.w_knights | Bitboards.w_bishops | Bitboards.w_queens
                | Bitboards.w_king;
        black_pieces = Bitboards.b_pawns | Bitboards.b_rooks
                | Bitboards.b_knights | Bitboards.b_bishops | Bitboards.b_queens
                | Bitboards.b_king;
        occupied_squares = white_pieces | black_pieces;
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

    static long w_pawns = 0L, w_rooks = 0L, w_knights = 0L, w_bishops = 0L,
            w_queens = 0L, w_king = 0L, b_pawns = 0L, b_rooks = 0L,
            b_knights = 0L, b_bishops = 0L, b_queens = 0L, b_king = 0L;
    static long white_pieces = 0L, black_pieces = 0L, occupied_squares = 0L;

}
