package chess;

import java.util.ArrayList;
import java.util.List;

class Board {
	
	private List<Location> visitedLocations;
	
	private final int boardWidth;
	private final int boardLength;
	
	public Board(int boardWidth, int boardLength) {
		this.boardWidth = boardWidth;
		this.boardLength = boardLength;
		visitedLocations = new ArrayList<Location>();
	}
	
	public int getWidth() {
		return boardWidth;
	}
	
	public int getLength() {
		return boardLength;
	}
	
	public void addVisitedLocation(Location loc) {
		visitedLocations.add(loc);
	}
	
	public Location getCurrentLocation() {
		return visitedLocations.get(visitedLocations.size() - 1);
	}
	
	public List<Location> getVisitedLocations(){
		return visitedLocations;
	}
	
}
