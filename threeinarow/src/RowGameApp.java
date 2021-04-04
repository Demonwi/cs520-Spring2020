import controller.RowGameController;
import controller.TttGameController;
import java.util.Scanner;

public class RowGameApp
{
    /**
     * Starts a new game in the GUI.
     */
    public static void main(String[] args) {
      Scanner myObj = new Scanner(System.in);
      String input = "0";
      while(true){
        System.out.println("Enter 1 for Tic Tac Toe and 2 for Three in a Row");
        input = myObj.nextLine();
        if(input.equals("1")){
          TttGameController game = new TttGameController();
        	game.startUp();
          break;
        }else if(input.equals("1")){
          RowGameController game = new RowGameController();
        	game.startUp();
          break;
        }else{
          System.out.println("Input not recognized " + input + ".  ");
        }
      }
    	RowGameController game = new RowGameController();
    	game.startUp();
    }
}
