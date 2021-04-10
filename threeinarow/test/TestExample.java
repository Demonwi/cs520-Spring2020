import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.JButton;
import model.RowBlockModel;
import model.RowGameModel;
import controller.*;


/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private RowGameModel gameModel;
    private TttGameController tgame;
    private RowGameController rgame;
    private JButton[][] tbuttons;
    private JButton[][] rbuttons;
    private RowBlockModel[][] tblocks;
    private RowBlockModel[][] rblocks;
    private RowGameModel tmod;
    private RowGameModel rmod;

    @Before
    public void setUp() {
	     gameModel = new RowGameModel();
       tgame = new TttGameController();
       rgame = new RowGameController();
       tbuttons = tgame.getView().gameBoardView.blocks;
       rbuttons = rgame.getView().gameBoardView.blocks;
       tblocks = tgame.getModel().blocksData;
       rblocks = rgame.getModel().blocksData;
       tmod = tgame.getModel();
       rmod = rgame.getModel();
    }

    @After
    public void tearDown() {
	gameModel = null;
    }

    @Test
    public void testNewGame() {
        assertEquals ("1", gameModel.player);
        assertEquals (9, gameModel.movesLeft);
    }

    @Test
    public void testBlock() {
        gameModel.blocksData[0][0].setContents("X");
        assertEquals ("X", gameModel.blocksData[0][0].getContents());
    }

    @Test
    public void testMove(){
      rgame.resetGame();
      rbuttons[2][0].doClick();
      assertEquals ("X", rblocks[2][0].getContents());
    }

    @Test
    public void testMove2(){
      rgame.resetGame();
      rbuttons[2][0].doClick();
      rbuttons[1][0].doClick();
      assertEquals ("O", rblocks[1][0].getContents());
    }

    @Test
    public void testMove3(){
      rgame.resetGame();
      rbuttons[1][0].doClick();
      assertEquals ("", rblocks[1][0].getContents());
    }

    public void testReset(){
      rgame.resetGame();
      rbuttons[2][0].doClick();
      rbuttons[1][0].doClick();
      rgame.resetGame();
      assertEquals ("", rblocks[1][0].getContents());
    }

    @Test
    public void testTie(){
      rgame.resetGame();
      rbuttons[2][0].doClick();
      rbuttons[1][0].doClick();
      rbuttons[0][0].doClick();
      rbuttons[2][1].doClick();
      rbuttons[1][1].doClick();
      rbuttons[2][2].doClick();
      rbuttons[1][2].doClick();
      rbuttons[0][2].doClick();
      rbuttons[0][1].doClick();
      assertEquals ("Game ends in a draw", rmod.getFinalResult());
    }

    @Test
    public void testWin(){
      rgame.resetGame();
      rbuttons[2][0].doClick();
      rbuttons[2][1].doClick();
      rbuttons[1][0].doClick();
      rbuttons[1][1].doClick();
      rbuttons[0][0].doClick();
      assertEquals ("Player 1 wins!", rmod.getFinalResult());
    }


    @Test
    public void testTMove(){
      tgame.resetGame();
      tbuttons[2][0].doClick();
      assertEquals ("X", tblocks[2][0].getContents());
    }

    @Test
    public void testTMove2(){
      tgame.resetGame();
      tbuttons[2][2].doClick();
      tbuttons[1][0].doClick();
      assertEquals ("O", tblocks[1][0].getContents());
    }

    @Test
    public void testTMove3(){
      tgame.resetGame();
      tbuttons[2][0].doClick();
      tbuttons[1][1].doClick();
      tbuttons[1][0].doClick();
      assertEquals ("X", tblocks[1][0].getContents());
    }

    public void testTReset(){
      tgame.resetGame();
      tbuttons[2][0].doClick();
      tbuttons[1][0].doClick();
      tgame.resetGame();
      assertEquals ("", tblocks[1][0].getContents());
    }

    @Test
    public void testTTie(){
      tgame.resetGame();
      tbuttons[2][0].doClick();
      tbuttons[1][0].doClick();
      tbuttons[0][0].doClick();
      tbuttons[2][1].doClick();
      tbuttons[1][1].doClick();
      tbuttons[2][2].doClick();
      tbuttons[1][2].doClick();
      tbuttons[0][2].doClick();
      tbuttons[0][1].doClick();
      assertEquals ("Game ends in a draw", tmod.getFinalResult());
    }

    @Test
    public void testTWin(){
      tgame.resetGame();
      tbuttons[2][0].doClick();
      tbuttons[2][1].doClick();
      tbuttons[1][0].doClick();
      tbuttons[1][1].doClick();
      tbuttons[0][0].doClick();
      assertEquals ("Player 1 wins!", tmod.getFinalResult());
    }
    @Test
    public void testTWin2(){
      tgame.resetGame();
      tbuttons[2][2].doClick();
      tbuttons[2][0].doClick();
      tbuttons[2][1].doClick();
      tbuttons[1][0].doClick();
      tbuttons[1][1].doClick();
      tbuttons[0][0].doClick();
      assertEquals ("Player 2 wins!", tmod.getFinalResult());
    }



    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	RowBlockModel block = new RowBlockModel(null);
    }
}
