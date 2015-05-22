
package chessengine1;

/**
 *
 * @author tod
 */
public class Bitboard
{
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
    public static void visualize_bitboard (Bitboard b) //Just for debugging purposes
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
    
}
    
