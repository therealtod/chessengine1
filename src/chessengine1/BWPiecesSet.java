/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessengine1;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author tod
 */
public class BWPiecesSet extends PiecesSet
{

    public BWPiecesSet()
    {
        BWPiecesSet.white_pawn = new ImageIcon("./chess pieces/Chess_plt60.png");
        white_rook = new ImageIcon("./chess pieces/Chess_rlt60.png");
        white_knight = new ImageIcon("./chess pieces/Chess_nlt60.png");
        white_bishop = new ImageIcon("./chess pieces/Chess_blt60.png");
        white_queen = new ImageIcon("./chess pieces/Chess_qlt60.png");
        white_king = new ImageIcon("./chess pieces/Chess_klt60.png");
        black_pawn = new ImageIcon("./chess pieces/Chess_pdt60.png");
        black_rook = new ImageIcon("./chess pieces/Chess_rdt60.png");
        black_knight = new ImageIcon("./chess pieces/Chess_ndt60.png");
        black_bishop = new ImageIcon("./chess pieces/Chess_bdt60.png");
        black_queen = new ImageIcon("./chess pieces/Chess_qdt60.png");
        black_king = new ImageIcon("./chess pieces/Chess_kdt60.png");
    }

}
