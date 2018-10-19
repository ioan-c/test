package labirint;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	
	private int tileX, tileY;
	private Image player;
	
	public Player(){
		player = new ImageIcon("C:/CI/games/maze/player.png").getImage();
		tileX = 1;
		tileY = 1;
	}
	
	public void move(int tileX, int tileY){
		this.tileX += tileX;
		this.tileY += tileY;
	}

	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public Image getPlayer() {
		return player;
	}
	
}
