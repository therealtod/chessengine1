/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessengine1;

import javax.swing.*;

/**
 *
 * @author tod
 */
public class ChessEngine
{
    public static void main (String[] args) 
    {
        Board.init();
        Bitboards.set_init_position();
        Bitboards.init_Bitboards_data();
        MoveGenerator.init();
        new ChessboardGUI();
    }
}
