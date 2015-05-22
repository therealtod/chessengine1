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
public class Stringboard
{

    public Stringboard()
    {
        
        String s = "";
        for (int i = 0; i< 64; ++i)
        {
            s += " ";
        }

        current_position = s.toCharArray();
      
    }
    
    public char[] getCurrent_position()
    {
        return current_position;
    }
    public char getSquare(int n)
    {
        return current_position[n];
    }
    public static char[] getInit_position()
    {
        return init_position;
    }
    public void setSquare (int nsquare, char piece)
    {
        current_position[nsquare] = piece;
    }
 
 
    private char [] current_position = new char [64];
    
    private final static char [] init_position  = 
    {

        'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r',
        'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p',
        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
        ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
        'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P',
        'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'

    };
    
}
