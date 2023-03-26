import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel{
    private static final int SQUARE_SIZE = 80;
    private static final int BOARD_SIZE = 8 * SQUARE_SIZE;

    private Image whitePawn, blackPawn, whiteRook, blackRook, whiteKnight, blackKnight, whiteBishop, blackBishop, whiteQueen, blackQueen, whiteKing, blackKing;

    private Color lightSquare = new Color(240, 217, 181);
    private Color darkSquare = new Color(181, 136, 99);

    public Board() {
        whitePawn = Toolkit.getDefaultToolkit().getImage("white_pawn.png");
        blackPawn = Toolkit.getDefaultToolkit().getImage("black_pawn.png");
        whiteRook = Toolkit.getDefaultToolkit().getImage("white_rook.png");
        blackRook = Toolkit.getDefaultToolkit().getImage("black_rook.png");
        whiteKnight = Toolkit.getDefaultToolkit().getImage("white_knight.png");
        blackKnight = Toolkit.getDefaultToolkit().getImage("black_knight.png");
        whiteBishop = Toolkit.getDefaultToolkit().getImage("white_bishop.png");
        blackBishop = Toolkit.getDefaultToolkit().getImage("black_bishop.png");
        whiteQueen = Toolkit.getDefaultToolkit().getImage("white_queen.png");
        blackQueen = Toolkit.getDefaultToolkit().getImage("black_queen.png");
        whiteKing = Toolkit.getDefaultToolkit().getImage("white_king.png");
        blackKing = Toolkit.getDefaultToolkit().getImage("black_king.png");

        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int x = col * SQUARE_SIZE;
                int y = row * SQUARE_SIZE;

                if ((row + col) % 2 == 0) {
                    g.setColor(lightSquare);
                } else {
                    g.setColor(darkSquare);
                }

                g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);

                // Draw pieces
                // TODO: Replace with actual logic for placing pieces
                if (row == 1) {
                    g.drawImage(whitePawn, x, y, null);
                } else if (row == 6) {
                    g.drawImage(blackPawn, x+10, y+10, null);
                } else if (row == 0 && (col == 0 || col == 7)) {
                    g.drawImage(whiteRook, x, y, null);
                } else if (row == 7 && (col == 0 || col == 7)) {
                    g.drawImage(blackRook, x, y, null);
                } else if (row == 0 && (col == 1 || col == 6)) {
                    g.drawImage(whiteKnight, x, y, null);
                } else if (row == 7 && (col == 1 || col == 6)) {
                    g.drawImage(blackKnight, x, y, null);
                } else if (row == 0 && (col == 2 || col == 5)) {
                    g.drawImage(whiteBishop, x, y, null);
                } else if (row == 7 && (col == 2 || col == 5)) {
                    g.drawImage(blackBishop, x, y, null);
                } else if (row == 7 && (col == 4)) {
                    g.drawImage(blackKing, x, y, null);
                } else if (row == 7 && (col == 3)) {
                    g.drawImage(blackQueen, x, y, null);
                } else if (row == 0 && (col == 4)) {
                    g.drawImage(whiteKing, x, y, null);
                } else if (row == 0 && (col == 3)) {
                    g.drawImage(whiteQueen, x, y, null);
                }
            }
        }
    }
}