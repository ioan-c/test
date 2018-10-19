package labirint;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
	
	private Map map;
	private Player player;
	
	public KeyboardListener(Map map, Player player) {
		this.map = map;
		this.player = player;
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
			if(!map.getMapCoordinates(player.getTileX(), player.getTileY()-1).equals(Constants.WALL) && !map.getMapCoordinates(player.getTileX(), player.getTileY()-1).equals(Constants.LIFE))
				player.move(0, -1);
		}
		
		if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
			if(!map.getMapCoordinates(player.getTileX(), player.getTileY()+1).equals(Constants.WALL) && !map.getMapCoordinates(player.getTileX(), player.getTileY()+1).equals(Constants.LIFE))
				player.move(0, 1);
		}
		
		if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
			if(!map.getMapCoordinates(player.getTileX()-1, player.getTileY()).equals(Constants.WALL) && !map.getMapCoordinates(player.getTileX()-1, player.getTileY()).equals(Constants.LIFE))
				player.move(-1, 0);
		}
		
		if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
			if(!map.getMapCoordinates(player.getTileX()+1, player.getTileY()).equals(Constants.WALL) && !map.getMapCoordinates(player.getTileX()+1, player.getTileY()).equals(Constants.LIFE))
				player.move(1, 0);
		}
		
	}

}
