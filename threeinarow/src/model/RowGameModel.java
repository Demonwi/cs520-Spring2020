package model;
import view.RowGameGUI;
import java.util.ArrayList;

public class RowGameModel
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    private ArrayList<RowGameGUI> observers = new ArrayList<RowGameGUI>();


    public void register(RowGameGUI observer){
      observers.add(observer);
    }

    public void unregister(RowGameGUI observer){
      observers.remove(observer);
    }

    public RowBlockModel[][] getState(){
      return blocksData;
    }

    public void stateChange(){
      for(RowGameGUI ob: observers){
        ob.update(this);
      }
    }

    public void setState(RowBlockModel[][] newData){
      if(newData.length == 3 && newData[0].length == 3){
        blocksData = newData;
        stateChange();
      }else{
        System.out.println("Wrong Size");
      }
    }

    /**
     * The current player taking their turn
     */
    public String player = "1";
    public int movesLeft = 9;

    private String finalResult = null;


    public RowGameModel() {
	super();

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }
}
