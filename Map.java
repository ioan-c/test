package labirint;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner scanner;
	private Image terrain, wall, bonus, snare, life;
	ArrayList<ArrayList<String>> map = new ArrayList<ArrayList<String>>();
	
	public Map(){
		terrain = new ImageIcon("C:/CI/games/maze/terrain.jpg").getImage();
		wall = new ImageIcon("C:/CI/games/maze/wall.jpg").getImage();
		bonus = new ImageIcon("C:/CI/games/maze/bonus.jpg").getImage();
		snare = new ImageIcon("C:/CI/games/maze/snare.jpg").getImage();
		life = new ImageIcon("C:/CI/games/maze/life.jpg").getImage();
		mapInizialization();
		closeMapScanner();
	}

	public Image getTerrain() {
		return terrain;
	}

	public Image getWall() {
		return wall;
	}
	
	public Image getBonus() {
		return bonus;
	}

	public Image getSnare() {
		return snare;
	}

	public Image getLife() {
		return life;
	}

	public String getMapCoordinates(int x, int y){
		return map.get(y).get(x);
	}
	
	public ArrayList<ArrayList<String>> getMap(){
		return map;
	}
	
	public int getLastRow() {
		return map.size();
	}
	
	public int getLastColumn(){
		return map.get(0).size();
	}

	public void mapInizialization(){
		
		try{
			scanner = new Scanner(new File("C:/CI/games/maze/map.txt"));
		} catch (FileNotFoundException e){
			System.out.println("Error loading map file!");
		}
		
		while(scanner.hasNextLine())
		{
		    String lineRead = scanner.nextLine();
		    ArrayList<String> row = new ArrayList<String>();
		    for(char column : lineRead.toCharArray()){
		        row.add(String.valueOf(column));
		    }
		    map.add(row);
		}
	}
	
	public void closeMapScanner(){
		if(scanner != null)
			scanner.close();
	}
}
