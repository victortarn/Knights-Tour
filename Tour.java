package chess;


import java.util.ArrayList;
import java.util.List;

public class Tour {
	
    private Board board;
    
    //Two arrays which represent the coordinates of the Knight's moves
	private static final int xMove[] = {1, 1, -1, -1, 2, 2, -2, -2}; 
    private static final int yMove[] = {2, -2, 2, -2, 1, -1, 1, -1};
    
	public Tour(Board board) {
		this.board = board;
	}
	
	public void startTour(Location loc) {
		board.addVisitedLocation(loc);
	}

	public boolean hasNext() {
		if (numberPossibleMoves(board.getCurrentLocation()) > 0) {
			return true;
		} 
		else {
			return false;
		}
	}	

	public Location next() {
		int numPosMoves = 0;
		int minPosMoves = 9;
		int minPosMovesIndex = 0;
		
		if (!hasNext()) {
			return null;
		}
		
		List<Location> openMoves = possibleMoves();
				
		for (int i = 0; i < openMoves.size(); i++) {
			 numPosMoves = numberPossibleMoves(openMoves.get(i));
			 
			 if (numPosMoves > 0 && numPosMoves < minPosMoves) {
				 minPosMoves = numPosMoves;
				 minPosMovesIndex = i;
			 }
		}
		
		board.addVisitedLocation(openMoves.get(minPosMovesIndex));
		
		return openMoves.get(minPosMovesIndex);
	}
	
	//Returns an array list of the possible moves that to lead to an unvisited location
	public List<Location> possibleMoves(){
		List<Location> legalMoves = new ArrayList<Location>();
		Location currentLoc = board.getCurrentLocation();
		Location possibleLoc = new Location();
		int xCor;
		int yCor;
		
		for (int i = 0; i < 8; i++) {
			xCor = xMove[i] + currentLoc.x();
			yCor = yMove[i] + currentLoc.y();
			
			if (!(xCor > board.getWidth() || yCor > board.getLength() || xCor < 1 || yCor < 1)) {
				possibleLoc.x(xCor);
				possibleLoc.y(yCor);
				
				if (!(board.getVisitedLocations().contains(possibleLoc))){
					legalMoves.add(new Location (possibleLoc));
				}
			}
			
		}

		return legalMoves;		
	}
	
	//Returns an integer of the number of possible moves given a location
	public int numberPossibleMoves(Location loc){
		Location possibleLoc = new Location();
		int xCor;
		int yCor;
		int numMoves = 0;
		
		for (int i = 0; i < 8; i++) {
			xCor = xMove[i] + loc.x();
			yCor = yMove[i] + loc.y();
			
			if (!(xCor > board.getWidth() || yCor > board.getLength() || xCor < 1 || yCor < 1)) {
				possibleLoc.x(xCor);
				possibleLoc.y(yCor);
				
				if (!(board.getVisitedLocations().contains(possibleLoc))){
					numMoves++;
				}
			}
		}
		
		return numMoves;
	}
}
