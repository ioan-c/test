package labirint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private Map map;
	private Player player;
	private int lives = 2;
	private int points = 0;
	private boolean outOfLives = false;
	private String message = " ";
	private int boardWidth, boardHeight;
	private MazeLauncher launcher;

	public Board(MazeLauncher launcher){
		this.launcher = launcher;
		map = new Map();
		boardWidth = map.getLastColumn()*32;
		boardHeight = map.getLastRow()*32;
		player = new Player();
		addKeyListener(new KeyboardListener(map, player));
		setFocusable(true);
		new Timer(20, this).start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(lives<0){
			outOfLives = true;
			message = "DEAD";
		} else {
			if(map.getMapCoordinates(player.getTileX(), player.getTileY()).equals(Constants.SNARE)){
				map.getMap().get(player.getTileY()).set(player.getTileX(), Constants.TERRAIN);
				map.getMap().get(map.getLastRow()-1).set(lives, Constants.WALL);
				lives--;
				boolean foundSpace = false;
				while(!foundSpace){
					int row = getRandomValue(1,map.getLastRow()-1);
					int column = getRandomValue(1,map.getLastColumn()-1);
					String space = map.getMap().get(row).get(column);
					if(space.equals(Constants.TERRAIN)){
						map.getMap().get(row).set(column, Constants.SNARE);
						foundSpace = true;
					}
				}
			}
			if(map.getMapCoordinates(player.getTileX(), player.getTileY()).equals(Constants.BONUS)){
				map.getMap().get(player.getTileY()).set(player.getTileX(), Constants.TERRAIN);
				points++;
				boolean foundSpace = false;
				while(!foundSpace){
					int row = getRandomValue(1,map.getLastRow()-1);
					int column = getRandomValue(1,map.getLastColumn()-1);
					String space = map.getMap().get(row).get(column);
					if(space.equals(Constants.TERRAIN)){
						map.getMap().get(row).set(column, Constants.BONUS);
						foundSpace = true;
					}
				}
			}
		}
		repaint();

	}

	public void paint(Graphics g){
		super.paint(g);
		if(!outOfLives){
			for(int y=0; y<map.getLastRow(); y++){
				for(int x=0; x<map.getLastColumn(); x++){
					if(map.getMapCoordinates(x,y).equals(Constants.TERRAIN)){
						g.drawImage(map.getTerrain(), x*32, y*32, null);
					}
					if(map.getMapCoordinates(x,y).equals(Constants.WALL)){
						g.drawImage(map.getWall(), x*32, y*32, null);
					}
					if(map.getMapCoordinates(x,y).equals(Constants.BONUS)){
						g.drawImage(map.getBonus(), x*32, y*32, null);
					}
					if(map.getMapCoordinates(x,y).equals(Constants.SNARE)){
						g.drawImage(map.getSnare(), x*32, y*32, null);
					}
					if(map.getMapCoordinates(x,y).equals(Constants.LIFE)){
						g.drawImage(map.getLife(), x*32, y*32, null);
					}
				}
			}
			g.setFont(new Font("Serif", Font.BOLD, 30));
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(points), 10, 25);
			g.drawImage(player.getPlayer(), player.getTileX()*32, player.getTileY()*32, null);
		} else {
			g.setFont(new Font("Serif", Font.BOLD, 48));
			g.setColor(Color.BLUE);
			g.drawString(message, boardWidth/2-80,  boardHeight/2-100);
			g.drawString("You got "+String.valueOf(points)+ " points", boardWidth/2-160,  boardHeight/2-60);
			
			JButton restartButton = new JButton();
			restartButton.setBounds(boardWidth/2-50, boardHeight/2, 100, 50);
			restartButton.setText("Restart");
			restartButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					launcher.restart();
				} 
			});
			this.add(restartButton);
		}

	}
	
	public Map getMap(){
		return map;
	}
	
	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public static int getRandomValue(int min, int max){
	    	int range = (max - min) + 1;     
	    	return (int)(Math.random() * range) + min;
	}
}
