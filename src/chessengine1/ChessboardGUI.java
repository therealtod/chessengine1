
package chessengine1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author tod
 */
public class ChessboardGUI extends JPanel implements MouseListener, 
        MouseMotionListener
{
    public ChessboardGUI ()
    {
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
        x=0;
        y=0;
    }

    
    @Override
    public void paintComponent (Graphics g)
    {
        
        super.paintComponent(g);
        this.setBackground(Color.black);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        draw_chessboard(g);
        draw_pieces(g);
        /*g.setColor(Color.RED);
        g.fillRect(20, 20, 20, 20);
        g.drawString ("Porcodio", x, y);*/
    }
    @Override
    public void mouseMoved(MouseEvent me)
    {
        x=me.getX();
        y=me.getY();
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent me)
    {
        
    }
    @Override
    public void mouseReleased(MouseEvent me)
    {
    
    }
    @Override
    public void mouseClicked(MouseEvent me)
    {
        
    }
    @Override
    public void mouseDragged(MouseEvent me)
    {
        
    }
    @Override
    public void mouseEntered(MouseEvent me)
    {
        
    }
    @Override
    public void mouseExited(MouseEvent me)
    {
        
    }
    private void draw_chessboard(Graphics g)
    {
        /*for (int i=0; i<64; i+=2)
        {
            g.setColor (new Color (255,200,100));
            g.fillRect((i%8+(i/8)%2)*square_size, (i/8)*square_size, square_size, square_size);
            g.setColor (new Color (150,50,30));    
            g.fillRect(((i+1)%8-((i+1)/8)%2)*square_size, ((i+1)/8)*square_size, square_size, square_size);
        }
        */
        g.setColor (new Color (255,200,100));
        g.fillRect (0, 0, 8*square_size, 8*square_size);
        g.setColor (new Color (150,50,30));
        for (int i=1; i<64; i+=2)
        {
            g.fillRect (((i+((i/8)%2))%8)* square_size, (i/8)*square_size, 
                    square_size, square_size );
            
        }   
            
    }
   /* private void draw_pieces (Graphics g)
    {
        Image img= new ImageIcon("ChessPieces.png").getImage();
        Stringboard sb = new Stringboard();
        char[] pos = sb.getCurrent_position();
        int j,k;
        //PiecesSet ps = new BWPiecesSet();
        
        
        for (int i=0; i<64; ++i)
        {
            switch (pos[i])
            {
                case 'P':
                    //img = ps.getWhite_pawn().getImage();
                    j=5;k=0;
                    break;
                case 'R':
                    //img = ps.getWhite_rook().getImage();
                    j=2;k=0;
                    break;
                case 'N':
                    j=4;k=0;
                    //img = ps.getWhite_knight().getImage();
                    break;
                case 'B':
                    //img = ps.getWhite_bishop().getImage();
                    j=3;k=0;
                    break;
                case 'Q':
                    j=1;k=0;
                    //img = ps.getWhite_queen().getImage();
                    break;
                case 'K':
                    j=0;k=0;
                    //img = ps.getWhite_king().getImage();
                    break;
                case 'p':
                    j=5;k=1;
                    //img = ps.getBlack_pawn().getImage();
                    break;
                case 'r':
                    j=2;k=1;
                    //img = ps.getBlack_rook().getImage();
                    break;
                case 'n':
                    j=4;k=1;
                    //img = ps.getBlack_knight().getImage();
                    break;
                case 'b':
                    j=3;k=1;
                    //img = ps.getBlack_bishop().getImage();
                    break;
                case 'q':
                    j=1;k=1;
                    //img = ps.getBlack_queen().getImage();
                    break;
                case 'k':
                    j=0;k=1;
                    //img = ps.getBlack_king().getImage();
                    break;
                default:
                    j=-1;k=-1;
                    break;
            }
            if (j!=-1)
            g.drawImage(img, i%8*square_size , i/8*square_size, (i%8+1)*square_size, (i/8+1)*square_size, j*64,k*64, (j+1)*64, (k+1)*64, this);
                    
        }
    }
    */
    
    private void draw_pieces (Graphics g)
    {
        Image img= null;
        
        Bitboards.set_init_position();
        
        Stringboard sb = new Stringboard();
        
        sb= Bitboards.toStringboard();
        
        PiecesSet ps = new BWPiecesSet ();
        char[] pos = sb.getCurrent_position();
        for (int i=0; i<64; ++i)
        {
            switch (pos[i])
            {
                case 'P':
                    img = ps.getWhite_pawn().getImage();
                    break;
                case 'R':
                    img = ps.getWhite_rook().getImage();
                    break;
                case 'N':
                    img = ps.getWhite_knight().getImage();
                    break;
                case 'B':
                    img = ps.getWhite_bishop().getImage();
                    break;
                case 'Q':
                    img = ps.getWhite_queen().getImage();
                    break;
                case 'K':
                    img = ps.getWhite_king().getImage();
                    break;
                case 'p':
                    img = ps.getBlack_pawn().getImage();
                    break;
                case 'r':
                    img = ps.getBlack_rook().getImage();
                    break;
                case 'n':
                    img = ps.getBlack_knight().getImage();
                    break;
                case 'b':
                    img = ps.getBlack_bishop().getImage();
                    break;
                case 'q':
                    img = ps.getBlack_queen().getImage();
                    break;
                case 'k':
                    img = ps.getBlack_king().getImage();
                    break;
                default:
                    img=null;
                    break;
            }
            g.drawImage(img, i%8*square_size , i/8*square_size, square_size, square_size,  this);
                    
        }
    }
    
    private static JFrame frame = new JFrame ("Debug chessboard");
    private static int x,y; //le coordinate nella finestra (a partire dall' angolo in alto a sinistra)
    
    //CONSTANTS
    
    private static final int square_size= 50;
}
