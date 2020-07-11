import java.awt.*;
import java.util.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		
		//Your logic here
				
		swapButton(buttons[emptyCellId],buttonClicked);
		int i=0;
		for(i=0;i<buttons.length;i++) {
			if(buttonClicked.equals(buttons[i]))
				break;
		}
	
		return i;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		//Your logic here
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(list.size()!=15) {
			int a = getRandomNumber();
			if(!list.contains(a%16)&&(a%16)!=0)
			{
				list.add(a%16);
			}
		}
		for(int i=0;i<15;i++) {
			arr[i]=list.get(i);
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] arr=getIntegerArrayOfButtonIds(buttons);
		
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				winner=false;
				break;
			}
		}
		return winner;
	}
}