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
public class Move
{
    public Move ()
    {
        move=0;
    }
    public void clear()
    {
        move=0;
    }
    
    public void set_from_square (int sq)
    {
        move &= 0xffffffc0;
        move |= sq;
    }
    public void set_to_square (int sq)
    {
        move &= 0xfffff03f;
        move |= sq << 6;
    }
    public void set_piece (int p)
    {
        move &= 0xffff0fff;
        move |= p << 12;
    }
    public void set_capured_piece (int p)
    {
        move &= 0xfff0ffff;
        move |= p << 16;
    }
    public void set_promoting_piece (int p)
    {
        move &= 0xff0fffff;
        move |= p << 20;
    }
    public int get_from_square()
    {
        return (move & 0x0000003f);
    }
    public int get_to_square()
    {
        return ((move >>> 6) & 0x0000003f);
    }
    public int get_piece()
    {
        return ((move >>> 12) & 0x0000000f);
    }
    public int get_captured_piece()
    {
        return ((move >>> 16) & 0x0000000f);
    }
    public int get_promoting_piece()
    {
        return ((move) >>> 20 & 0x0000000f);
    }
    
    /* Move bitfield:
     * 6 bits fromSquare
     * 6 bits toSquare
     * 4 bits movingPiece
     * 4 bits capturedPiece
     * 4 bits promotingTo
     */
    int move;
}
